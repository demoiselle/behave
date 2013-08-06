package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import javax.swing.JPopupMenu;

import org.fest.swing.fixture.JPopupMenuFixture;

import br.gov.frameworkdemoiselle.behave.runner.ui.Menu;

public class DesktopMenu extends DesktopBase implements Menu {

	@Override
	public void click() {
		JPopupMenuFixture menuFix = new JPopupMenuFixture(runner.robot, (JPopupMenu) getElement());
		menuFix.click();
	}

	@Override
	public void mouseOver() {
		
	}

}