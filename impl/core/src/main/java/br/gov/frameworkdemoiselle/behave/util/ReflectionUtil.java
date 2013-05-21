package br.gov.frameworkdemoiselle.behave.util;

import java.util.Set;

import org.reflections.Reflections;

import br.gov.frameworkdemoiselle.behave.annotation.PageMap;

public class ReflectionUtil {

	public static String getPageUrlByName(String name) {
		Reflections reflections = new Reflections("");
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(PageMap.class);

		String urlFinal = "";

		for (Class<?> clazz : annotatedClasses) {
			PageMap annotation = clazz.getAnnotation(PageMap.class);
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
