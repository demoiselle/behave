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
	Logger log = Logger.getLogger(WebBase.class);

	public static ElementMap loadingMap = null;
	public static boolean alreadySearchLoadingMap = false;

	public WebDriver getDriver() {
		return (WebDriver) getRunner().getDriver();
	}

	/**
	 * Função principal que pega o elemento da tela. Nova Funcionalidade: Agora ele busca o elemento em todos os frames
	 * 
	 * @return Lista de elementos encontrados
	 */
	public List<WebElement> getElements() {
		try {

			List<WebElement> elements = new ArrayList<WebElement>();
			for (String locator : getElementMap().locator()) {

				// Locators
				locator = getLocatorWithParameters(locator);
				By by = ByConverter.convert(getElementMap().locatorType(), locator);

				// Todas as buscas por elemento tem seu timeout controlado pelo
				// Demoiselle Behave
				getDriver().manage().timeouts().implicitlyWait(getImplicitlyWaitTimeoutInMilliseconds(), TimeUnit.MILLISECONDS);

				try {

					// Primeiro tenta encontrar na página sem frame sem Timeout
					List<WebElement> elementsFound = getDriver().findElements(by);

					if (elementsFound.size() > 0) {
						elements.addAll(elementsFound);
					}
					else {
						// Se não encontrar nada sem frames busca nos frames
						elements = getElementsWithFrames(getDriver(), by);
					}

				}
				catch (Throwable t) {
					// Se não encontrar nada sem frames busca nos frames
					elements = getElementsWithFrames(getDriver(), by);
				}
				finally {
					getDriver().manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
				}

			}

			return elements;
		}
		catch (BehaveException be) {
			throw be;
		}
		catch (Exception e) {
			throw new BehaveException(message.getString("exception-unexpected", e.getMessage()), e);
		}
	}

	/**
	 * Retorna lista de elementos filtrados pelo By dentro dos frames do navegador, sendo que o primeiro elemento encontrado dentro de um frame será retornado.
	 * 
	 * @param driver
	 *            WebDriver a ser utilizado
	 * @param by
	 *            Locator by
	 * @return Lista de elementos que foram encontrados no frame
	 */
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
					elements.addAll(elementsFound);
					found = true;
					break;
				}
			}

			if (found) {
				break;
			}

			waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());

			// Controle do timeout manualmente
			if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
				throw new BehaveException(message.getString("exception-element-not-found", getElementMap().name()));
			}
		}

		return elements;
	}

	/**
	 * Método que faz a substituição dos parâmetros no locator (param1, param2)
	 * 
	 * @param locator
	 *            texto do locator com parâmetros
	 * @return o locator atualizado com os parâmetros
	 */
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

	/**
	 * Retorna o texto do elemento corrente utilizando o método de várias tentativas até dar o timeout selecionado pelo usuário. Este getText é difeirente do getTexto puro do WebDriver pois possui o mecanismo de várias tentativas.
	 * 
	 * @return o texto de dentro (innerText) do elemento
	 */
	public String getText() {

		waitElement(0);

		String s = null;
		final long startedTime = GregorianCalendar.getInstance().getTimeInMillis();
		Exception lastEx = null;

		while (true) {
			try {

				getDriver().manage().timeouts().implicitlyWait(getImplicitlyWaitTimeoutInMilliseconds(), TimeUnit.MILLISECONDS);

				// A implementação final do GET TEXT do WebDriver faz
				// verificações a mais que o nosso Wait Element que pode fazer
				// com que de problema em algumas situações não mapeadas, por
				// isso ficamos tentando até conseguir
				s = getElements().get(0).getText();

				log.debug("Conteúdo do elemento: " + s);

				break;

			}
			catch (Exception e) {

				log.warn("Erro no getText do Webdriver");
				log.warn(e);

				lastEx = e;

			}
			finally {

				// Volta o tempo padrão de timeout
				getDriver().manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);

				// Controle do timeout manualmente
				if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
					if (lastEx != null) {
						throw new BehaveException(lastEx);
					}

					throw new BehaveException(message.getString("exception-element-not-found", getElementMap().name()));
				}

			}
		}

		return s;
	}

	/**
	 * Método de thread wait. Apesar de não ser recomandada a utilização deste método ele se faz necessário em muitos casos, principalmente em casos que dependam de renderização dos objetos no navegador.
	 * 
	 * @param delay
	 *            tempo de espera
	 */
	protected static void waitThreadSleep(Long delay) {
		try {
			Thread.sleep(delay);
		}
		catch (InterruptedException ex) {
			throw new BehaveException(message.getString("exception-thread-sleep"), ex);
		}
	}

	/**
	 * 
	 * @param index
	 *            Posição no Array de locators do elemento
	 */
	public void waitElement(Integer index) {
		// Locators
		final String locator = getLocatorWithParameters(getElementMap().locator()[index].toString());
		final By by = ByConverter.convert(getElementMap().locatorType(), locator);
		final long startedTime = GregorianCalendar.getInstance().getTimeInMillis();

		// Executa o controle de verificação de tempo manualmente
		while (true) {

			try {
				// É necessário um minimo período de tempo para renderização de
				// objetos
				waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());

				// WARN: É necessário setar o TIMEOUT desta maneira para que o
				// WebDriverWait tenha um timeout correto
				getDriver().manage().timeouts().implicitlyWait(getImplicitlyWaitTimeoutInMilliseconds(), TimeUnit.MILLISECONDS);

				// Aguarda o loading
				waitLoading();

				// Garante o tempo minimo para verificação
				getDriver().manage().timeouts().implicitlyWait(getImplicitlyWaitTimeoutInMilliseconds(), TimeUnit.MILLISECONDS);

				// Espera ser visível e clicável
				waitClickable(by);

				// Garante o tempo minimo para verificação
				getDriver().manage().timeouts().implicitlyWait(getImplicitlyWaitTimeoutInMilliseconds(), TimeUnit.MILLISECONDS);

				// Esta verificação é necessária mesmo que dentro do clickable
				// ele já faça
				waitVisibility(by);

				// Passou por todas as verificações
				break;

			}
			catch (Exception e) {
				log.warn("Erro no Wait Element");
				log.warn(e);
			}
			finally {
				// Volta o tempo padrão de timeout
				getDriver().manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);

				// Controle do timeout manualmente
				if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
					throw new BehaveException(message.getString("exception-element-not-found", getElementMap().name()));
				}
			}

		}

	}

	/**
	 * Aguarda o elemento ficar visível na tela.
	 * 
	 * @param index
	 *            Posição no Array de locators do elemento
	 */
	public void waitElementOnlyVisible(Integer index) {

		try {

			// WARN: É necessário setar o TIMEOUT desta maneira para que o
			// WebDriverWait tenha um timeout correto
			getDriver().manage().timeouts().implicitlyWait(getImplicitlyWaitTimeoutInMilliseconds(), TimeUnit.MILLISECONDS);

			final String locator = getLocatorWithParameters(getElementMap().locator()[index].toString());
			final By by = ByConverter.convert(getElementMap().locatorType(), locator);

			waitLoading();

			waitVisibility(by);

		}
		finally {
			// Volta o tempo padrão de timeout
			getDriver().manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
		}
	}

	/**
	 * Método que verifica em todas as classes se existe um componente Loading, e se existir, ele sempre espera que este elemento desapareça antes de continuar.
	 */
	@SuppressWarnings("unchecked")
	public void waitLoading() {

		if (!alreadySearchLoadingMap) {

			alreadySearchLoadingMap = true;

			Reflections reflections = new Reflections("");
			Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(ScreenMap.class);

			for (Class<?> clazzI : annotatedClasses) {
				HashSet<Field> fields = (HashSet<Field>) ReflectionUtils.getAllFields(clazzI, ReflectionUtils.withAnnotation(ElementMap.class), ReflectionUtils.withTypeAssignableTo(Loading.class));

				if (fields.size() == 1) {
					for (Field field : fields) {
						loadingMap = field.getAnnotation(ElementMap.class);
					}
				}
			}

		}

		if (loadingMap != null) {

			boolean existeLoading;

			try {
				// Verifica se existe o LOADING
				ExpectedConditions.presenceOfElementLocated(ByConverter.convert(loadingMap.locatorType(), loadingMap.locator()[0])).apply(getDriver());
				existeLoading = true;

				log.debug(message.getString("message-loading-visible"));
			}
			catch (Exception e) {
				existeLoading = false;
			}

			if (existeLoading) {
				// Força esperar o loading aparecer quando o elemento utilizado
				// tem a propriedade forWaitLoading na anotação @ElementMap
				if (getElementMap() != null && getElementMap().forceWaitLoading()) {
					WebDriverWait wait = new WebDriverWait(getDriver(), (BehaveConfig.getRunner_ScreenMaxWait() / 1000));
					wait.until(ExpectedConditions.visibilityOfElementLocated(ByConverter.convert(loadingMap.locatorType(), loadingMap.locator()[0])));

					log.debug(message.getString("message-force-loading"));
				}

				// Aguardo o LOADING desaparecer!
				WebDriverWait wait = new WebDriverWait(getDriver(), (BehaveConfig.getRunner_ScreenMaxWait() / 1000));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(ByConverter.convert(loadingMap.locatorType(), loadingMap.locator()[0])));

				log.debug(message.getString("message-loading-invisible"));
			}

		}

	}

	/**
	 * Procura por um elemento dentro do TODOS os FRAMES/IFRAMES da página, e assim que encontrar ele deixa o frame selecionado para ser utilizado.
	 * 
	 * @param by
	 *            Locator para lolizar o elemento
	 */
	private void findFrameContainingElement(By by) {
		// Primeiro encontra o frame que o elemento esta, para depois esperar
		// ele
		frame = getSwitchDriver(getDriver());
		long startedTime = GregorianCalendar.getInstance().getTimeInMillis();
		boolean found = false;

		while (true) {
			frame.bind();

			for (int i = 0; i < frame.countFrames(); i++) {
				frame.switchNextFrame();
				List<WebElement> elementsFound = getDriver().findElements(by);
				if (elementsFound.size() > 0) {
					found = true;
					break;
				}
			}

			if (found) {
				break;
			}

			waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());

			// Controle do timeout manualmente
			if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
				throw new BehaveException(message.getString("exception-element-not-found", getElementMap().name()));
			}
		}
	}

	/**
	 * Método que verifica se um elemento está VISÍVEL e DESABILITADO levando em consideração atributos como readonly e disabled.
	 */
	public void isVisibleDisabled() {
		List<WebElement> elementsFound = getElements();

		if (elementsFound.size() > 0) {
			WebElement e = elementsFound.get(0);

			// Tem que estar Visível e Desabilitado, se estiver invisível OU
			// habilitado lança a exception
			if (e.getTagName().toLowerCase().equals("input") || e.getTagName().toLowerCase().equals("select") || e.getTagName().toLowerCase().equals("a")) {

				// Verifica também se tem o atributo READONLY no elemento
				String readonlyAttribute = e.getAttribute("readonly");
				String disabledAttribute = e.getAttribute("disabled");

				// SE não estiver visivel OU (não possuir o attr DISABLED E não
				// possuir o attr READONLY) ENTÃO de erro!
				if (!e.isDisplayed() || (disabledAttribute == null && readonlyAttribute == null)) {
					throw new BehaveException(message.getString("exception-element-not-displayed-or-enabled", getElementMap().name()));
				}
			}
			else {
				// Faz a verificação se esta desabilitado por meio das classes
				// de css para os casos de combo estilo Primefaces e Richfaces
				String classes = e.getAttribute("class");
				if (!e.isDisplayed() || !classes.contains("disabled")) {
					throw new BehaveException(message.getString("exception-element-not-displayed-or-enabled", getElementMap().name()));
				}
			}

		}
		else {
			throw new BehaveException(message.getString("exception-element-not-found", getElementMap().name()));
		}
	}

	/**
	 * Aguarda um elemento estar visível, clicável e habilitado.
	 */
	public void waitVisibleClickableEnabled() {
		try {

			// WARN: É necessário setar o TIMEOUT desta maneira para que o
			// WebDriverWait tenha um timeout correto
			getDriver().manage().timeouts().implicitlyWait(getImplicitlyWaitTimeoutInMilliseconds(), TimeUnit.MILLISECONDS);

			// Locators
			final String locator = getLocatorWithParameters(getElementMap().locator()[0].toString());
			final By by = ByConverter.convert(getElementMap().locatorType(), locator);

			// Wait
			waitClickable(by);

		}
		finally {
			// Volta o tempo padrão de timeout
			getDriver().manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
		}
	}

	/**
	 * Aguarda o elemento ser clicável.
	 * 
	 * ATENÇÃO: condition 'clickable' is equivalent to 'visible and enabled' https://code.google.com/p/selenium/issues/detail?id=6804
	 * 
	 * @param by
	 */
	private void waitClickable(By by) {
		findFrameContainingElement(by);

		// Faz a verificação no FRAME selecionado
		WebDriverWait wait = new WebDriverWait(getDriver(), getImplicitlyWaitTimeoutInMilliseconds() / 1000);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Método que retorna um tempo fixo para que o Implicitly Wait do WebDriver tente encontrar um elemento na tela
	 * 
	 * @return tempo de timeout para Implicitly Wait
	 */
	public Long getImplicitlyWaitTimeoutInMilliseconds() {
		return 1000L;
	}

	/**
	 * Aguardda o elemento estar visível.
	 * 
	 * @param by
	 *            Locator do elemento.
	 */
	private void waitVisibility(By by) {
		findFrameContainingElement(by);

		// Faz a verificação no FRAME selecionado
		WebDriverWait wait = new WebDriverWait(getDriver(), getImplicitlyWaitTimeoutInMilliseconds() / 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * 
	 * @return
	 */
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
	public JavascriptExecutor getJavascriptExecutor() {
		if (!JavascriptExecutor.class.isAssignableFrom(this.runner.getDriver().getClass())) {
			throw new BehaveException(message.getString("exception-javascript-driver", runner.getDriver().getClass()));
		}
		return (JavascriptExecutor) this.runner.getDriver();
	}

	/**
	 * Retorna o ID do primeiro elemento de tela mapeado.
	 * 
	 * @return ID do primeiro elemento do locator
	 */
	public String getId() {
		String id = getElements().get(0).getAttribute("id");
		if (id == null || id.isEmpty()) {
			throw new BehaveException(message.getString("exception-id-not-found", this.getElementMap().name()));
		}
		return id;
	}

	/**
	 * Retorna o SwitchDriver do Driver atual. O Switch Driver é responsável pela manipulação de frames de um navegador.
	 * 
	 * @param driver
	 * @return Instância de SwitchDriver
	 */
	private SwitchDriver getSwitchDriver(WebDriver driver) {
		frame = new SwitchDriver(driver);
		return frame;
	}

	/**
	 * Aguarda um texto ficar visível na página. É importante saber que textos que não estão visíveis mas estão no HTML não são considerados. Também não são considerados textos que estiverem dentro das tags SCRIPT e STYLE.
	 * 
	 * @param text
	 *            Texto a ser encontrado.
	 */
	public void waitVisibleText(String text) {

		WebDriver driver = (WebDriver) runner.getDriver();
		frame = getSwitchDriver(driver);
		final long startedTime = GregorianCalendar.getInstance().getTimeInMillis();
		boolean found = false;

		while (true) {
			try {

				getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

				// Mesmo que não tenha frame ele pega o "primeiro"
				frame.bind();

				// Quando tem somente 1 frame
				if (frame.countFrames() == 1) {
					List<WebElement> elementsFound = getDriver().findElements(By.xpath("/html"));

					String textHtml = elementsFound.get(0).getText();

					log.debug("O tamanho do texto analisado é de [" + textHtml.length() + "]");
					
					if (textHtml.contains(text)) {
						// log.debug("Encontrou o texto [" + text +
						// "] na página");
						found = true;
						break;
					}
				}
				else {

					for (int i = 0; i < frame.countFrames(); i++) {

						frame.switchNextFrame();

						List<WebElement> elementsFound = getDriver().findElements(By.xpath("/html"));
						if (elementsFound.size() == 1) {
							WebElement element = elementsFound.get(0);

							String textHtml = element.getText();
							
							log.debug("O tamanho do texto analisado é de [" + textHtml.length() + "]");

							if (textHtml.contains(text)) {
								// log.debug("Encontrou o texto [" + text +
								// "] na página utilizando os frames");
								found = true;
								break;
							}
						}
					}
				}
				if (found) {
					break;
				}
			}
			catch (BehaveException be) {
				log.warn("waitVisibleText BehaveException");
				log.warn(be);
			}
			catch (Exception e) {
				log.warn("waitVisibleText Exception");
				log.warn(e);
			}
			finally {
				getDriver().manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);

				// Controle do timeout manualmente
				if (!found && (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait())) {
					Assert.fail(message.getString("message-text-not-found", text));
				}
			}
		}
	}

	/**
	 * Aguarda um texto NÃO ficar visível na página. É importante saber que textos que não estão visíveis mas estão no HTML não são considerados. Também não são considerados textos que estiverem dentro das tags SCRIPT e STYLE.
	 * 
	 * @param text
	 *            Texto a ser encontrado.
	 */
	public void waitNotVisibleText(String text) {

		frame = getSwitchDriver(getDriver());
		final long startedTime = GregorianCalendar.getInstance().getTimeInMillis();
		boolean found = true;

		// Verifica 3 vezes se existe antes de continuar
		int countTries = 1;
		int maxCountTries = 3;

		while (true) {
			try {

				getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

				// Mesmo que não tenha frame ele pega o "primeiro"
				frame.bind();

				// Quando tem somente 1 frame
				if (frame.countFrames() == 1) {
					List<WebElement> elementsFound = getDriver().findElements(By.xpath("/html"));
					if (!elementsFound.get(0).getText().contains(text) && countTries >= maxCountTries) {
						found = false;
						break;
					}
				}
				else {

					for (int i = 0; i < frame.countFrames(); i++) {

						frame.switchNextFrame();

						List<WebElement> elementsFound = getDriver().findElements(By.xpath("/html"));
						if (elementsFound.size() == 1) {
							WebElement element = elementsFound.get(0);
							if (!element.getText().contains(text) && countTries >= maxCountTries) {
								found = false;
								break;
							}
						}
					}
				}

				if (!found) {
					break;
				}

				countTries += 1;
			}
			catch (BehaveException be) {
				log.warn("waitNotVisibleText BehaveException");
				log.warn(be);
			}
			catch (Exception e) {
				log.warn("waitNotVisibleText Exception");
				log.warn(e);
			}
			finally {
				getDriver().manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);

				// Controle do timeout manualmente
				if (found && (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait())) {
					Assert.fail(message.getString("message-text-found", text));
				}
			}
		}
	}

	/**
	 * Método que busca o texto dentro de um elemento utilizando os métodos de tentativa e controle manual de timeout.
	 * 
	 * @param text
	 *            Texto a ser encontrado no elemento.
	 * @param visible
	 *            Verifica se o texto está visível (true) ou não (false)
	 */
	public void waitVisibleOrNotTextInElement(String text, boolean visible) {

		long startedTime = GregorianCalendar.getInstance().getTimeInMillis();
		boolean ok = false;

		while (true) {
			try {

				/*
				 * Busca o texto dentro do elemento, atentar para o método getText, ele não é o getText do WebDriver e sim do Element do framework (WebTextField, WebSelect...)
				 */
				String elementText = getText();
				if (visible) {
					log.debug("Existe o texto [" + text + "] no texto do compoenente [" + elementText + "]?");

					if (elementText.contains(text)) {
						log.debug("SIM!");
						ok = true;
						break;
					}
					log.debug("NÃO!");
				}
				else {
					log.debug("NÃO existe o texto [" + text + "] no texto do compoenente [" + elementText + "]?");

					if (!elementText.contains(text)) {
						log.debug("SIM!");
						ok = true;
						break;
					}
					log.debug("NÃO!");
				}

				log.debug("Vai TENTAR novamente encontrar o texto");

			}
			catch (BehaveException be) {
				log.warn("Text in element BehaveException");
				log.warn(be);
			}
			catch (Exception e) {
				log.warn("Text in element Exception");
				log.warn(e);
			}
			finally {

				// Controle do timeout manualmente
				if (!ok && GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
					Assert.fail(message.getString("message-text-not-found", text));
				}
			}
		}
	}

	/**
	 * Método chamado pelas frases que aguardam o primeiro elemento do locator não está visível.
	 */
	public void waitInvisible() {
		waitInvisible(0);
	}

	/**
	 * Aguarda que um elemento selecionado pela sua posição no locator não esteja visível.
	 * 
	 * @param index
	 *            Posição no locator do element.
	 */
	public void waitInvisible(int index) {
		final String locator = getLocatorWithParameters(getElementMap().locator()[index].toString());
		final By by = ByConverter.convert(getElementMap().locatorType(), locator);
		boolean testInvisibility = true;

		try {
			// Aguarda o elemento ficar visivel (MinWait)
			Long waitTimeVis = (BehaveConfig.getRunner_ScreenMinWait() / 1000);
			WebDriverWait waitVis = new WebDriverWait(getDriver(), waitTimeVis);
			waitVis.until(ExpectedConditions.visibilityOfElementLocated(by));

			testInvisibility = true;
		}
		catch (org.openqa.selenium.TimeoutException e) {
			testInvisibility = false;
		}

		if (testInvisibility) {
			// Aguarda ele sumir
			Long waitTime = (BehaveConfig.getRunner_ScreenMaxWait() / 1000);
			WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		}

	}

	/**
	 * Retira o foco do campo. O comportamento padrão para isso é selecionar o <body>
	 */
	public void blur() {
		getDriver().findElement(By.tagName("body")).click();
	}

	/**
	 * Aguarda um texto na página inteira (exceto as tags script e style). Na verdade chama o método waitVisibleText
	 * 
	 * @param text
	 *            Texto a ser encontrato na página.
	 */
	public void waitText(String text) {
		waitVisibleText(text);
	}

	/**
	 * Aguarda que o texto não esteja na página inteira (exceto as tags script e style). Na verdade chama o método waitNotVisibleText
	 * 
	 * @param text
	 *            Texto a não ser encontrado na página.
	 */
	public void waitNotText(String text) {
		waitNotVisibleText(text);
	}

	/**
	 * Aguarda que o elemento atual não contenha o texto.
	 * 
	 * @param text
	 *            Texto a não ser encontrato no elemento.
	 */
	public void waitTextNotInElement(String text) {
		waitVisibleOrNotTextInElement(text, false);
	}

	/**
	 * Aguarda que o elemento atual contenha o texto.
	 * 
	 * @param text
	 *            Texto a ser encontrato no elemento.
	 */
	public void waitTextInElement(String text) {
		waitVisibleOrNotTextInElement(text, true);
	}

}