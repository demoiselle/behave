package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;

public class ResultRow {

	private String name;
	private String expectedBrowser;
	private String expectedFileName;
	private ComparisonStrategy strategyUsed;
	private List<BrowserResultColumn> browsers;

	public Map<String, String> getResultsAsMap() {
		Map<String, String> resultsMap = new LinkedHashMap<String, String>();
		resultsMap.put("Nome", "Nome");
		resultsMap.put("Imagem de Referência " + expectedBrowser, "");

		for (BrowserResultColumn browser : browsers) {
			resultsMap.put("Comparação com " + browser.getName(), "");
		}

		return resultsMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpectedBrowser() {
		return expectedBrowser;
	}

	public void setExpectedBrowser(String expectedBrowser) {
		this.expectedBrowser = expectedBrowser;
	}

	public String getExpectedFileName() {
		return expectedFileName;
	}
	
	public String getExpectedFileNameReport() {
		return FilenameUtils.getName(expectedFileName);
	}

	public void setExpectedFileName(String expectedFileName) {
		this.expectedFileName = expectedFileName;
	}

	public ComparisonStrategy getStrategyUsed() {
		return strategyUsed;
	}

	public void setStrategyUsed(ComparisonStrategy strategyUsed) {
		this.strategyUsed = strategyUsed;
	}

	public List<BrowserResultColumn> getBrowsers() {
		return browsers;
	}

	public void setBrowsers(List<BrowserResultColumn> browsers) {
		this.browsers = browsers;
	}

}
