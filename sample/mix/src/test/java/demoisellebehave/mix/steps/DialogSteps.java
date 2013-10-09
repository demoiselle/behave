//package demoisellebehave.mix.steps;
//
//import junit.framework.Assert;
//
//import org.jbehave.core.annotations.Then;
//import org.jbehave.core.annotations.When;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.WebDriver;
//
//import br.gov.frameworkdemoiselle.behave.parser.jbehave.CommonSteps;
//
//public class DialogSteps extends CommonSteps {
//	
//	@When("confirmo a caixa de di\u00E1logo")
//	@Then("confirmo a caixa de di\u00E1logo")
//	public void aceitarAlerta() {
//		WebDriver driver =  (WebDriver) runner.getDriver();
//		driver.switchTo().alert().accept();
//	}
//	
//	@When("cancelo a caixa de di\u00E1logo")
//	@Then("cancelo a caixa de di\u00E1logo")
//	public void cancelarAlerta() {
//		WebDriver driver =  (WebDriver) runner.getDriver();
//		driver.switchTo().alert().dismiss();
//	}
//	
//	@When("informo na caixa de di\u00E1logo \"$value\"")
//	@Then("informo na caixa de di\u00E1logo \"$value\"")
//	public void informarPrompt(String value) {
//		WebDriver driver =  (WebDriver) runner.getDriver();		
//		Alert alert = driver.switchTo().alert();
//		alert.sendKeys(value);		
//	}
//
//	@Then("ser\u00E1 exibido na caixa de di\u00E1logo \"$value\"")
//	public void verificarAlerta(String value) {
//		WebDriver driver =  (WebDriver) runner.getDriver();
//		Alert alert = driver.switchTo().alert();
//		Assert.assertEquals(value, alert.getText());		
//	}
//}
