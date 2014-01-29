package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

public class DesktopLink extends DesktopBase implements Link {

	@Override
	public void click() {
		runner.robot.click(getElement());
	}

}
