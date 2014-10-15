package br.gov.frameworkdemoiselle.behave.controller;

public abstract class Filter {
	public static Filter story(String value) {
		return new StoryFilter(value);
	}

	public static Filter scenario(String value) {
		return new ScenarioFilter(value);
	}

	public abstract String getValue();
}