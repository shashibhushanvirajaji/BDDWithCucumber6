package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	// locators 
	private By loginlink = By.linkText("Log in");
	private By logo = By.cssSelector("img[alt='Tricentis Demo Web Shop']");
	private By booksLink = By.linkText("Books");
	private By computersLink = By.linkText("Computers");
	private By electronicsLink = By.linkText("Electronics");
	private By apparelLink = By.linkText("Apparel & Shoes");
	private By digitaldownloadsLink = By.linkText("Digital downloads");
	private By giftcardsLink = By.linkText("Jewelry");
	private By usernameinput = By.id("Email");
	private By passwordinput = By.id("Password");
	private By LoginButton = By.cssSelector(".login-button");
	
	// constructor 
	public LoginPage(WebDriver driver)	{
		this.driver = driver;		
	}
	
	// page actions :
	
	public String getPageTitle()	{
		return driver.getTitle();
	}
	
	public boolean isLogoPresent() {
		return driver.findElement(logo).isDisplayed();
	}
	
	public boolean isLoginLinkPresent() {
		return driver.findElement(loginlink).isDisplayed();
	}
	
	public boolean isbooksLinkPresent() {
		return driver.findElement(booksLink).isDisplayed();
	}
	
	public boolean iscomputersLinkPresent() {
		return driver.findElement(computersLink).isDisplayed();
	}
	
	public boolean iselectronicsLinkPresent() {
		return driver.findElement(electronicsLink).isDisplayed();
	}
	
	public void enterusername(String username) {
		driver.findElement(usernameinput).sendKeys(username);
	}
	
	public void enterpassword(String password) {
		driver.findElement(passwordinput).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(LoginButton).click();
	}
	
	public void clickLoginLink() {
		driver.findElement(loginlink).click();	
	}
	
	public WelcomePage doLogin(String un, String pwd) {
		driver.findElement(loginlink).click();	
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(usernameinput).sendKeys(un);
		driver.findElement(passwordinput).sendKeys(pwd);
		driver.findElement(LoginButton).click();
		
		return new WelcomePage(driver);
	}
	
	
}
