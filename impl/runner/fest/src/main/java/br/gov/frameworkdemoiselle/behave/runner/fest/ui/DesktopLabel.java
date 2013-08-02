package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import javax.swing.JLabel;

import br.gov.frameworkdemoiselle.behave.runner.ui.Label;

public class DesktopLabel extends DesktopBase implements Label {

	@Override
	public String getText() {
		return ((JLabel) getElement()).getText();
	}

}
