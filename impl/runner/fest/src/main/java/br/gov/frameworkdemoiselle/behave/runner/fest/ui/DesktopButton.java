package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import javax.swing.JButton;

import org.fest.swing.fixture.JButtonFixture;

import br.gov.frameworkdemoiselle.behave.runner.ui.Button;

public class DesktopButton extends DesktopBase implements Button {

	public void click() {		
		JButtonFixture buttonFix = new JButtonFixture(runner.robot, (JButton) getElement());
		buttonFix.click();
	}

	@Override
	public void mouseOver() {
		runner.robot.moveMouse(getElement());		
	}

}