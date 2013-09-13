package demoisellebehave.mix.steps;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

public class Frame {

	private WebDriver driver;
	private List<Node> nodes;

	public Frame(WebDriver driver) {
		this.driver = driver;
	}

	public void mapFrames() {
		nodes.clear();
		driver.switchTo().defaultContent();
		Node node = new Node(null, "root");		
		mapFrames(node);		
	}

	private void mapFrames(Node _parent) {
		_parent.switchDriver();
		Pattern pattern = Pattern.compile("(<frame(.*?)name=\")(.*?)(\")");
		Matcher matcher = pattern.matcher(driver.getPageSource());
		boolean hasChild = false;
		while (matcher.find()) {
			hasChild = true;
			Node frame = new Node(_parent, matcher.group(3));
			mapFrames(frame);
		}
		if (!hasChild) {
			nodes.add(_parent);
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
		private String name;

		public Node(Node parent, String name) {
			super();
			this.parent = parent;
			this.name = name;
		}

		/**
		 * Faz o driver navegar até o frame do no
		 */
		public void switchDriver() {
			if (isRoot()) {
				driver.switchTo().defaultContent();
			} else {
				parent.switchDriver();
				driver.switchTo().frame(name);
			}
		}

		@Override
		public String toString() {
			StringBuffer toSTring = new StringBuffer();
			if (isRoot()) {
				toSTring.append(name);
			} else {
				toSTring.append(parent).append("->");
				toSTring.append(name);
			}
			return toSTring.toString();
		}

		public boolean isRoot() {
			return (parent == null);
		}

	}
}
