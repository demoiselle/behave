package br.gov.frameworkdemoiselle.behave.dataprovider;

import br.gov.frameworkdemoiselle.behave.dataprovider.dto.Dataset;

/**
 * 
 * @author SERPRO
 * 
 */
public interface DatasetLoader {

	public Dataset load(String source);
	
}
