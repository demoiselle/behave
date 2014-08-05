package br.gov.frameworkdemoiselle.behave.dataprovider;

import java.util.Map;

/**
 * 
 * @author SERPRO
 * 
 */
public interface XmlLoader {

	@SuppressWarnings("rawtypes")
	Object importXmlResourceAsObject(String xmlResourceName,
			Map<String, Class> aliasesMap, Map<String, Class> attributesMap);

}
