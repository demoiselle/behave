package br.gov.frameworkdemoiselle.behave.internal.dataprovider.xml;

import java.util.HashMap;
import java.util.Map;

import br.gov.frameworkdemoiselle.behave.dataprovider.DatasetLoader;
import br.gov.frameworkdemoiselle.behave.dataprovider.XmlLoader;
import br.gov.frameworkdemoiselle.behave.dataprovider.dto.DataItem;
import br.gov.frameworkdemoiselle.behave.dataprovider.dto.DataRecord;
import br.gov.frameworkdemoiselle.behave.dataprovider.dto.Dataset;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;

/**
 * 
 * @author SERPRO
 * 
 */
public class XmlDatasetLoader implements DatasetLoader {
	
	private static XmlLoader xmlLoader = (XmlLoader) InjectionManager.getInstance().getInstanceDependecy(XmlLoader.class);

	public Dataset load(String source) {
		return (Dataset) xmlLoader.importXmlResourceAsObject(source, getAliases(), getAttributes());
	}

	@SuppressWarnings("rawtypes")
	private Map<String, Class> getAliases() {
		Map<String, Class> aliases = new HashMap<String, Class>(); 
		aliases.put("DataSet", Dataset.class);
		aliases.put("DataItem", DataItem.class);
		aliases.put("DataRecord", DataRecord.class);
		return aliases;
	}
	
	@SuppressWarnings("rawtypes")
	private Map<String, Class> getAttributes() {
		Map<String, Class> attributes = new HashMap<String, Class>(); 
		attributes.put("id", String.class);
		attributes.put("type", String.class);
		attributes.put("key", String.class);
		attributes.put("value", String.class);
		return attributes;
	}


}
