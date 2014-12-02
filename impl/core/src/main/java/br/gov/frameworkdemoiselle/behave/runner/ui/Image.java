package br.gov.frameworkdemoiselle.behave.runner.ui;

import java.util.HashMap;

public interface Image extends BaseUI {
	
	/**
	 * Verifica se a imagem renderizada
	 * contém um valor definido em "src"
	 * 
	 * @param String src Endereço da imagem
	 */
	public void checkSource(String src);
	
	/**
	 * Verifica os valores dos atributos de uma tag
	 * img
	 * 
	 * @param HashMap<String,String> attrs Pares de chave=>valor de atributos html da tag img a serem verificados
	 */
	public void checkAttributes(HashMap<String, String> attrs);
}
