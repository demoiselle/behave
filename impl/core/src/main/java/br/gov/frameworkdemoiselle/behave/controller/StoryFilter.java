package br.gov.frameworkdemoiselle.behave.controller;

public class StoryFilter extends Filter {
	private final String value;

	public StoryFilter(final String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}