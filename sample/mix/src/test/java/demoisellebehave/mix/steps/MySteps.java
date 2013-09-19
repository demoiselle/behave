package demoisellebehave.mix.steps;

import java.util.Iterator;
import java.util.Set;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import br.gov.frameworkdemoiselle.behave.parser.jbehave.CommonSteps;

public class MySteps extends CommonSteps {
	
	
	@Given("estou na tela \"$local\"")
	@Then("estou na tela \"$local\"")
	@When("estou na tela \"$local\"")
	public void pageWithName(String local) {
		currentPageName = local;
		WebDriver driver = (WebDriver)runner.getDriver();
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> iter = windowids.iterator();
		String mainWindowId=iter.next();
		System.out.println(mainWindowId);
		String popupWindowId=iter.next();
		driver.switchTo().window(popupWindowId);
	}
	

}
