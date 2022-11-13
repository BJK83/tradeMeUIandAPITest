package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features", 
		glue = { "stepDefinitions" }, 
		plugin = {"pretty", 
				"json:target/cucumber-report/TestReport.json",
                "html:target/cucumber-report/TestReport.html",
                "junit:target/cucumber-report/TestReport.xml"}, 
		monochrome = true)

public class TestRunner {

}
