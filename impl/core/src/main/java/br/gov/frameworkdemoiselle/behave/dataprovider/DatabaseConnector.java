package br.gov.frameworkdemoiselle.behave.dataprovider;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author SERPRO
 * 
 */
public interface DatabaseConnector {

	void openConnection() throws SQLException;

	void closeConnection() throws SQLException;

	ResultSet executeQuery(String query) throws SQLException;
	
}
