package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.internal.ui.MappedElement;
import br.gov.frameworkdemoiselle.behave.runner.ui.base.BaseUI;
import br.gov.frameworkdemoiselle.behave.runner.ui.base.StateUI;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.ByConverter;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.Timer;

public class WebBase extends MappedElement implements BaseUI {

	public List<WebElement> getElements() {
		List<WebElement> elements = new ArrayList<WebElement>();

		for (String locator : getElementMap().locator()) {
			By by = ByConverter.convert(getElementMap().locatorType(), locator);

			try {
				WebElement element = (WebElement) ((WebDriver) runner.getDriver()).findElement(by);
				elements.add(element);
			} catch (NoSuchElementException ex) {
				throw new RuntimeException("O element [" + getElementMap().name() + "] não foi encontrado na página.");
			}

		}
		return elements;
	}

	public String getText() {
		return getElements().get(0).getText();
	}

	public static void waitThreadSleep(Long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public boolean verifyState(StateUI state) {
		boolean retorno = false;

		waitThreadSleep(BehaveConfig.BROWSER_MIN_WAIT);

		final Timer operationTimer = new Timer();
		operationTimer.start();

		Long maxWait = BehaveConfig.BROWSER_MAX_WAIT;

		while (!retorno && (maxWait > operationTimer.getTimeElapsed())) {

			waitThreadSleep(BehaveConfig.BROWSER_MIN_WAIT);

			switch (state) {
			case PRESENT:
				// TODO como tratar elemento presente
				// retorno = selenium.isElementPresent(id);
				throw new RuntimeException("Opcao não implementada.");
				// break;

			case ABSENT:
				// TODO como tratar elemento não presente
				// retorno = !selenium.isElementPresent(id);
				throw new RuntimeException("Opcao não implementada.");
				// break;

			case VISIBLE:
				retorno = getElements().get(0).isDisplayed();
				break;

			case INVISIBLE:
				retorno = !getElements().get(0).isDisplayed();
				break;

			case ENABLE:
				retorno = getElements().get(0).isEnabled();
				break;

			case DISABLE:
				retorno = !getElements().get(0).isEnabled();
				break;

			default:
				throw new RuntimeException("Opcao errada para metodo 'verifyStateUI'.");
			}

		}

		return retorno;
	}

}
