package demoisellebehave.mix.ui;

import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebBase;

public class WebFileUpload extends WebBase {

	public void sendKeys(CharSequence... keysToSend) {
		WebElement input = this.getElements().get(0);
		input.sendKeys(keysToSend);
	}

}
