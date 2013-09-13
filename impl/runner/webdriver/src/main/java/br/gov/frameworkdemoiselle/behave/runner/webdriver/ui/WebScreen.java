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

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;

public class WebScreen extends WebBase implements Screen {

	private Logger logger = Logger.getLogger(this.toString());

	public void waitText(String text) {
		waitText(text, BehaveConfig.getRunner_ScreenMaxWait());
	}

	/**
	 * Neste método waitText estamos forçando que seja verificado dentro do body através de um loop
	 * controlado por nós e não pelo implicityWait do Webdriver. Por isso zeramos o implicityWait e depois
	 * voltamos para o valor padrão das propriedades.
	 */
	public void waitText(String text, Long timeout) {
		
		int totalMilliseconds = 0;
		int frameIndex = -1;
				
		// Enquando não encontrar o text na tela
		while (true) {			
			try {
				((WebDriver) runner.getDriver()).manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
				
				//se houve frames, faz o switchTo para cada verificação.
				int totalFrames = countFrames();				 
				if (totalFrames > 0){									
					if (++frameIndex >= totalFrames){
						logger.debug("---defaultContent---");
						getDriver().switchTo().defaultContent();
						frameIndex = 0;
					}else{
						getDriver().switchTo().frame(frameIndex);
						logger.debug("---frame[" +  frameIndex + "]---");
						
					}
				}
				
				System.out.println(getDriver().getPageSource());
				// Tenta encontrar o elemento na tela, antes era utilizado o findElement que utiliza o implicityWait			
				List<WebElement> elements = ((WebDriver) runner.getDriver()).findElements(By.tagName("body"));				
				
				// Se encontrou o elemento Body na tela
				if (elements.size() > 0) {
					// Verifica se o elemento body da tela tem o texto informado
					if (elements.get(0).getText().contains(text)) {
						// Se tem o texto no body sai do loop
						break;
					}
				} else {
					logger.debug("Não encontrou a tag body na página. Verificando todo o código fonte.");
					if (((WebDriver) runner.getDriver()).getPageSource().contains(text)) {
						break;
					}
				}
			} catch (Exception ex) {
				logger.debug("Provavelmente a tag body não foi encontrada no corpo da página.");
			} finally {
				((WebDriver) runner.getDriver()).manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
			}
			
			try {
				logger.debug("Aguardando o elemento [" + text + "]");
				Thread.sleep(BehaveConfig.getRunner_ScreenMinWait());
			} catch (InterruptedException e) {
				throw new BehaveException(e);
			}

			totalMilliseconds += BehaveConfig.getRunner_ScreenMinWait();

			if (totalMilliseconds > timeout)
				Assert.fail("Texto não encontrado na tela. Texto: " + text);
			
		}
	}

}
