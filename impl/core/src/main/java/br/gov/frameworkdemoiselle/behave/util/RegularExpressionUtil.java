package br.gov.frameworkdemoiselle.behave.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionUtil {

	public static String getGroup(String regularExpression, String string, int group) {
		Pattern pattern = Pattern.compile(regularExpression);
		Matcher lMatcher = pattern.matcher(string);
		if (lMatcher.find()){
			return lMatcher.group(group);
		}
		return string;
	}

	public static Boolean matches(String regularExpression, String string) {
		return Pattern.matches(regularExpression, string.toUpperCase());
	}

	public static String replaceAll(String regularExpression, String string, String newValue) {
		List<String> matches = new ArrayList<String>();
		Pattern pattern = Pattern.compile(regularExpression);
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
			matches.add(matcher.group(1));
		}
		for(String item : matches){
			string = string.replace(item, newValue);
		}
		return string;
	}

}
