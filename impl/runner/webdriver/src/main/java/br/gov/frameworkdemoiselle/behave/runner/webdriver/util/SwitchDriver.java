/*
 * Demoiselle Framework
 * Copyright (C) 2013 SERPRO
 * ----------------------------------------------------------------------------
 * This file is part of Demoiselle Framework.
 * 
 * Demoiselle Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 * ----------------------------------------------------------------------------
 * Este arquivo é parte do Framework Demoiselle.
 * 
 * O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
 * modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
 * do Software Livre (FSF).
 * 
 * Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
 * GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
 * APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
 * para maiores detalhes.
 * 
 * Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
 * "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
 * ou escreva para a Fundação do Software Livre (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */
package br.gov.frameworkdemoiselle.behave.runner.webdriver.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

public class SwitchDriver {

	private WebDriver driver;
	private List<Node> nodes;
	private int nextFrame = 0;
	private int frameIndex = 0;

	public SwitchDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void bind() {
		nodes = new ArrayList<SwitchDriver.Node>();
		driver.switchTo().defaultContent();
		Node node = new Node(null, 0, "root");
		nodes.add(node);
		bindNodes(node);
	}

	/**
	 * Move o driver para seus diversos frames
	 */
	public void switchNextFrame() {
		Node node = nodes.get(nextFrame);
		node.switchDriver();
		nextFrame = (nextFrame == nodes.size() - 1) ? 0 : (nextFrame + 1);
	}

	public int countFrames() {
		return nodes.size();
	}

	private void bindNodes(Node _parent) {
		bindNodes(_parent, "(<frame (.*?)>)");
		bindNodes(_parent, "(<iframe (.*?)>)");
	}

	private void bindNodes(Node _parent, String regex) {
		_parent.switchDriver();
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		String pageSource = driver.getPageSource();
		Matcher matcher = pattern.matcher(pageSource);
		int index = -1;
		while (matcher.find()) {

			// Continua contando os índices mesmo não adicionando
			int indexAux = ++index;

			// Somente adiciona os frames que possuem SRC
			if (matcher.group().toLowerCase().contains("src=\"")) {
				Node frame = new Node(_parent, indexAux, "" + frameIndex++);
				nodes.add(frame);
				bindNodes(frame);
			}
		}
	}

	@Override
	public String toString() {
		StringBuffer toSTring = new StringBuffer();
		for (Node node : nodes) {
			toSTring.append(node);
		}
		return toSTring.toString();
	}

	private class Node {

		private Node parent;
		private int frame;
		private String src;

		public Node(Node parent, int frame, String src) {
			super();
			this.parent = parent;
			this.frame = frame;
			this.src = src;
		}

		/**
		 * Faz o driver navegar até o frame do no
		 */
		public void switchDriver() {
			if (isRoot()) {
				driver.switchTo().defaultContent();
			} else {
				parent.switchDriver();
				driver.switchTo().frame(frame);
			}
		}

		@Override
		public String toString() {
			StringBuffer toSTring = new StringBuffer();
			if (isRoot()) {
				toSTring.append("[").append(frame).append(":").append(src).append("]");
			} else {
				toSTring.append(parent).append("->[").append(frame).append(":").append(src).append("]");
			}
			return toSTring.toString();
		}

		public boolean isRoot() {
			return (parent == null);
		}

	}

	public String currentFrame() {
		return nodes.get(nextFrame).toString();
	}
}
