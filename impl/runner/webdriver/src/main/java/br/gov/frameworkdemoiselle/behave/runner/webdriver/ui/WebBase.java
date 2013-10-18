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
package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.ui.MappedElement;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.ui.BaseUI;
import br.gov.frameworkdemoiselle.behave.runner.ui.Loading;
import br.gov.frameworkdemoiselle.behave.runner.ui.StateUI;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.ByConverter;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.SwitchDriver;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.Timer;

import com.google.common.base.Function;

public class WebBase extends MappedElement implements BaseUI {

	private List<String> locatorParameters;
	private static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);
	private SwitchDriver frame;
	private WebDriver driver;

	/**
	 * Função principal que pega o elemento da tela. Nova Funcionalidade: Agora ele busca o elemento em todos os frames
	 * 
	 * @return Lista de elementos encontrados
	 */
	public List<WebElement> getElements() {
		try {
			List<WebElement> elements = new ArrayList<WebElement>();
			for (String locator : getElementMap().locator()) {

				boolean found = false;

				locator = getLocatorWithParameters(locator);
				By by = ByConverter.convert(getElementMap().locatorType(), locator);
				driver = (WebDriver) runner.getDriver();
				frame = new SwitchDriver(driver);
				long startedTime = GregorianCalendar.getInstance().getTimeInMillis();
				while (true) {
					frame.bind();
					driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
					for (int i = 0; i < frame.countFrames(); i++) {
						frame.switchNextFrame();
						List<WebElement> elementsFound = driver.findElements(by);
						if (elementsFound.size() > 0) {
							for (WebElement element : elementsFound) {
								elements.add(element);
								found = true;
							}
							break;
						}
					}
					driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
					if (found) {
						break;
					}
					Thread.sleep(BehaveConfig.getRunner_ScreenMinWait());
					if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
						throw new BehaveException(message.getString("exception-element-not-found", getElementMap().name()));
					}
				}
			}
			return elements;
		} catch (BehaveException be) {
			throw be;
		} catch (InterruptedException e) {
			throw new BehaveException(message.getString("exception-thread-sleep"), e);
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-unexpected", e.getMessage()), e);
		}
	}

	private String getLocatorWithParameters(String locator) {

		if (getLocatorParameter() != null && !getLocatorParameter().isEmpty() && locator.matches(".*%param[0-9]+%.*")) {
			int n = 1;
			for (String parameter : getLocatorParameter()) {
				String tag = "%param" + n + "%";
				if (locator.contains(tag)) {
					locator = locator.replace(tag, parameter);
				}
				n++;
			}
		}
		return locator;
	}

	public String getText() {
		waitElement(0);

		return getElements().get(0).getText();
	}

	private static void waitThreadSleep(Long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException ex) {
			throw new BehaveException(message.getString("exception-thread-sleep"), ex);
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
				throw new BehaveException(message.getString("exception-invalid-option", state, "verifyState"));
			}

		}

		return retorno;
	}

	protected void waitElement(Integer index) {
		waitLoading();

		verifyState(StateUI.ENABLE);
		verifyState(StateUI.VISIBLE);

		final String locator = getLocatorWithParameters(getElementMap().locator()[index].toString());
		final By by = ByConverter.convert(getElementMap().locatorType(), locator);

		waitClickable(by);
		waitVisibility(by);

		// Getting around a WebDriver StaleElementReferenceException - issue
		// #101 - https://github.com/demoiselle/behave/issues/101
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS).pollingEvery(BehaveConfig.getRunner_ScreenMinWait(), TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
	}

	/**
	 * Método que verifica em todas as classes se existe um componente Loading, e se existir, ele sempre espera que este elemento desapareça antes de continuar.
	 */
	@SuppressWarnings("unchecked")
	private void waitLoading() {
		driver = (WebDriver) runner.getDriver();

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

		Reflections reflections = new Reflections("");
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(ScreenMap.class);

		for (Class<?> clazzI : annotatedClasses) {
			HashSet<Field> fields = (HashSet<Field>) ReflectionUtils.getAllFields(clazzI, ReflectionUtils.withAnnotation(ElementMap.class), ReflectionUtils.withTypeAssignableTo(Loading.class));
			if (fields.size() == 1) {
				for (Field field : fields) {
					ElementMap map = field.getAnnotation(ElementMap.class);

					boolean existeLoading;

					try {
						// Verifica se existe o LOADING
						ExpectedConditions.presenceOfElementLocated(ByConverter.convert(map.locatorType(), map.locator()[0])).apply(driver);

						existeLoading = true;
					} catch (Exception e) {
						existeLoading = false;
					}

					if (existeLoading) {
						// Aguardo o LOADING desaparecer!
						WebDriverWait wait = new WebDriverWait(getDriver(), (BehaveConfig.getRunner_ScreenMaxWait() / 1000));

						wait.until(ExpectedConditions.invisibilityOfElementLocated(ByConverter.convert(map.locatorType(), map.locator()[0])));
					}

					break;
				}
			}

		}

		driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
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

	public List<String> getLocatorParameter() {
		return locatorParameters;
	}

	public void setLocatorParameters(List<String> locatorParameter2) {
		this.locatorParameters = locatorParameter2;
	}

	/**
	 * Retorna um Driver executor de códigos Javascript. Verifica se o driver em uso possui a capacidade de executar códigos Javascript.
	 * 
	 * @return {@link JavascriptExecutor}
	 */
	public JavascriptExecutor getJavascirptExecutor() {
		if (!JavascriptExecutor.class.isAssignableFrom(this.runner.getDriver().getClass())) {
			throw new BehaveException(message.getString("exception-javascript-driver", runner.getDriver().getClass()));
		}
		return (JavascriptExecutor) this.runner.getDriver();
	}

	/**
	 * Retorna o ID do primeiro elemento de tela mapeado.
	 * 
	 * @return
	 */
	public String getId() {
		String id = getElements().get(0).getAttribute("id");
		if (id == null || id.isEmpty()) {
			throw new BehaveException(message.getString("exception-id-not-found", this.getElementMap().name()));
		}
		return id;
	}

	public void waitText(String text) {
		waitText(text, BehaveConfig.getRunner_ScreenMaxWait());
	}

	/**
	 * Neste método waitText estamos forçando que seja verificado dentro do body através de um loop controlado por nós e não pelo implicityWait do Webdriver. Por isso zeramos o implicityWait e depois voltamos para o valor padrão das propriedades.
	 */
	public void waitText(String text, Long timeout) {
		try {
			boolean found = false;

			driver = (WebDriver) runner.getDriver();
			frame = new SwitchDriver(driver);
			long startedTime = GregorianCalendar.getInstance().getTimeInMillis();

			while (true) {
				frame.bind();
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
				for (int i = 0; i < frame.countFrames(); i++) {
					frame.switchNextFrame();
					List<WebElement> elements = driver.findElements(By.tagName("body"));
					if (elements.size() > 0) {
						// Tem que percorrer todas as tags body, pode ter mais de uma!
						for (WebElement element : elements) {
							if (element.getText().contains(text)) {
								found = true;
								break;
							}
						}
					} else {
						if (driver.getPageSource().contains(text)) {
							found = true;
							break;
						}
					}
				}
				driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
				if (found) {
					break;
				}
				Thread.sleep(BehaveConfig.getRunner_ScreenMinWait());
				if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
					Assert.fail(message.getString("message-text-not-found", text));
				}
			}
		} catch (BehaveException be) {
			throw be;
		} catch (NoSuchFrameException ex) {
			throw new BehaveException(message.getString("exception-no-such-frame", frame.currentFrame(), ex));
		} catch (InterruptedException e) {
			throw new BehaveException(message.getString("exception-thread-sleep"), e);
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-unexpected", e.getMessage()), e);
		}
	}

}
