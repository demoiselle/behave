package br.gov.frameworkdemoiselle.behave.parser.cucumber;

import java.util.List;

public class Scenario {
	
	private String identification;
	private String identificationWithoutParametersName;
	private String declaration;
	private List<String> sentences;
	private Boolean converted; //Indica que um cenário teve suas sentenças reutilizadas já injetadas
	
	public Scenario() {
	}
	
	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public List<String> getSentences() {
		return sentences;
	}

	public void setSentences(List<String> sentences) {
		this.sentences = sentences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identification == null) ? 0 : identification.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scenario other = (Scenario) obj;
		if (identification == null) {
			if (other.identification != null)
				return false;
		} else if (!identification.equals(other.identification))
			return false;
		return true;
	}

	public String getDeclaration() {
		return declaration;
	}

	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}

	public Boolean getConverted() {
		return converted;
	}

	public void setConverted(Boolean converted) {
		this.converted = converted;
	}

	public String getIdentificationWithoutParametersName() {
		return identificationWithoutParametersName;
	}

	public void setIdentificationWithoutParametersName(
			String identificationWithoutParametersName) {
		this.identificationWithoutParametersName = identificationWithoutParametersName;
	}

}
