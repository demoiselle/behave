package br.gov.frameworkdemoiselle.behave.parser.cucumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {

    public static String loadFile(String pFilePath) throws IOException{
    	StringBuilder stringBuilder = new StringBuilder(); 
    	FileInputStream fileInputStream = new FileInputStream(new File(pFilePath));  
    	try {
    		String line = "";  
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));  
			while ((line = bufferedReader.readLine()) != null) {  
				stringBuilder.append(line).append("\n");  
			}  
			bufferedReader.close();
    	} finally {  
			fileInputStream.close();  
		}
    	return stringBuilder.toString();
	}
}
