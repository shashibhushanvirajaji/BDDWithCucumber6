package stepdefinitions;

import static org.junit.Assert.*;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private static String title;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		//DriverFactory.getDriver().get("http://demowebshop.tricentis.com/");		
		assertTrue("user is on the login page", loginpage.isLoginLinkPresent());
		
		
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginpage.getPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
		Assert.assertTrue(string.contains(title));

	}

	@Then("Shop logo should be displayed")
	public void shop_logo_should_be_displayed() {
		Assert.assertTrue("Logo is present", loginpage.isLogoPresent());
	}

	@Then("Top Menu should be displayed with items")
	public void top_menu_should_be_displayed_with_items() {
		Assert.assertTrue("Books link is present", loginpage.isbooksLinkPresent());
	}

	@When("user enters username {string}")
	public void user_enters_username(String string) {
		loginpage.clickLoginLink();
		loginpage.enterusername(string);
	}

	@When("user enters password {string}")
	public void user_enters_password(String string) {
		loginpage.enterpassword(string);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		loginpage.clickLogin();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("user clicks in login link")
	public void user_clicks_in_login_link() {

	}
}
