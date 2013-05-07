package br.gov.frameworkdemoiselle.behave.parser;

import java.util.List;

public interface Parser {

	public void run() throws Throwable;

	List<String> storyPaths();

}