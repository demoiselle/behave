package br.gov.serpro.treino.exception;

import java.util.Locale;

import br.gov.framework.demoiselle.core.message.IMessage;
import br.gov.framework.demoiselle.core.message.Severity;

public enum InfoMessage implements IMessage {

	SAVE_OK("save.ok"), 
	DELETE_OK("delete.ok"), 
	REMOVE_ENVIRONMENT_GROUP("environment.remove.group"), 
	IMPORT_OK("import.ok"),
	SAVE_DATA("data.save.ok"), 
	PROPOSTA_ACEITA("proposta.aceita"), 
	CLEAN_OK("clean_ok");

	private String label;

	private InfoMessage(String label) {
		this.label = label;
	}

	public String getKey() {
		return label;
	}

	public String getLabel() {
		return label;
	}

	public Locale getLocale() {
		return new Locale("pt", "BR");
	}

	public Severity getSeverity() {
		return Severity.INFO;
	}

	public String getResourceName() {
		return null;
	}

}
