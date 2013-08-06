package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import javax.swing.JMenuItem;

import org.fest.swing.fixture.JMenuItemFixture;

import br.gov.frameworkdemoiselle.behave.runner.ui.MenuItem;

public class DesktopMenuItem extends DesktopBase implements MenuItem {

	@Override
	public void click() {
		JMenuItemFixture menuFix = new JMenuItemFixture(runner.robot, (JMenuItem) getElement());
		menuFix.click();

	}

	@Override
	public void mouseOver() {
		// TODO Auto-generated method stub

	}

}
