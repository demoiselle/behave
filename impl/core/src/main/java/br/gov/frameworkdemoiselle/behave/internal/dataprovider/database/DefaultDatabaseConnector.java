package br.gov.frameworkdemoiselle.behave.internal.dataprovider.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.dataprovider.DatabaseConnector;

/**
 * 
 * @author SERPRO
 * 
 */
public class DefaultDatabaseConnector implements DatabaseConnector {

	private Connection connection;
	
	public void openConnection() throws SQLException {
		String connectionString = BehaveConfig.getProperty("behave.core.dataset.database.connectionString");
		connection = DriverManager.getConnection(connectionString);
	}
	
	public void closeConnection() throws SQLException {
		if(connection!=null){
			connection.close();
		}
	}
	
	public ResultSet executeQuery(String query) throws SQLException{
		Statement statement = connection.createStatement();
        return statement.executeQuery(query);
	}
	
}
