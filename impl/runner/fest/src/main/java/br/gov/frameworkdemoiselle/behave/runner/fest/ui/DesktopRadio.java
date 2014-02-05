package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import javax.swing.JRadioButton;

import org.fest.swing.fixture.JRadioButtonFixture;

import br.gov.frameworkdemoiselle.behave.runner.ui.Radio;

public class DesktopRadio extends DesktopBase implements Radio {

	@Override
	public void click() {
		JRadioButtonFixture radioFix = new JRadioButtonFixture(runner.robot, (JRadioButton) getElement());
		
		radioFix.click();
	}

}
