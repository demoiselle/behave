package br.gov.frameworkdemoiselle.behave.util;

import java.lang.reflect.Field;
import java.util.Set;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;

/*
 * TODO Refactoring da classe
 */
public class ReflectionUtil {

	public static String getLocation(String name) {
		Reflections reflections = new Reflections("");
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(ScreenMap.class);

		String urlFinal = "";

		for (Class<?> clazz : annotatedClasses) {
			ScreenMap annotation = clazz.getAnnotation(ScreenMap.class);
			if (annotation.name().equals(name)) {
				urlFinal = annotation.location();
				break;
			}
		}

		if (urlFinal.equals(""))
			throw new RuntimeException("Nenhuma Página foi encontrada com o nome [" + name + "].");

		return urlFinal;
	}

	@SuppressWarnings("unchecked")
	public static Class<?> getElementType(String pageName, String elementName) {
		Reflections reflections = new Reflections("");
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(ScreenMap.class);

		Class<?> clazz = null;

		for (Class<?> clazzI : annotatedClasses) {
			ScreenMap annotation = clazzI.getAnnotation(ScreenMap.class);
			if (annotation.name().equals(pageName)) {
				clazz = clazzI;
				break;
			}
		}

		if (clazz == null)
			throw new RuntimeException("Nenhuma Página foi encontrada com o nome [" + pageName + "].");

		Set<Field> fields = ReflectionUtils.getFields(clazz, ReflectionUtils.withAnnotation(ElementMap.class));

		Class<?> clazzF = null;

		for (Field fieldI : fields) {
			ElementMap annotation = fieldI.getAnnotation(ElementMap.class);
			if (annotation.name().equals(elementName)) {
				clazzF = fieldI.getType();
				break;
			}
		}

		if (clazzF == null)
			throw new RuntimeException("Nenhum E...");

		return clazzF;
	}

	@SuppressWarnings("unchecked")
	public static ElementMap getElementMap(String pageName, String elementName) {
		Reflections reflections = new Reflections("");
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(ScreenMap.class);

		Class<?> clazz = null;

		for (Class<?> clazzI : annotatedClasses) {
			ScreenMap annotation = clazzI.getAnnotation(ScreenMap.class);
			if (annotation.name().equals(pageName)) {
				clazz = clazzI;
				break;
			}
		}

		if (clazz == null)
			throw new RuntimeException("Nenhuma Página foi encontrada com o nome [" + pageName + "].");

		Set<Field> fields = ReflectionUtils.getFields(clazz, ReflectionUtils.withAnnotation(ElementMap.class));

		ElementMap map = null;

		for (Field fieldI : fields) {
			ElementMap annotation = fieldI.getAnnotation(ElementMap.class);
			if (annotation.name().equals(elementName)) {
				map = annotation;
				break;
			}
		}

		if (map == null)
			throw new RuntimeException("Nenhum Elemento foi encontrado com o nome [" + elementName + "] na página [" + pageName + "].");

		return map;
	}

}
