package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import resources.UIScenarioContext;

public class Hooks {

	UIScenarioContext uIScenarioContext = new UIScenarioContext();

	WebDriver driver;

	
	@Before("@UI")
	public void setup(Scenario scenario) {
		
		uIScenarioContext.setUp();	

	}

	@After("@UI")
	public void tearDown(Scenario scenario) {
		uIScenarioContext.tearDown();	

	}
}
