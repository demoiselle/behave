package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report;

public abstract class ReportBuilder {
	protected String pathToReport;

	public ReportBuilder(String pathToReport) {
		this.pathToReport = pathToReport;
	}

	public abstract void build(String reportFilename);

	public abstract void addResultRow(ResultRow resultRow);
}
