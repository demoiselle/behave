package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CommandBuilder {
    private String pathToImageMagickCommandBinary;
    private final String METRIC_PARAMETER = "-metric";
    private final String METRIC_OPTION = "AE";
    private final String SUBIMAGE_SEARCH_OPTION = "-subimage-search";
    private final String DISSIMILAR_THRESHOLD = "-dissimilarity-threshold";
    private final String DISSIMILAR_THRESHOLD_VALUE = "100%";
    private String pathToFirstImage;
    private String pathToSecondImage;
    private String pathToDiffFile;
    private List<String> metrics;
    private List<String> commands;
    private BigDecimal firstImagePixels;
    private BigDecimal secondImagePixels;

    public CommandBuilder() {
        this.commands = new ArrayList<String>();
        this.metrics = new ArrayList<String>();
    }

    public void setPathToImageMagickCommandBinary(String pathToImageMagickCommandBinary) {
        this.pathToImageMagickCommandBinary = pathToImageMagickCommandBinary;
    }

    public void setMetricParameters(String... parameters) {
        for(String parameter : parameters) {
            this.metrics.add(parameter);
        }
    }

    private void setImageMetricParameters() {
        if(firstImagePixels.longValue() != secondImagePixels.longValue()) {
            setSubImageMetricParameters();
        } else {
            setOneToOneComparisonMetricParameters();
        }
    }

    public void setOneToOneComparisonMetricParameters() {
        this.metrics.clear();
        this.metrics.add(METRIC_PARAMETER);
        this.metrics.add(METRIC_OPTION);
    }

    public void setSubImageMetricParameters() {
        setOneToOneComparisonMetricParameters();
        this.metrics.add(SUBIMAGE_SEARCH_OPTION);
        this.metrics.add(DISSIMILAR_THRESHOLD);
        this.metrics.add(DISSIMILAR_THRESHOLD_VALUE);
    }

    public void setFilePaths(String pathToFirstImage, String pathToSecondImage, String pathToDiffFile) {
        this.pathToFirstImage = pathToFirstImage;
        this.pathToSecondImage = pathToSecondImage;
        this.pathToDiffFile = pathToDiffFile;
    }

    public BigDecimal getFirstImagePixels() {
        return firstImagePixels;
    }

    public void setFirstImagePixels(BigDecimal firstImagePixels) {
        this.firstImagePixels = firstImagePixels;
    }

    public BigDecimal getSecondImagePixels() {
        return secondImagePixels;
    }

    public void setSecondImagePixels(BigDecimal secondImagePixels) {
        this.secondImagePixels = secondImagePixels;
    }

    private String scapeWhiteSpaces(String path) {
    	return path.replaceAll(" ", "\\ ");
    }
    
    public void build() {
        this.commands.add(pathToImageMagickCommandBinary);
        setImageMetricParameters();
        this.commands.addAll(metrics);
        if(secondImagePixels.longValue() > firstImagePixels.longValue()) {
            this.commands.add(scapeWhiteSpaces(pathToSecondImage));
			this.commands.add(scapeWhiteSpaces(pathToFirstImage));
        } else {
            this.commands.add(scapeWhiteSpaces(pathToFirstImage));
            this.commands.add(scapeWhiteSpaces(pathToSecondImage));
        }
        this.commands.add(scapeWhiteSpaces(pathToDiffFile));
    }
    
    public void buildForGif() {
        this.commands.add(pathToImageMagickCommandBinary);
        
        this.commands.add("-delay");
        this.commands.add("100");
        
        this.commands.add("-dispose");
        this.commands.add("None");
        
        this.commands.add(scapeWhiteSpaces(pathToFirstImage));
        this.commands.add(scapeWhiteSpaces(pathToSecondImage));
        
        this.commands.add("-loop");
        this.commands.add("0");
        
        this.commands.add(scapeWhiteSpaces(pathToDiffFile));
    }

    public String toString() {
    	String commandRepresentation = "";
    	for(String command : getCommandAsArray())
    		commandRepresentation += (command + " ");
    	
    	// System.out.println("COMMAND: " + commandRepresentation);
    	
        return commandRepresentation.trim();
    }

    public String[] getCommandAsArray() {
        String[] commandsArray = new String[commands.size()];
        return this.commands.toArray(commandsArray);
    }
}
