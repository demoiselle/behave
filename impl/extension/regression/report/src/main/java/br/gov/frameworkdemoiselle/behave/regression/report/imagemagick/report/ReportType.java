package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report;

import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.html.HTMLReportBuilder;

public enum ReportType {
	HTML;

	public static String getFileExtension(ReportType type) {
		String extension = "";
		switch (type) {
		case HTML:
			extension = "html";
			break;
		default:
			extension = "html";
			break;
		}
		return extension;
	}

	public static ReportBuilder getReportBuilder(ReportType type, String pathToReport) {
		ReportBuilder reportBuilder = null;
		switch (type) {		
		case HTML:
			reportBuilder = new HTMLReportBuilder(pathToReport);
			break;
		default:
			reportBuilder = new HTMLReportBuilder(pathToReport);
			break;
		}
		return reportBuilder;
	}
}
