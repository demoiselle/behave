package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultRow {
	
	private String reportFileName;
	private String expectedFileName;
	private String actualFileName;
	private BigDecimal expectedTotalPixels;
	private BigDecimal actualTotalPixels;
	private BigDecimal percentageDeviation;
	private String output;
	private ComparisonStrategy strategyUsed;
	private String notes;
	private String commandExecuted;

	public Map<String, String> getResultsAsMap() {
		Map<String, String> resultsMap = new LinkedHashMap<String, String>();
		resultsMap.put("Expected Filename", expectedFileName);
		resultsMap.put("Actual Filename", actualFileName);
		resultsMap.put("Total Image Pixels [Expected] (width * height)", expectedTotalPixels.toString());
		resultsMap.put("Total Image Pixels [Actual] (width * height)", actualTotalPixels.toString());
		resultsMap.put("Diff Outcome (Pixel Difference)", output);
		resultsMap.put("Pixel Deviation (%)", percentageDeviation.toString());
		resultsMap.put("Comparison Strategy Used", strategyUsed.getValue());
		resultsMap.put("Notes", notes);
		resultsMap.put("Command Executed", commandExecuted);
		return resultsMap;
	}

	public BigDecimal getExpectedTotalPixels() {
		return expectedTotalPixels;
	}

	public void setExpectedTotalPixels(BigDecimal expectedTotalPixels) {
		this.expectedTotalPixels = expectedTotalPixels;
	}

	public BigDecimal getActualTotalPixels() {
		return actualTotalPixels;
	}

	public void setActualTotalPixels(BigDecimal actualTotalPixels) {
		this.actualTotalPixels = actualTotalPixels;
	}

	public BigDecimal getPercentageDeviation() {
		return percentageDeviation;
	}

	public void setPercentageDeviation(BigDecimal percentageDeviation) {
		this.percentageDeviation = percentageDeviation;
	}

	public String getReportFileName() {
		return reportFileName;
	}

	public void setReportFileName(String reportFileName) {
		this.reportFileName = reportFileName;
	}

	public String getExpectedFileName() {
		return expectedFileName;
	}

	public void setExpectedFileName(String expectedFileName) {
		this.expectedFileName = expectedFileName;
	}

	public String getActualFileName() {
		return actualFileName;
	}

	public void setActualFileName(String actualFileName) {
		this.actualFileName = actualFileName;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public ComparisonStrategy getStrategyUsed() {
		return strategyUsed;
	}

	public void setStrategyUsed(ComparisonStrategy strategyUsed) {
		this.strategyUsed = strategyUsed;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCommandExecuted() {
		return commandExecuted;
	}

	public void setCommandExecuted(String commandExecuted) {
		this.commandExecuted = commandExecuted;
	}
}
