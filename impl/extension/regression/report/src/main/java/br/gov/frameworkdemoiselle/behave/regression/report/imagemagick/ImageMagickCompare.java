package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.logging.Log;

import br.gov.frameworkdemoiselle.behave.regression.report.ReportConfig;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.BrowserResultColumn;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.ComparisonStrategy;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.ReportBuilder;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.ReportType;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.report.ResultRow;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util.CommandBuilder;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util.Image;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util.ImageUtil;
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

	public void compareAndCaptureResultsWithLists(List<String> types, List<List<File>> typesFilesList, String expectedType, List<File> expectedFilesList) {
		try {
			// Faz todas as comparações
			// File[] expectedFiles = expectedFilesList.toArray(new
			// File[expectedFilesList.size()]);

			for (int i = 0; i < expectedFilesList.size(); i++) {
				List<BrowserResultColumn> browsersResults = new ArrayList<BrowserResultColumn>();

				// Pega a primeira tela do primeiro navegador
				for (int j = 0; j < types.size(); j++) {
					File currentFile = typesFilesList.get(j).get(i);

					Image expectedImage = new Image(expectedFilesList.get(i).getAbsolutePath());
					Image currentImage = new Image(currentFile.getAbsolutePath());

					diffScreenshotPath = new File("target/dbehave").getAbsolutePath();

					log.info("diffScreenshotPath: " + diffScreenshotPath);

					checkIfDiffFolderExists();

					String pathDiffFile = diffScreenshotPath + File.separator + types.get(j) + "__" + expectedFilesList.get(i).getName();

					try {
						// Tratamento da imagem
						ImageUtil.imageConvert(currentFile.getAbsolutePath(), expectedFilesList.get(i).getAbsolutePath());
					} catch (Exception e) {
						e.printStackTrace();
					}

					CommandBuilder commandBuilder = buildCommand(currentFile, currentImage, expectedFilesList.get(i), expectedImage, pathDiffFile);
					String commandOutput = executeCommandAndGetOutput(commandBuilder.getCommandAsArray());

					browsersResults.add(new BrowserResultColumn(types.get(j), pathDiffFile, "arquivo gif", expectedImage.getTotalPixels(), currentImage.getTotalPixels(), commandOutput, ComparisonStrategy.ONE_TO_ONE));
				}

				ResultRow resultRow = getResultRow(expectedType, expectedFilesList.get(i).getAbsolutePath(), browsersResults);

				reportBuilder.addResultRow(resultRow);

				reportBuilder.build("./target/dbehave/index.html");
			}
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

	private ResultRow getResultRow(String expectedBrowser, String expectedFileName, List<BrowserResultColumn> browsers) throws IOException {
		ResultRow resultRow = new ResultRow();

		resultRow.setName(new File(expectedFileName).getName());
		resultRow.setExpectedBrowser(expectedBrowser);
		resultRow.setExpectedFileName(expectedFileName);
		resultRow.setBrowsers(browsers);

		return resultRow;
	}

	private CommandBuilder buildCommand(File currentFile, Image currentImage, File expectedFile, Image expectedImage, String pathDiffImageFile) {
		CommandBuilder commandBuilder = new CommandBuilder();
		commandBuilder.setPathToImageMagickCompareBinary(pathToImCompareBinary);
		commandBuilder.setFirstImagePixels(expectedImage.getTotalPixels());
		commandBuilder.setSecondImagePixels(expectedImage.getTotalPixels());

		commandBuilder.setFilePaths(expectedFile.getAbsolutePath(), currentFile.getAbsolutePath(), pathDiffImageFile);
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

	private StreamGobbler gobbleStream(Process process) {
		StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "Error Stream");
		StreamGobbler outputGobbler = new StreamGobbler(process.getInputStream(), "Input Stream");
		errorGobbler.start();
		outputGobbler.start();
		return errorGobbler;
	}

}
