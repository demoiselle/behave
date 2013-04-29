package br.gov.frameworkdemoiselle.behave.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação utilizada para mapear os campos com os atributos dentro de uma página (Classe anotada com @Page).
 * 
 * TODO: Como iremos fazer com o locator? Pois normalmente é utilizado o @FindBy do org.openqa.selenium.support.
 * 
 * @author 00968514901
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.FIELD })
public @interface Field {
	
	public String name();
	
	public String locator();
	
    public String map();

}
