package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.ui.MappedElement;
import br.gov.frameworkdemoiselle.behave.runner.ui.Loading;
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
				// Utiliza implicity wait
				WebElement element = getDriver().findElement(by);
				elements.add(element);
			} catch (Throwable ex) {
				throw new BehaveException("O elemento [" + getElementMap().name() + "] não foi encontrado na página.");
			}
		}

		return elements;
	}

	public String getText() {
		waitElement(0);

		return getElements().get(0).getText();
	}

	private static void waitThreadSleep(Long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException ex) {
			throw new BehaveException("Thread sleep interrompido", ex);
		}
	}

	public boolean verifyState(StateUI state) {
		boolean retorno = false;

		waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());

		final Timer operationTimer = new Timer();
		operationTimer.start();

		Long maxWait = BehaveConfig.getRunner_ScreenMaxWait();

		while (!retorno && (maxWait > operationTimer.getTimeElapsed())) {

			waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());

			switch (state) {
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

	protected void waitElement(Integer index) {
		waitLoading();

		verifyState(StateUI.ENABLE);
		verifyState(StateUI.VISIBLE);
		waitClickable(ByConverter.convert(getElementMap().locatorType(), getElementMap().locator()[index].toString()));
		waitVisibility(ByConverter.convert(getElementMap().locatorType(), getElementMap().locator()[index].toString()));
	}

	/**
	 * Método que verifica em todas as classes se existe um componente Loading,
	 * e se existir, ele sempre espera que este elemento desapareça antes de
	 * continuar.
	 */
	@SuppressWarnings("unchecked")
	private void waitLoading() {
		Reflections reflections = new Reflections("");
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(ScreenMap.class);

		for (Class<?> clazzI : annotatedClasses) {
			HashSet<Field> fields = (HashSet<Field>) ReflectionUtils.getAllFields(clazzI, ReflectionUtils.withAnnotation(ElementMap.class), ReflectionUtils.withTypeAssignableTo(Loading.class));
			if (fields.size() == 1) {
				for (Field field : fields) {
					// Aguardo o LOADING!
					WebDriverWait wait = new WebDriverWait(getDriver(), (BehaveConfig.getRunner_ScreenMaxWait() / 1000));
					ElementMap map = field.getAnnotation(ElementMap.class);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(ByConverter.convert(map.locatorType(), map.locator()[0])));
					break;
				}
			}

		}
	}

	private void waitClickable(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), (BehaveConfig.getRunner_ScreenMaxWait() / 1000));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	private void waitVisibility(By by) {

		WebDriverWait wait = new WebDriverWait(getDriver(), (BehaveConfig.getRunner_ScreenMaxWait() / 1000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public WebDriver getDriver() {
		WebDriver driver = (WebDriver) getRunner().getDriver();
		return driver;
	}

}
