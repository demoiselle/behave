package br.gov.frameworkdemoiselle.behave.dataprovider.dto;

import java.util.List;

/**
 * 
 * @author SERPRO
 * 
 */
public class Dataset {

	private List<DataRecord> dataRecords = null;

	public List<DataRecord> getDataRecords() {
		return dataRecords;
	}

	public void setDataRecords(List<DataRecord> records) {
		this.dataRecords = records;
	}
}
