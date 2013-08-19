package br.gov.frameworkdemoiselle.behave.runner.fest.util;

import java.lang.reflect.Field;
import java.util.Set;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.fest.annotation.ElementIndex;

public class DesktopReflectionUtil {

	@SuppressWarnings("unchecked")
	public static ElementIndex getElementIndex(String pageName, String elementName) {
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
			throw new RuntimeException("Nenhuma Tela foi encontrada com o nome [" + pageName + "].");

		Set<Field> fields = ReflectionUtils.getAllFields(clazz, ReflectionUtils.withAnnotation(ElementIndex.class));

		ElementIndex index = null;

		for (Field fieldI : fields) {
			ElementMap annotation = fieldI.getAnnotation(ElementMap.class);
			if (annotation.name().equals(elementName)) {
				index = fieldI.getAnnotation(ElementIndex.class);
				break;
			}
		}

		return index;
	}

}
