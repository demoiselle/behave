package br.gov.frameworkdemoiselle.behave.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Anotação utilizada para marcar as páginas utilizadas nas histórias.
 * 
 * @author 00968514901
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Page {

	/**
	 * Propriedade que determina o texto que irá na história para que a chamada
	 * da página ocorra.
	 */
	public String name();

	/**
	 * Propriedade que determina a URL que será chamada quando a propriedade
	 * name() for encontrada para determinada página.
	 */
	public String url();

}
