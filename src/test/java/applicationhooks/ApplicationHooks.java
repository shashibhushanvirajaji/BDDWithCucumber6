package applicationhooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.qa.factory.DriverFactory;
import com.qa.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties lProp;

	@Before(order = 0)
	public void getproperty() {
		configReader = new ConfigReader();
		lProp = configReader.initializeProperties();

	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = lProp.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initializeDriver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario)	
	{
		if(scenario.isFailed())
		{
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		
	}

}
