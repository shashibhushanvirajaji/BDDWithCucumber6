package parallel;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\parallel", 
				glue = { "parallel"},				
				plugin = { "pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				}
// tags= "@All"
// tags= "@tag1 and @regression" // new implementaion from cucumber 6.9.0
// dryRun = true
// strict = false // deprecated from cucumber 6.9.0
)


public class RunCucumberTest  extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
		
	}

}
