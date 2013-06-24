package br.gov.frameworkdemoiselle.behave.runner.webdriver.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;

public enum WebBrowser {
	MozillaFirefox {
		@Override
		public String toString() {
			return "Mozilla Firefox";
		}

		@Override
		public WebDriver getWebDriver() {
			return new FirefoxDriver();
		}
	},
	InternetExplorer {
		@Override
		public String toString() {
			return "Internet Explorer";
		}

		@Override
		public WebDriver getWebDriver() {
			System.setProperty("webdriver.ie.driver", BehaveConfig.getBrowserDriverPath());
			return new InternetExplorerDriver();
		}
	},
	GoogleChrome {
		
		/*
		 *  instalar: /usr/lib/libstdc++.so.6 e /lib/tls/i686/cmov/libc.so.6(non-Javadoc)
		 *  http://askubuntu.com/questions/161284/why-does-running-this-program-on-11-10-give-a-glibc-2-15-not-found-error
		 *  Comando: ldd -v /bin/sh
		 * @see java.lang.Enum#toString()
		 * 
		 */
	
		@Override
		public String toString() {
			return "Google Chrome";
		}

		@Override
		public WebDriver getWebDriver() {
			System.setProperty("webdriver.chrome.driver", BehaveConfig.getBrowserDriverPath());
			return new ChromeDriver();
		}
	},
	HtmlUnit {
		@Override
		public String toString() {
			return "Html Unit (Simulado)";
		}

		@Override
		public WebDriver getWebDriver() {
			return new HtmlUnitDriver(true);
		}
	};

	public abstract WebDriver getWebDriver();
}
