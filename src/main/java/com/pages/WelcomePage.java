package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {

	private WebDriver driver;
	
	// locators 
	private By logoutlink = By.linkText("");
	private By welcometext = By.cssSelector(".topic-html-content-body>p");
	
	// constructor
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//page actions 
	
	public boolean isLogoutAvailable() {
		return driver.findElement(logoutlink).isDisplayed();
	}
	
	public String getWelcomeText() {
		return driver.findElement(welcometext).getText();
	}
	
	
}
