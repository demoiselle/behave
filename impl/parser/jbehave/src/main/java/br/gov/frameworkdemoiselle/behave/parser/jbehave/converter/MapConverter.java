package br.gov.frameworkdemoiselle.behave.parser.jbehave.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;

/**
 * Converte uma String numa coleção do tipo {@link Map}. O texto deverá
 * seguir o padrão {nomeCampo1 => valorCampo1, nomeCampo2 => valorCampo2}.
 * 
 */
public class MapConverter implements ParameterConverter {

	private static final String REGEX = "\\s*?(([\\w\\S]{1,}\\s*?=>\\s*?[\\w\\S]*|\".*?\")[\\s,]*?)*\\s*?";

	public boolean accept(Type type) {
		if (type instanceof ParameterizedType) {
			Type rawType = rawType(type);
			Type[] argumentTypes = argumentTypes(type);
			return Map.class.isAssignableFrom((Class<?>) rawType) && String.class.isAssignableFrom((Class<?>) argumentTypes[0])
					&& Object.class.isAssignableFrom((Class<?>) argumentTypes[1]);
		}

		return false;
	}

	private Type[] argumentTypes(Type type) {
		return ((ParameterizedType) type).getActualTypeArguments();
	}

	protected Map<String, Object> buildDataMap(String value) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String[] pares = value.substring(0, value.length()).split(",");

		for (String par : pares) {
			String[] chaveValor = par.split("=>");							
			map.put(chaveValor[0].trim(), this.convertData(chaveValor[1].trim()));
		}

		return map;
	}
	
	protected Object convertData(String data) {
		if (StringUtils.isEmpty(data)) {
			return null;
		}

		Class<?> tipo = null;
		char lastChar = this.lastChar(data);

		try {
			if ((data.charAt(0) == '"') && (lastChar == '"')) {
				return data.substring(1, data.length() - 1);
			} else if (lastChar == 'L') {
				tipo = Long.class;
				return Long.parseLong(data.substring(0, data.length() - 1));
			} else if (lastChar == 'D') {
				tipo = Double.class;
				return Double.parseDouble(data.substring(0, data.length() - 1));
			} else if (lastChar == 'I') {
				tipo = Integer.class;
				return Integer.parseInt(data.substring(0, data.length() - 1));
			} else if (lastChar == 'F') {
				tipo = Float.class;
				return Float.parseFloat(data.substring(0, data.length() - 1));
			} else {
				throw new IllegalArgumentException(
						"Padrão do dado ('"
								+ data
								+ "') não bate com os tipos String, Long, Double, Integer e Float. Ex.: String => \"valor\", Long => 452154L, Double => 5487D etc.");
			}
		} catch (NumberFormatException ex) {
			String nomeTipo =  tipo == null ? "nulo" : tipo.getName();
			throw new BehaveException(String.format("Não foi possível converter o valor '%s' para '%s'", data, nomeTipo), ex);
		}
	}

	public Object convertValue(String value, Type type) {
		if (!this.valueMatchesRule(value)) {
			throw new BehaveException(String.format("O parâmetro '%s' da Tabela de Exemplos não bate com a expressão %s", value, REGEX));
		}

		return this.buildDataMap(value);
	}

	protected char lastChar(String data) {
		return (data.charAt(data.length() - 1));
	}

	private Type rawType(Type type) {
		return ((ParameterizedType) type).getRawType();
	}

	protected boolean valueMatchesRule(String value) {
		return (StringUtils.isEmpty(value) ? false : value.matches(REGEX));
	}
}