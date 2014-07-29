package br.gov.frameworkdemoiselle.behave.internal.dataprovider.database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.dataprovider.DatabaseConnector;
import br.gov.frameworkdemoiselle.behave.dataprovider.DatasetLoader;
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
public class DatabaseDatasetLoader implements DatasetLoader {
	
	private static DatabaseConnector databaseConnector = (DatabaseConnector) InjectionManager.getInstance().getInstanceDependecy(DatabaseConnector.class);
	
	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);

	public Dataset load(String tableName){
		try {
			databaseConnector.openConnection();
			ResultSet resultSet = databaseConnector.executeQuery("select * from "+tableName);
			databaseConnector.closeConnection();
			return createDataSet(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BehaveException(bm.getString("exception-database-error", e));
		} 
	}

	private Dataset createDataSet(ResultSet resultSet) throws SQLException {
		Dataset dataset = new Dataset();
		dataset.setDataRecords(new ArrayList<DataRecord>());
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		while(resultSet.next()){
			dataset.getDataRecords().add(createDataRecord(resultSet, resultSetMetaData, columnCount));
		}
		return dataset;
	}

	private DataRecord createDataRecord(ResultSet resultSet,ResultSetMetaData resultSetMetaData, int columnCount) throws SQLException {
		String id = resultSet.getString("id");
		DataRecord dataRecord = new DataRecord(id);
		dataRecord.setDataItems(new ArrayList<DataItem>());
		for(int i=1; i<columnCount;i++){
			dataRecord.getDataItems().add(createDataItem(resultSet, resultSetMetaData, i));
		}
		return dataRecord;
	}

	private DataItem createDataItem(ResultSet resultSet, ResultSetMetaData resultSetMetaData, int i) throws SQLException {
		String key = resultSetMetaData.getColumnName(i);
		String value = resultSet.getObject(i).toString();
		return new DataItem(key, value);
	}

}
