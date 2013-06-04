/*
 * Demoiselle Framework
 * Copyright (C) 2013 SERPRO
 * ----------------------------------------------------------------------------
 * This file is part of Demoiselle Framework.
 * 
 * Demoiselle Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 * ----------------------------------------------------------------------------
 * Este arquivo é parte do Framework Demoiselle.
 * 
 * O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
 * modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
 * do Software Livre (FSF).
 * 
 * Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
 * GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
 * APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
 * para maiores detalhes.
 * 
 * Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
 * "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
 * ou escreva para a Fundação do Software Livre (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */
package br.gov.frameworkdemoiselle.behave.integration.alm.autenticator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class Cipher {
	
	public static final String ENCONDING = "ISO-8859-1";

	/**
	 * Descriptografa uma mensagem a partir de uma chave
	 * @param content mensagem a ser descriptografada
	 * @param key chave
	 * @return mensagem descriptografada
	 */
	public static String decript(String content, String key) {
		return cript(content, key, 'D');
	}

	/**
	 * Criptografa uma mensagem a partir de uma chave
	 * @param content mensagem a ser criptografada
	 * @param key chave
	 * @return mensagem criptografada
	 */
	public static String cript(String content, String key) {
		return cript(content, key, 'C');
	}

	private static int[] RamdomKey() {
		int[] ret = new int[32];
		int valor;

		int cont = 0;

		for (int ct = 0; ct < 32; ct++) {
			ret[ct] = 0;
		}

		while (true) {
			valor = (int) (Math.random() * 256);
			ret[cont % 32] = (ret[cont % 32] + valor) % 256;
			cont++;

			if (cont == 3200) {
				break;
			}
		}

		return ret;
	}

	private static String cript(String content, String key, char mode) {
		String rt = null;
		try {
			if (key == null){
				throw new RuntimeException("chave vazia");
			}
			if (content == null){
				throw new RuntimeException("conteudo vazio");
			}
			InputStream in = new ByteArrayInputStream(content.getBytes(ENCONDING));

			ByteArrayOutputStream out = new ByteArrayOutputStream();

			int[] ch = new int[32];
			ch = Transform(stringHexa(makeHash(key, "SHA-256")));

			int cont = 0;
			String tmp = "";
			int op = 1;

			if (mode == 'C' || mode == 'c')
				op = 1;
			else
				op = -1;

			int x;
			int[] valores = new int[32];
			String xValores = "";

			if (op == 1) { // CIFRAGEM
				valores = RamdomKey();
				xValores = toString(valores);

				for (int pag = 0; pag < 32; pag++) {
					x = (ch[pag] + valores[pag]);
					if (x > 255) {
						x = x - 256;
					}
					if (x < 0) {
						x = x + 256;
					}

					out.write(x);
				}
			} else { // DECIFRAGEM
				for (int pag = 0; pag < 32; pag++) {
					x = in.read();
					x = x - ch[pag];

					if (x > 255) {
						x = x - 256;
					}
					if (x < 0) {
						x = x + 256;
					}

					valores[pag] = x;
				}
				xValores = toString(valores);
			}

			// Calcular nova sequencia da Chave!!!
			cont = 0;
			tmp = key;
			key = toString(ch);
			ch = Transform(stringHexa(makeHash(key + tmp, "SHA-256")));

			tmp = xValores;
			xValores = toString(valores);
			valores = Transform(stringHexa(makeHash(xValores + tmp, "SHA-256")));

			if (op == 1) {
				// Cifragem do arquivo...
				while ((x = in.read()) != -1) {

					x = (x + ch[cont] + valores[cont]) % 256;
					++cont;

					out.write(x);

					// Calcular nova sequencia da Chave!!!
					if (cont > 31) {
						cont = 0;
						tmp = key;
						key = toString(ch);
						ch = Transform(stringHexa(makeHash(key + tmp, "SHA-256")));

						tmp = xValores;
						xValores = toString(valores);
						valores = Transform(stringHexa(makeHash(xValores + tmp, "SHA-256")));
					}
				}
			} else {
				while ((x = in.read()) != -1) {
					x = x - ((ch[cont] + valores[cont]) % 256);
					++cont;

					if (x < 0) {
						x = x + 256;
					}
					out.write(x);

					if (cont > 31) {
						cont = 0;
						tmp = key;
						key = toString(ch);
						ch = Transform(stringHexa(makeHash(key + tmp, "SHA-256")));

						tmp = xValores;
						xValores = toString(valores);
						valores = Transform(stringHexa(makeHash(xValores + tmp, "SHA-256")));
					}
				}
			}
			in.close();
			rt = out.toString(ENCONDING);
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return rt;
	}

	private static byte[] makeHash(String content, String algor) {
		try {
			MessageDigest md = MessageDigest.getInstance(algor);
			md.update(content.getBytes(ENCONDING));
			return md.digest();
		} catch (Exception e) {
			throw new RuntimeException("erro makeHash");
		}
	}

	private static String stringHexa(byte[] bytes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
			int parteBaixa = bytes[i] & 0xf;
			if (parteAlta == 0)
				s.append('0');
			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		if (s.toString().length() != 64) {
			throw new RuntimeException("erro com SHA-256");
		}
		return s.toString();
	}

	private static int[] Transform(String input) {

		int[] ret = new int[32];
		int tam = input.length() - 1;
		int cont = 0;

		for (int ct = 0; ct < tam; ct = ct + 2) {

			int valor = 0, valor2 = 0;

			char r;
			int num, ct2;
			char[] car = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

			r = input.charAt(ct);
			num = 0;
			ct2 = 0;
			while (ct2 < 16) {
				num = (r == car[ct2]) ? ct2 * 16 : 0;
				valor = valor + num;
				++ct2;
			}

			r = input.charAt(ct + 1);
			num = 0;
			ct2 = 0;
			while (ct2 < 16) {
				num = (r == car[ct2]) ? ct2 : 0;
				valor2 = valor2 + num;
				++ct2;
			}

			ret[cont] = valor + valor2;
			++cont;
		}

		return ret;
	}

	private static String toString(int[] entrada) {
		String ret = "";
		int tam = entrada.length;
		for (int ct = 0; ct < tam; ct++) {
			ret = ret + (char) entrada[ct];
		}
		if (ret.length() != 32) {
			throw new RuntimeException("Erro inesperado!");
		}
		return ret;
	}
}