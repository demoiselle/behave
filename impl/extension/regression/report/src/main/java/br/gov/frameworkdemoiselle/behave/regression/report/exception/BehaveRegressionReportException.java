package br.gov.frameworkdemoiselle.behave.regression.report.exception;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;

public class BehaveRegressionReportException extends BehaveException {

	private static final long serialVersionUID = 1L;

	public BehaveRegressionReportException(String message, Throwable ex) {
		super(message, ex);
	}

	public BehaveRegressionReportException(String message) {
		super(message);
	}

	public BehaveRegressionReportException(Throwable e) {
		super(e);
	}

}