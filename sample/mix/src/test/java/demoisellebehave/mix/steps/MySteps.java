package demoisellebehave.mix.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import br.gov.frameworkdemoiselle.behave.internal.util.ReflectionUtil;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.CommonSteps;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.SwitchDriver;

public class MySteps extends CommonSteps {
	
	
	private List<String> frames;

	@Given("vou para a tela \"$local\"")
	@Then("vou para a tela \"$local\"")
	@When("vou para a tela \"$local\"")
	public void goToWithName(String local) {
		currentPageName = local;
		String url = ReflectionUtil.getLocation(local);
		runner.navigateTo(url);
		//Especifico do runner
		WebDriver driver = (WebDriver) runner.getDriver();
		frames = getFrames(driver.getPageSource());
		
		SwitchDriver switchDriver = new SwitchDriver(driver);
		System.out.println(switchDriver);
		System.out.println("----");
		for (int i = 0; i < 30; i++) {
			switchDriver.switchNextFrame();	
		}		
	}
	
	
	@Given("vou para o frame \"$frame\"")
	@When("vou para o frame \"$frame\"")
	@Then("vou para o frame \"$frame\"")
	public void irFrame(String frame) {
	    WebDriver driver = (WebDriver) runner.getDriver();
	    for(String _frame : frames){
	    	driver.switchTo().defaultContent();
	    	driver.switchTo().frame(_frame);
	 	    System.out.println(driver.getPageSource());	    	
	    }
	}
	
	public List<String> getFrames(String pageSource){		
        Pattern pattern = Pattern.compile("(<frame(.*?)name=\")(.*?)(\")", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(pageSource);
        List<String> listMatches = new ArrayList<String>();
        while(matcher.find()) {
            listMatches.add(matcher.group(3));
        }        
        return listMatches;		
	}

}
