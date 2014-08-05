package br.gov.frameworkdemoiselle.behave.internal.dataprovider.xml;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.dataprovider.XmlLoader;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author SERPRO
 * 
 */
public class XStreamXmlLoader implements XmlLoader {

	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);
	
	protected XStream xstream = null;
	
	public XStreamXmlLoader(){
		xstream = new XStream();
	}
	
	@SuppressWarnings("rawtypes") 
	public Object importXmlResourceAsObject(String xmlResourceName, Map<String, Class> aliasesMap, Map<String, Class> attributesMap){
		defineAliases(aliasesMap);
		defineAttributes(attributesMap);
		return importResourceXml(xmlResourceName);
	}
	
	@SuppressWarnings("rawtypes") 
	private  void defineAttributes(Map<String, Class> attributesMap) {
		if(attributesMap!=null){
			Set<String> attributesSet = attributesMap.keySet();
			for (String attribute : attributesSet) {
				xstream.useAttributeFor(attribute, attributesMap.get(attribute));
			}
		}
	}

	@SuppressWarnings("rawtypes") 
	private  void defineAliases(Map<String, Class> aliasesMap) {
		if(aliasesMap!=null){
			Set<String> aliasesSet = aliasesMap.keySet();
			for (String alias : aliasesSet) {
				xstream.alias(alias, aliasesMap.get(alias));
			}
		}
	}

	private Object importResourceXml(String resourceName){
		String xml = loadRecource(resourceName);
		if(!xml.trim().equals("")){
			return xstream.fromXML(xml);	
		}
		return null;
	}
	
    private static String loadRecource(String resourceName){
    	StringBuilder stringBuilder = new StringBuilder();
    	try{
	    	InputStream inputStream = XStreamXmlLoader.class.getResourceAsStream(resourceName);  
	    	try {
	    		String line = "";  
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));  
				while ((line = bufferedReader.readLine()) != null) {  
					stringBuilder.append(line).append("\n");  
    			}  
	    	} catch (Exception f){
	    		throw new BehaveException(bm.getString("exception-resource-not-found", resourceName));
			} finally {  
				inputStream.close();  
			}
    	}catch (Exception e) {
    		throw new BehaveException(bm.getString("exception-resource-not-found", resourceName));
		}
    	return stringBuilder.toString();
	}
    
}