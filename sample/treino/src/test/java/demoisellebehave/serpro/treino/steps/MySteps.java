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
package demoisellebehave.serpro.treino.steps;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.CommonSteps;

public class MySteps extends CommonSteps {

	private DecimalFormat formatDecimal = new DecimalFormat("###.0");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private Logger logger = Logger.getLogger(MySteps.class);

	@Given("decremento \"$decremento\" centavos \"$variavel\"")
	public void decrementoCentavo(double decremento, String variavel) {
		try {
			// Obtem valor da variável do DataContainer
			String melhorValorString = (String) dataProvider.get(variavel);

			// Converte para double e decrementa
			double melhorValorDouble = formatDecimal.parse(melhorValorString)
					.doubleValue();
			melhorValorDouble -= decremento / 100;

			// Converta para String e retorna novo valor ao DataContainer
			melhorValorString = formatDecimal.format(melhorValorDouble)
					.replace(',', '.');

			logger.debug("Valor com decremento: " + melhorValorString);

			dataProvider.put(variavel, melhorValorString);
		} catch (ParseException e) {
			throw new BehaveException("Erro ao parsear número", e);
		}
	}

	@Given("decremento \"$dia\" dia \"$variavel\"")
	public void decrementoDia(int valor, String variavel) {
		try {
			// Obtem valor da variável do DataContainer
			String melhorDateString = (String) dataProvider.get(variavel);

			// Converte a string em data
			Date melhorData = dateFormat.parse(melhorDateString);

			// Decremenda em dias
			Calendar cl = GregorianCalendar.getInstance();
			cl.setTime(melhorData);
			cl.add(Calendar.DAY_OF_MONTH, -valor);

			melhorDateString = dateFormat.format(cl.getTime());

			logger.debug("Valor com decremento: " + melhorDateString);

			// Converte data para string e e retorna novo valor ao DataContainer
			dataProvider.put(variavel, melhorDateString);
		} catch (ParseException e) {
			throw new BehaveException("Erro ao parsear número", e);
		}
	}

}
