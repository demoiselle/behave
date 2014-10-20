package br.gov.frameworkdemoiselle.behave.controller;

public class ScenarioFilter extends Filter {
	private final String value;

	public ScenarioFilter(final String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}