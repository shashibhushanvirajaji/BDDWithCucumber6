package testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\com\\features", glue = { "stepdefinitions",
		"applicationhooks" }, monochrome = true, plugin = { "pretty", "json:target/jsonReports/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
// tags= "@All"
// tags= "@tag1 and @regression" // new implementaion from cucumber 6.9.0
// dryRun = true
// strict = false // deprecated from cucumber 6.9.0
)

public class TestRunner {

}
