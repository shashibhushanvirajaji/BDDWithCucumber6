package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver initializeDriver(String browser) {
		System.out.println("browser = " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		} else
			System.out.println(" incorrect browser name. please enter proper browser name");
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();		
		return getDriver();
	}
	
	// this is used to get driver in thread local mode 
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}

}
