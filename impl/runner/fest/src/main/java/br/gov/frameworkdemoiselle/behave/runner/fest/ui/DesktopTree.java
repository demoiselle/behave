package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import javax.swing.JTree;

import org.fest.swing.fixture.JTreeFixture;

import br.gov.frameworkdemoiselle.behave.runner.ui.Tree;

public class DesktopTree extends DesktopBase implements Tree {

	public void clickTreeRow(int row) {
		JTree tree = (JTree) getElement();
		JTreeFixture treeFix = new JTreeFixture(runner.robot, tree);
		treeFix.clickRow(row - 1);
	}

}
