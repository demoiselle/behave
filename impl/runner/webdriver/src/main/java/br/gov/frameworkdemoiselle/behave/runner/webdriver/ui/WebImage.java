package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.runner.ui.Image;

public class WebImage extends WebBase implements Image {
	
	
	@Override
	public String getText() {
		
		waitElement(0);
		String src = getElements().get(0).getAttribute("src");
		
		return (src != null?src:"");
	}
	
	@Override
	public void checkSource(String src) {
		
		waitElement(0);

		List<WebElement> elements = getElements();
		WebElement element = elements.get(0);
		
		if(element.getTagName().equals("img")){
			if(!element.getAttribute("src").contains(src)){
				throw new BehaveException("The value: "+src+" not found in src attribute of Image");
			}
		}else{
			throw new BehaveException("The element: "+getElementMap().name()+"is not an image");
		}

	}

	@Override
	public void checkAttributes(HashMap<String, String> attrs) {
		waitElement(0);

		List<WebElement> elements = getElements();
		WebElement element = elements.get(0);
		
		for(String attrName : attrs.keySet()){
			if(!element.getAttribute(attrName).contains(attrs.get(attrName))){
				throw new BehaveException("The attribute "+attrName+" not contains a value: "+attrs.get(attrName)+" on element"+getElementMap().name());
			}
		}

	}
}