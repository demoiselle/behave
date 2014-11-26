package br.gov.frameworkdemoiselle.behave.internal.dataprovider;

import java.util.Hashtable;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.dataprovider.DataProvider;
import br.gov.frameworkdemoiselle.behave.dataprovider.DatasetLoader;
import br.gov.frameworkdemoiselle.behave.dataprovider.DatasetProvider;
import br.gov.frameworkdemoiselle.behave.dataprovider.dto.DataItem;
import br.gov.frameworkdemoiselle.behave.dataprovider.dto.DataRecord;
import br.gov.frameworkdemoiselle.behave.dataprovider.dto.Dataset;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

/**
 * 
 * @author SERPRO
 * 
 */
public class DefaultDatasetProvider implements DatasetProvider {
	
	private static DatasetLoader datasetLoader = (DatasetLoader) InjectionManager.getInstance().getInstanceDependecy(DatasetLoader.class);

	private static DataProvider dataProvider = (DataProvider) InjectionManager.getInstance().getInstanceDependecy(DataProvider.class);
	
	private static Hashtable<String, Dataset> dataSets;
	
	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);
	
	public DefaultDatasetProvider() {
		super();
		dataSets = new Hashtable<String, Dataset>();
	}

	public void load(String typeName, String source) {
		Dataset dataSet = datasetLoader.load(source);
		put(typeName, dataSet);
	}

	public void put(String typeName, Dataset dataSet) {
		dataSets.put(typeName, dataSet);
	}

	public void setDataProviderCurrentRecord(String dataSetType, String recordId){
		DataRecord dataRecord = findDataRecord(dataSetType, recordId);
		for(DataItem dataItem : dataRecord.getDataItems()){
			dataProvider.put(dataItem.getKey(), dataItem.getValue());
		}
	}

	private DataRecord findDataRecord(String dataSetType, String recordId) {
		int dataRecordIndex = dataSets.get(dataSetType).getDataRecords().indexOf(new DataRecord(recordId));
		if(dataRecordIndex<0){
			throw new BehaveException(bm.getString("exception-record-id-not-found", recordId, dataSetType));
		}
		return dataSets.get(dataSetType).getDataRecords().get(dataRecordIndex);
	}

}
