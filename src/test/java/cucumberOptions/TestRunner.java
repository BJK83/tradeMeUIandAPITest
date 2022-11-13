package cucumberOptions;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features", 
		glue = { "stepDefinitions" }, 
		plugin = {"pretty", 
				"json:target/cucumber-report/TestReport.json",
                "html:target/cucumber-report/TestReport.html",
                "junit:target/cucumber-report/TestReport.xml"}, 
		monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}