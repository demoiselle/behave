package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import javax.swing.text.JTextComponent;

import org.fest.swing.fixture.JTextComponentFixture;

import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

public class DesktopTextField extends DesktopBase implements TextField {

	public void sendKeys(CharSequence... keysToSend) {
		JTextComponentFixture textFix = new JTextComponentFixture(runner.robot, (JTextComponent) getElement());

		for (CharSequence cs : keysToSend) {
			textFix.setText(cs.toString());
		}
	}

	public void sendKeysWithTries(CharSequence... keysToSend) {
		sendKeys(keysToSend);
	}

	public void clear() {
		sendKeys("");
	}

}
