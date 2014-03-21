package br.gov.serpro.treino.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import br.gov.framework.demoiselle.core.message.IMessage;
import br.gov.framework.demoiselle.core.message.Severity;

public enum ErrorMessage implements IMessage{
	
	REGISTER_DUPLICATED("register.duplicate"), 
	UNEXPECTED("error_unexpected"), 
	FIELD_NULL("field.null"),
	FIELD_UNIQUE("field.unique"),
	FIELD_ALL("field.null.all"),
	FILES_NOT_SELECTED("files.not.selected"), 
	TESTCASE_NOT_FOUND("testcase.not.found"), 
	CYCLIC_REFERENCE("cyclic.reference"), 
	ENVIRONMENT_NOT_INSERT("environment.not.insert"), 
	ENVIRONMENT_NOT_SELECTED("environment.not.selected"),	
	ID_NOT_FOUND("id.not.found"), 
	PROJECT_NOT_FOUND("project.not.found"), 
	INVALID_FILE("invalid.file"), 
	CHART_TYPE_NOT_FOUND("chart.type.not.found"), 
	IMPORT_NOT_FOUND("import.not.found"), 
	SAMPLE_TOTAL_NOT_FOUND("sample.total.not.found"), 
	USER_NOT_PERMISSION("user.not.permission"),
	USER_LOGIN("user.error.login"),
	SURVEY_FEEDBACK_JUSTIFICATION("survey.feedback.justification"), 
	PROPOSTA_RECUSADA("proposta.recusada");
	
	
	private String label;	
	private Collection<Object> params = new ArrayList<Object>();
	
	private ErrorMessage(String label) {
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
		return Severity.ERROR;
	}
	
	public String getResourceName() {
		return null;
	}
	

	
	public Object[] getParams(){
		return params.toArray();
	}

}
