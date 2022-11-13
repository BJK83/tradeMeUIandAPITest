package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pagesAndObjects.SearchPage;

public class Hooks {

	SearchPage searchPage = new SearchPage();

	@Before("@UI")
	public void setup(Scenario scenario) {

		searchPage.setUp();
	}

	@After("@UI")
	public void tearDown(Scenario scenario) {
		searchPage.tearDown();	
	}
}
