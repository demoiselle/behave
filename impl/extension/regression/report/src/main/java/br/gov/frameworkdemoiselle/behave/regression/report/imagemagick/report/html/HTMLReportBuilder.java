package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.html;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.ReportBuilder;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.ResultRow;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HTMLReportBuilder extends ReportBuilder {

	private List<ResultRow> resultRows = new ArrayList<ResultRow>();
	private List<String> columnHeaders = new ArrayList<String>();

	public HTMLReportBuilder(String pathToHtmlReport) {
		super(pathToHtmlReport);
	}

	public void build(String reportPath) {
		Writer file = null;
		Configuration configuration = new Configuration();

		try {

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Enumeration<URL> urls = loader.getResources("htmlreport.ftl");

			while (urls.hasMoreElements()) {
				URL url = (URL) urls.nextElement();
				InputStream initialStream = url.openStream();

				byte[] buffer = new byte[initialStream.available()];
				initialStream.read(buffer);

				File targetFile = new File("target/dbehave/htmlreport.ftl");
				FileOutputStream outStream = new FileOutputStream(targetFile);
				outStream.write(buffer);
				outStream.close();
			}

			configuration.setDirectoryForTemplateLoading(new File(reportPath));

			Template template = configuration.getTemplate("htmlreport.ftl");
			Map<String, Object> input = new HashMap<String, Object>();
			input.put("columnHeaders", columnHeaders);
			input.put("resultRows", resultRows);

			file = new FileWriter(new File(pathToReport));

			// ("REPORT: " + pathToReport);

			template.process(input, file);
			file.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (Exception fileException) {
				}
			}
		}
	}

	@Override
	public void addResultRow(final ResultRow resultRow) {
		resultRows.add(resultRow);
		
		Map<String, String> columnValues = resultRow.getResultsAsMap();
		if (columnHeaders.size() == 0) {
			for (String headerValue : columnValues.keySet()) {
				columnHeaders.add(headerValue);
			}
		}
	}
}
