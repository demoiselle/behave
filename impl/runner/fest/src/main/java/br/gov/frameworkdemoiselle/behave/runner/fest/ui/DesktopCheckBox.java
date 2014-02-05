package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import javax.swing.JCheckBox;

import org.fest.swing.fixture.JCheckBoxFixture;

import br.gov.frameworkdemoiselle.behave.runner.ui.CheckBox;

public class DesktopCheckBox extends DesktopBase implements CheckBox {

	@Override
	public void click() {
		JCheckBoxFixture checkBoxFix = new JCheckBoxFixture(runner.robot, (JCheckBox) getElement());
		
		checkBoxFix.click();
	}

}
