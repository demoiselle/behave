package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

public class DesktopTextField extends DesktopBase implements TextField {

	public void sendKeys(CharSequence... keysToSend) {
		System.out.println("ENVIA CARACTERES PARA O CAMPO");
	}

	public void sendKeysWithTries(CharSequence... keysToSend) {
		System.out.println("ENVIA CARACTERES PARA O CAMPO");
	}

	public void clear() {

	}

}
