package br.gov.frameworkdemoiselle.behave.internal.dataprovider;

import br.gov.frameworkdemoiselle.behave.DataProvider;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

@SuppressWarnings("restriction")
public class DataContainer implements DataProvider {

	private static DataContainer dataContainer;
	private Hashtable data;

	private DataContainer() {
	}

	public static DataContainer getInstance() {
		if (dataContainer == null)
			dataContainer = new DataContainer();
		return dataContainer;
	}

	private Hashtable getData() {
		if (data == null)
			data = new Hashtable();
		return data;
	}

	public void addNewValue(String key, String value) {
		getData().remove(key);
		getData().put(key, value);
	}

	public String getValue(String key) {
		String str = (String) getData().get(key);
		return str;
	}

}
