package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.apache.maven.plugin.logging.Log;

import br.gov.frameworkdemoiselle.behave.regression.report.ReportConfig;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.ComparisonStrategy;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.ReportBuilder;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.ReportType;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.ResultRow;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util.CommandBuilder;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util.FileNameComparator;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util.Image;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util.StreamGobbler;

public class ImageMagickCompare {

	private String diffScreenshotPath;
	private String pathToImCompareBinary;
	private String resultsFilePath;
	private ReportBuilder reportBuilder;
	private Log log;
	// private ReportConfig config;

	public ImageMagickCompare(ReportConfig config, Log log) {

		this.pathToImCompareBinary = "/usr/local/bin/compare";
		this.log = log;

		ReportType reportType = ReportType.HTML;
		resultsFilePath = getResultsFilePath(config, reportType);
		reportBuilder = ReportType.getReportBuilder(reportType, resultsFilePath);
	}

	private String getResultsFilePath(ReportConfig properties, ReportType reportType) {
		String extension = ReportType.getFileExtension(reportType);
		StringBuilder resultsFilePath = new StringBuilder();
		resultsFilePath.append(new File("target/dbehave").getAbsolutePath());
		resultsFilePath.append(File.separator + "report");
		resultsFilePath.append(".");
		resultsFilePath.append(extension);

		log.info("O relatório será salvo no seguinte path: file://" + resultsFilePath.toString());

		return resultsFilePath.toString();
	}

	public void compareAndCaptureResultsWithList(String reportFilename, List<File> actualFilesList, List<File> expectedFilesList) {

		File[] actualFiles = actualFilesList.toArray(new File[actualFilesList.size()]);
		File[] expectedFiles = expectedFilesList.toArray(new File[expectedFilesList.size()]);

		FileNameComparator fileNameComparator = new FileNameComparator();
		Arrays.sort(actualFiles, fileNameComparator);
		Arrays.sort(expectedFiles, fileNameComparator);

		try {

			for (int i = 0; i < expectedFiles.length; i++) {
				Image expectedImage = new Image(expectedFiles[i].getAbsolutePath());
				Image actualImage = new Image(actualFiles[i].getAbsolutePath());

				CommandBuilder commandBuilder = buildCommand(reportFilename, actualFiles[i], expectedFiles[i], expectedImage, actualImage);
				String commandOutput = executeCommandAndGetOutput(commandBuilder.getCommandAsArray());
				ResultRow resultRow = getResultRow(reportFilename, actualFiles[i], expectedFiles[i], expectedImage, actualImage, commandBuilder, commandOutput);
				reportBuilder.addResultRow(resultRow);
			}
			reportBuilder.build(reportFilename);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void checkIfDiffFolderExists() {
		File diffFolder = new File(diffScreenshotPath);
		try {
			if (!diffFolder.isDirectory()) {
				boolean makeDir = diffFolder.mkdir();
				if (!makeDir) {
					throw new RuntimeException("Failed to create diff images directory");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ResultRow getResultRow(String reportFilename, File actualFile, File expectedFile, Image expectedImage, Image actualImage, CommandBuilder commandBuilder, String commandOutput) throws IOException {
		ResultRow resultRow = new ResultRow();
		resultRow.setReportFileName(reportFilename);
		resultRow.setExpectedTotalPixels(expectedImage.getTotalPixels());
		resultRow.setActualTotalPixels(actualImage.getTotalPixels());
		resultRow.setExpectedFileName(expectedFile.getName());
		resultRow.setActualFileName(actualFile.getName());
		resultRow.setCommandExecuted(commandBuilder.toString());
		resultRow.setStrategyUsed(ComparisonStrategy.getStrategy(commandOutput));
		captureAndStoreResults(resultRow, commandOutput);
		return resultRow;
	}

	private CommandBuilder buildCommand(String reportFilename, File actualFile, File expectedFile, Image expectedImage, Image actualImage) {
		CommandBuilder commandBuilder = new CommandBuilder();
		commandBuilder.setPathToImageMagickCompareBinary(pathToImCompareBinary);
		commandBuilder.setFirstImagePixels(expectedImage.getTotalPixels());
		commandBuilder.setSecondImagePixels(actualImage.getTotalPixels());

		diffScreenshotPath = new File("target/dbehave").getAbsolutePath();

		log.info("diffScreenshotPath: " + diffScreenshotPath);

		checkIfDiffFolderExists();

		commandBuilder.setFilePaths(expectedFile.getAbsolutePath(), actualFile.getAbsolutePath(), diffScreenshotPath + File.separator + expectedFile.getName());
		commandBuilder.build();
		return commandBuilder;
	}

	private String executeCommandAndGetOutput(String[] command) throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec(command);
		StreamGobbler errorGobbler = gobbleStream(process);
		System.out.println("Exit Value: " + process.waitFor());

		System.out.println(errorGobbler.getOutputLine());

		return errorGobbler.getOutputLine();
	}

	private void captureAndStoreResults(ResultRow resultRow, String output) throws IOException {
		output = getFinalOutput(resultRow.getStrategyUsed(), output);
		BigDecimal percentageDeviation;
		if (resultRow.getExpectedTotalPixels().longValue() > resultRow.getActualTotalPixels().longValue()) {
			percentageDeviation = calculatePercentageDeviation(resultRow.getExpectedTotalPixels(), output);
		} else {
			percentageDeviation = calculatePercentageDeviation(resultRow.getActualTotalPixels(), output);
		}
		resultRow.setPercentageDeviation(percentageDeviation);
		resultRow.setOutput(output);
	}

	private String getFinalOutput(ComparisonStrategy strategy, String output) {
		if (strategy.equals(ComparisonStrategy.SUB_IMAGE)) {
			output = output.replace(output.substring(output.indexOf("@"), output.length()), "").trim();
		}
		return output;
	}

	private BigDecimal calculatePercentageDeviation(BigDecimal totalImagePixels, String output) throws IOException {
		BigDecimal percentageDeviation;
		try {
			BigDecimal pixelDifference = new BigDecimal(output);
			percentageDeviation = pixelDifference.divide(totalImagePixels, 4, RoundingMode.HALF_UP);
		} catch (Exception e) {
			percentageDeviation = BigDecimal.valueOf(-1);
		}
		return percentageDeviation.multiply(new BigDecimal(100));
	}

	private StreamGobbler gobbleStream(Process process) {
		StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "Error Stream");
		StreamGobbler outputGobbler = new StreamGobbler(process.getInputStream(), "Input Stream");
		errorGobbler.start();
		outputGobbler.start();
		return errorGobbler;
	}

}
