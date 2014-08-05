package br.gov.frameworkdemoiselle.behave.dataprovider;

import br.gov.frameworkdemoiselle.behave.dataprovider.dto.Dataset;

/**
 * 
 * @author SERPRO
 * 
 */
public interface DatasetProvider {

	void load(String typeName, String source);
	
	void put(String typeName, Dataset dataSet);
	
	void setDataProviderCurrentRecord(String dataSetType, String recordId);

}
