package demoisellebehave.mix.steps;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import br.gov.frameworkdemoiselle.behave.parser.jbehave.CommonSteps;

public class DialogSteps extends CommonSteps {
	
	@When("confirmo a caixa de diálogo")
	@Then("confirmo a caixa de diálogo")
	public void aceitarAlerta() {
		WebDriver driver =  (WebDriver) runner.getDriver();
		driver.switchTo().alert().accept();
	}
	
	@When("cancelo a caixa de diálogo")
	@Then("cancelo a caixa de diálogo")
	public void cancelarAlerta() {
		WebDriver driver =  (WebDriver) runner.getDriver();
		driver.switchTo().alert().dismiss();
	}
	
	@When("informo na caixa de diálogo \"$value\"")
	@Then("informo na caixa de diálogo \"$value\"")
	public void informarPrompt(String value) {
		WebDriver driver =  (WebDriver) runner.getDriver();		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);		
	}

	@Then("ser\u00E1 exibido na caixa de diálogo \"$value\"")
	public void verificarAlerta(String value) {
		WebDriver driver =  (WebDriver) runner.getDriver();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(value, alert.getText());		
	}
}
