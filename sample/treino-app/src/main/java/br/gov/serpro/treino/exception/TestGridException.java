package br.gov.serpro.treino.exception;

import br.gov.framework.demoiselle.core.exception.ApplicationRuntimeException;
import br.gov.framework.demoiselle.core.message.IMessage;

public class TestGridException extends ApplicationRuntimeException {

	private static final long serialVersionUID = 1L;

	private String[] params;

	public TestGridException(IMessage objectMessage) {
		super(objectMessage);
	}

	public TestGridException(IMessage objectMessage, String[] param) {
		super(objectMessage);
		params = param;
	}

	public TestGridException(IMessage message, Throwable t) {
		super(message, t);
	}

	public TestGridException(IMessage message, Throwable e, String[] param) {
		super(message, e);
		this.params = param;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

}
