package br.gov.frameworkdemoiselle.behave.util;

import java.util.Set;

import org.reflections.Reflections;

import br.gov.frameworkdemoiselle.behave.annotation.Page;

public class ReflectionUtil {

	public static String getPageUrlByName(String name) {
		Reflections reflections = new Reflections("");
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Page.class);

		String urlFinal = "";

		for (Class<?> clazz : annotatedClasses) {
			Page annotation = clazz.getAnnotation(Page.class);
			if (annotation.name().equals(name)) {
				urlFinal = annotation.url();
				break;
			}
		}

		if (urlFinal.equals(""))
			throw new RuntimeException("Nenhuma Página foi encontrada com o nome [" + name + "].");

		return urlFinal;
	}
	
	

}
