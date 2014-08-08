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

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
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
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.ui.BaseUI;
import br.gov.frameworkdemoiselle.behave.runner.ui.Loading;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.ByConverter;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.SwitchDriver;

public class WebBase extends MappedElement implements BaseUI {

	private List<String> locatorParameters;
	private static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);
	private SwitchDriver frame;
	private WebDriver driver;
	Logger log = Logger.getLogger(WebBase.class);

	static ElementMap loadingMap = null;
	static boolean alreadySearchLoadingMap = false;

	/**
	 * Função principal que pega o elemento da tela. Nova Funcionalidade: Agora
	 * ele busca o elemento em todos os frames
	 * 
	 * @return Lista de elementos encontrados
	 */
	public List<WebElement> getElements() {
		try {

			driver = (WebDriver) runner.getDriver();

			List<WebElement> elements = new ArrayList<WebElement>();
			for (String locator : getElementMap().locator()) {

				// Locators
				locator = getLocatorWithParameters(locator);
				By by = ByConverter.convert(getElementMap().locatorType(), locator);

				// Todas as buscas por elemento tem seu timeout controlado pelo
				// Demoiselle Behave
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

				try {

					// Primeiro tenta encontrar na página sem frame sem Timeout
					List<WebElement> elementsFound = driver.findElements(by);
					if (elementsFound.size() > 0) {
						for (WebElement element : elementsFound) {
							elements.add(element);
						}
					} else {
						// Se não encontrar nada sem frames busca nos frames
						elements = getElementsWithFrames(driver, by);
					}

				} catch (Throwable t) {
					// Se não encontrar nada sem frames busca nos frames
					elements = getElementsWithFrames(driver, by);
				} finally {
					driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
				}

			}

			return elements;
		} catch (BehaveException be) {
			throw be;
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-unexpected", e.getMessage()), e);
		}
	}

	private List<WebElement> getElementsWithFrames(WebDriver driver, By by) {
		List<WebElement> elements = new ArrayList<WebElement>();
		boolean found = false;

		frame = getSwitchDriver(driver);

		long startedTime = GregorianCalendar.getInstance().getTimeInMillis();
		while (true) {
			frame.bind();

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

			if (found) {
				break;
			}
			waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());
			if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
				throw new BehaveException(message.getString("exception-element-not-found", getElementMap().name()));
			}
		}

		return elements;
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

	protected static void waitThreadSleep(Long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException ex) {
			throw new BehaveException(message.getString("exception-thread-sleep"), ex);
		}
	}

	protected void waitElement(Integer index) {
		// Locators
		final String locator = getLocatorWithParameters(getElementMap().locator()[index].toString());
		final By by = ByConverter.convert(getElementMap().locatorType(), locator);

		// Aguarda o loading
		waitLoading();

		// Espera ser visível e clicável
		waitClickable(by);
		
		// Esta verificação é necessária mesmo que dentro do clickable ele já faça
		waitVisibility(by);
	}

	protected void waitElementOnlyVisible(Integer index) {
		waitLoading();

		final String locator = getLocatorWithParameters(getElementMap().locator()[index].toString());
		final By by = ByConverter.convert(getElementMap().locatorType(), locator);

		waitVisibility(by);
	}

	/**
	 * Método que verifica em todas as classes se existe um componente Loading,
	 * e se existir, ele sempre espera que este elemento desapareça antes de
	 * continuar.
	 */
	@SuppressWarnings("unchecked")
	private void waitLoading() {

		driver = (WebDriver) runner.getDriver();

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

		if (loadingMap == null && !alreadySearchLoadingMap) {

			alreadySearchLoadingMap = true;

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

							loadingMap = map;

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
		} else if (loadingMap != null) {			
			// Cache do elementMap
			WebDriverWait wait = new WebDriverWait(getDriver(), (BehaveConfig.getRunner_ScreenMaxWait() / 1000));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(ByConverter.convert(loadingMap.locatorType(), loadingMap.locator()[0])));
		}

		driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
	}

	private void findFrameContainingElement(By by) {
		// Primeiro encontra o frame que o elemento esta, para depois esperar
		// ele
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		frame = getSwitchDriver(driver);
		long startedTime = GregorianCalendar.getInstance().getTimeInMillis();
		boolean found = false;

		while (true) {
			frame.bind();

			for (int i = 0; i < frame.countFrames(); i++) {
				frame.switchNextFrame();
				List<WebElement> elementsFound = driver.findElements(by);
				if (elementsFound.size() > 0) {
					found = true;
					break;
				}
			}

			if (found) {
				break;
			}

			waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());

			if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
				throw new BehaveException(message.getString("exception-element-not-found", getElementMap().name()));
			}
		}
		driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
	}

	// condition 'clickable' is equivalent to 'visible and enabled'
	// https://code.google.com/p/selenium/issues/detail?id=6804
	private void waitClickable(By by) {
		findFrameContainingElement(by);

		// Faz a verificação no FRAME selecionado
		WebDriverWait wait = new WebDriverWait(getDriver(), (BehaveConfig.getRunner_ScreenMaxWait() / 1000));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	private void waitVisibility(By by) {
		findFrameContainingElement(by);

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
	 * Retorna um Driver executor de códigos Javascript. Verifica se o driver em
	 * uso possui a capacidade de executar códigos Javascript.
	 * 
	 * @return {@link JavascriptExecutor}
	 */
	public JavascriptExecutor getJavascriptExecutor() {
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

	private SwitchDriver getSwitchDriver(WebDriver driver) {
		frame = new SwitchDriver(driver);
		return frame;
	}

	/**
	 * Neste método waitText estamos forçando que seja verificado dentro do body
	 * através de um loop controlado por nós e não pelo implicityWait do
	 * Webdriver. Por isso zeramos o implicityWait e depois voltamos para o
	 * valor padrão das propriedades.
	 */
	public void waitText(String text, Long timeout) {
		try {
			// Flag utilizada para o segundo laço
			boolean found = false;

			driver = (WebDriver) runner.getDriver();
			frame = getSwitchDriver(driver);
			long startedTime = GregorianCalendar.getInstance().getTimeInMillis();

			while (true) {
				frame.bind();
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
				for (int i = 0; i < frame.countFrames(); i++) {
					frame.switchNextFrame();

					// Busca em todo o texto da página, independente do local
					if (driver.getPageSource().contains(text)) {
						found = true;
						break;
					}

				}
				driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);

				// Sai do segundo laço
				if (found) {
					break;
				}

				waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());
				if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
					Assert.fail(message.getString("message-text-not-found", text));
				}
			}
		} catch (BehaveException be) {
			throw be;
		} catch (NoSuchFrameException ex) {
			throw new BehaveException(message.getString("exception-no-such-frame", frame.currentFrame(), ex));
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-unexpected", e.getMessage()), e);
		}
	}

	/**
	 * Método que busca o texto dentro de um elemento.
	 */
	public void waitTextInElement(String text) {
		try {
			driver = (WebDriver) runner.getDriver();
			long startedTime = GregorianCalendar.getInstance().getTimeInMillis();

			while (true) {

				driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

				/*
				 * Busca o texto dentro do elemento, atentar para o método
				 * getText, ele não é o getText do WebDriver e sim do Element do
				 * framework (WebTextField, WebSelect...)
				 */
				if (getText().contains(text)) {
					break;
				}

				driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);

				waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());

				if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
					Assert.fail(message.getString("message-text-not-found", text));
				}

			}
		} catch (BehaveException be) {
			throw be;
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-unexpected", e.getMessage()), e);
		}
	}

	public void waitInvisible() {
		final String locator = getLocatorWithParameters(getElementMap().locator()[0].toString());
		final By by = ByConverter.convert(getElementMap().locatorType(), locator);
		boolean testInvisibility = true;
		driver = (WebDriver) runner.getDriver();

		// Zera o tempo do driver, se não o implicity wait não funciona com o
		// tempo correto
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

		try {
			// Aguarda o elemento ficar visivel. Aguarda por 1/5 do tempo
			// máximo.
			Long waitTimeVis = (BehaveConfig.getRunner_ScreenMaxWait() / 1000) / 5;
			WebDriverWait waitVis = new WebDriverWait(driver, waitTimeVis);
			waitVis.until(ExpectedConditions.visibilityOfElementLocated(by));

			testInvisibility = true;
		} catch (org.openqa.selenium.TimeoutException e) {
			testInvisibility = false;
		}

		if (testInvisibility) {
			// Aguarda ele sumir
			Long waitTime = (BehaveConfig.getRunner_ScreenMaxWait() / 1000);
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		}

		// Volta o tempo padrão (maxWait) no driver
		driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
	}

}
