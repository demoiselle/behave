package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import javax.swing.JMenu;

import org.fest.swing.fixture.JMenuItemFixture;

import br.gov.frameworkdemoiselle.behave.runner.ui.Menu;

public class DesktopMenu extends DesktopBase implements Menu {

	@Override
	public void click() {
		JMenuItemFixture menuFix = new JMenuItemFixture(runner.robot, (JMenu) getElement());
		menuFix.click();
	}

	@Override
	public void mouseOver() {
		runner.robot.moveMouse(getElement());
	}

}