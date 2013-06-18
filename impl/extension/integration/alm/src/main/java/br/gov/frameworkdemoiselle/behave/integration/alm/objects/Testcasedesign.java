package br.gov.frameworkdemoiselle.behave.integration.alm.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Testcasedesign {

	@XmlAttribute
	private String extensionDisplayName;

	@XmlValue
	private String value;

	public String getExtensionDisplayName() {
		return extensionDisplayName;
	}

	public void setExtensionDisplayName(String extensionDisplayName) {
		this.extensionDisplayName = extensionDisplayName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
