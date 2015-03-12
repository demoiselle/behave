package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamGobbler extends Thread {
    private InputStream inputStream;
    private String outputLine = "";
    private String type;

    public StreamGobbler(InputStream inputStream, String type) {
        this.inputStream = inputStream;
        this.type = type;
    }

    public void run() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                outputLine += line;
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String getOutputLine() {
        return outputLine;
    }
    
    public String getType() {
    	return type;
    }
}