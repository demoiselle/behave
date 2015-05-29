package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.plugin.logging.Log;

import com.google.common.io.Files;

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
	private String pathToImConvertBinary;
	private String resultsFilePath;
	private ReportBuilder reportBuilder;
	private Log log;

	private String prefixDiffPng = "pngdiff";
	private String prefixDiffGif = "gifdiff";
	private String prefixExpected = "expected";
	private String prefixOriginal = "orig";

	public ImageMagickCompare(ReportConfig config, Log log) {

		// this.pathToImCompareBinary = "/usr/local/bin/compare";
		// this.pathToImConvertBinary = "/usr/local/bin/convert";

		this.pathToImCompareBinary = "compare";
		this.pathToImConvertBinary = "convert";

		this.log = log;

		ReportType reportType = ReportType.HTML;
		resultsFilePath = getResultsFilePath(config, reportType);
		reportBuilder = ReportType.getReportBuilder(reportType, resultsFilePath);
	}

	private String getResultsFilePath(ReportConfig properties, ReportType reportType) {
		String extension = ReportType.getFileExtension(reportType);
		StringBuilder resultsFilePath = new StringBuilder();
		resultsFilePath.append(new File("target/dbehave").getAbsolutePath());
		resultsFilePath.append(File.separator + "index");
		resultsFilePath.append(".");
		resultsFilePath.append(extension);

		log.info("O relatório será salvo no seguinte path: file://" + resultsFilePath.toString());

		return resultsFilePath.toString();
	}

	public void compareAndCaptureResultsWithLists(List<String> types, List<List<File>> typesFilesList, String expectedType, List<File> expectedFilesList) {
		try {
			diffScreenshotPath = new File("target/dbehave").getAbsolutePath();

			checkIfDiffFolderExists();

			for (int i = 0; i < expectedFilesList.size(); i++) {
				List<BrowserResultColumn> browsersResults = new ArrayList<BrowserResultColumn>();

				// Arquivo original do navegador de referencia, sempre copia
				// pois pode ter sido modificado
				File expectedFileOriginal = expectedFilesList.get(i);
				String pathExpectedFile = diffScreenshotPath + File.separator + prefixExpected + "_" + expectedType + "__" + expectedFilesList.get(i).getName();

				// Pega a primeira tela do primeiro navegador
				for (int j = 0; j < types.size(); j++) {

					// Reinicia a imagem de referencia por causa dos
					// redimensionamentos
					File expectedFile = new File(pathExpectedFile);
					Files.copy(expectedFileOriginal, expectedFile);

					// Arquivo atual
					File currentFile = typesFilesList.get(j).get(i);
					String currentTypeName = types.get(j).replaceAll("^/", "");

					Image expectedImage = new Image(expectedFilesList.get(i).getAbsolutePath());
					Image currentImage = new Image(currentFile.getAbsolutePath());

					// log.info("diffScreenshotPath: " + diffScreenshotPath);

					// Arquivo original do navegador atual
					String pathOrigFile = diffScreenshotPath + File.separator + prefixOriginal + "_" + currentTypeName + "__" + expectedFilesList.get(i).getName();
					File newFileOriginal = new File(pathOrigFile);
					Files.copy(currentFile, newFileOriginal);

					// Trata o tamanho da imagem antes de rodar os comandos do
					// Image Magick
					try {
						ImageUtil.imageConvert(currentFile.getAbsolutePath(), expectedFile.getAbsolutePath());
					} catch (Exception e) {
						e.printStackTrace();
					}

					// Diff em PNG
					String pathDiffFile = diffScreenshotPath + File.separator + prefixDiffPng + "_" + currentTypeName + "__" + expectedFilesList.get(i).getName();
					CommandBuilder commandBuilder = buildCommand(currentFile, currentImage, expectedFile, expectedImage, pathDiffFile);
					String commandOutput = executeCommandAndGetOutput(commandBuilder.getCommandAsArray());

					// Diff em GIF
					String pathDiffFileGif = diffScreenshotPath + File.separator + prefixDiffGif + "_" + currentTypeName + "__" + FilenameUtils.removeExtension(expectedFilesList.get(i).getName()) + ".gif";
					CommandBuilder commandBuilderGif = buildCommandForGif(currentFile, currentImage, expectedFile, expectedImage, pathDiffFileGif);
					executeCommandAndGetOutput(commandBuilderGif.getCommandAsArray());

					// Linha do relatório
					browsersResults.add(new BrowserResultColumn(types.get(j), pathOrigFile, pathDiffFile, pathDiffFileGif, expectedImage.getTotalPixels(), currentImage.getTotalPixels(), commandOutput, ComparisonStrategy.ONE_TO_ONE));
				}

				ResultRow resultRow = getResultRow(FilenameUtils.removeExtension(expectedFilesList.get(i).getName()), expectedType, pathExpectedFile, browsersResults);

				reportBuilder.addResultRow(resultRow);

				reportBuilder.build(diffScreenshotPath);
			}
		} catch (IOException e) {
			log.error(e);
		} catch (InterruptedException e) {
			log.error(e);
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
			log.error(e);
		}
	}

	private ResultRow getResultRow(String nameStep, String expectedBrowser, String expectedFileName, List<BrowserResultColumn> browsers) throws IOException {
		ResultRow resultRow = new ResultRow();

		resultRow.setName(nameStep);
		resultRow.setExpectedBrowser(expectedBrowser);
		resultRow.setExpectedFileName(expectedFileName);
		resultRow.setBrowsers(browsers);

		return resultRow;
	}

	private CommandBuilder buildCommand(File currentFile, Image currentImage, File expectedFile, Image expectedImage, String pathDiffImageFile) {
		CommandBuilder commandBuilder = new CommandBuilder();
		commandBuilder.setPathToImageMagickCommandBinary(pathToImCompareBinary);
		commandBuilder.setFirstImagePixels(expectedImage.getTotalPixels());
		commandBuilder.setSecondImagePixels(expectedImage.getTotalPixels());

		commandBuilder.setFilePaths(currentFile.getAbsolutePath(), expectedFile.getAbsolutePath(), pathDiffImageFile);
		commandBuilder.build();
		return commandBuilder;
	}

	private CommandBuilder buildCommandForGif(File currentFile, Image currentImage, File expectedFile, Image expectedImage, String pathDiffImageFile) {
		CommandBuilder commandBuilder = new CommandBuilder();
		commandBuilder.setPathToImageMagickCommandBinary(pathToImConvertBinary);
		commandBuilder.setFilePaths(currentFile.getAbsolutePath(), expectedFile.getAbsolutePath(), pathDiffImageFile);
		commandBuilder.buildForGif();
		return commandBuilder;
	}

	private String executeCommandAndGetOutput(String[] command) throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec(command);
		StreamGobbler errorGobbler = gobbleStream(process);

		// Saídas do console
		log.debug("Saída do comando (Image Magick): " + process.waitFor());
		log.debug("Saída alternativa do comando (Image Magick): " + errorGobbler.getOutputLine());

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
