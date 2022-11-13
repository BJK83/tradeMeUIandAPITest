package resources;

import helperUtils.WebDriverUtils;

public class UIScenarioContext {

	public void setUp() {
		WebDriverUtils.setUp();		
	}
	
	public void tearDown() {
		WebDriverUtils.tearDown();
	}
	
	
}
