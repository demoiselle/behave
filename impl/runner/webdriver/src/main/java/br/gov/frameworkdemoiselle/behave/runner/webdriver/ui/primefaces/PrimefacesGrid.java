package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.primefaces;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import br.gov.frameworkdemoiselle.behave.runner.ui.Element;
import br.gov.frameworkdemoiselle.behave.runner.ui.Grid;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebBase;

public class PrimefacesGrid extends WebBase implements Grid{

	@Override
	public void clickRow(String reference) {
		// TODO Auto-generated method stub
		 
	}

	private String preparaXPath(Element element,String l, String c){
		
		//Element elementTemp = (Element) runner.getElement(currentPageName,tabela);
	    
	    String[] xpathElemento = (element.getElementMap().locator());
		
	    String xpathTabela = xpathElemento[0].toString();
	    
		xpathTabela = xpathTabela.concat("["+l+"]/td["+c+"]");
	    
	    return xpathTabela;
	}
	
	@Override
	public String encontraTextoTabela(Element element, String l, String c){
		
		String xpathTabela = preparaXPath(element,l, c);
		
		WebElement myElement = (WebElement) ((WebDriver) runner.getDriver()).findElement(By.xpath(xpathTabela));
		
		return myElement.getText();
		
	}
	

	@Override
	public String encontraUltimaLinha(Element tabela) {

		return "last()";
	}

	
	@Override
	public void clicaBotaoTabela(Element element, String l, String c) {
		
		String xpathTabela = preparaXPath(element,l, c);
		
		String xpathTabelaBase = xpathTabela;
	    
	    xpathTabela = xpathTabela.concat("//button[@type='submit' or @type='button']");
	    
	    xpathTabela = xpathTabela.concat("|");
	    
	    xpathTabela = xpathTabela.concat(xpathTabelaBase);
	    
	    xpathTabela = xpathTabela.concat("//input[@type='checkbox']");
	    
	    xpathTabela = xpathTabela.concat("|");
	    
	    xpathTabela = xpathTabela.concat(xpathTabelaBase);
	    
	    xpathTabela = xpathTabela.concat("//div[@class='ui-row-toggler']");
	    
	    xpathTabela = xpathTabela.concat("|");
	    
	    xpathTabela = xpathTabela.concat(xpathTabelaBase);
	    
	    xpathTabela = xpathTabela.concat("//a");
	    
		WebElement myElement = (WebElement) ((WebDriver) runner.getDriver()).findElement(By.xpath(xpathTabela));
	    
	    myElement.click();
	}

	@Override
	public void clicaSelectTabela(String value, String l, String c, Element element) {
		
		String xpathTabela = preparaXPath(element,l, c);
		
	    xpathTabela = xpathTabela.concat("//label");
	    
		WebElement myElement = (WebElement) ((WebDriver) runner.getDriver()).findElement(By.xpath(xpathTabela));
	    
	    String selectId = myElement.getAttribute("id");
	  
	    selectId = selectId.substring(0, selectId.length()-6);
	    
	    myElement.click();
	    
	    
	    try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2,TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	    
	    WebElement myElement2 = (WebElement) ((WebDriver) runner.getDriver()).findElement(By.xpath("//div[@id='" + selectId.toString() + "_panel']/div/ul/li[text()='" + value + "']"));
	   
	    myElement2.click();
		
	}

	@Override
	public void informaTextoTabela(String value, String l, String c, Element element) {

		String xpathTabela = preparaXPath(element,l, c);
	    
		String xpathTabelaBase = xpathTabela;
	    
	    xpathTabela = xpathTabela.concat("//textarea");
	    
	    xpathTabela = xpathTabela.concat("|");
	    
	    xpathTabela = xpathTabela.concat(xpathTabelaBase);
	    
	    xpathTabela = xpathTabela.concat("//input[@type='text']");
	    
		WebElement myElement = (WebElement) ((WebDriver) runner.getDriver()).findElement(By.xpath(xpathTabela));
	    
	    myElement.sendKeys(value);
		
	}

	
}
