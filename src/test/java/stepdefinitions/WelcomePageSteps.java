package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.WelcomePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WelcomePageSteps {

	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	WelcomePage welcompage;
@Given("user has already logged into application")
public void user_has_already_logged_into_application(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	List<Map<String,String>> credentials = dataTable.asMaps();
	String username = credentials.get(0).get("username");
	String password = credentials.get(0).get("password");
	
	//DriverFactory.getDriver().get("http://demowebshop.tricentis.com/");
	welcompage = loginpage.doLogin(username, password);
	
   
}

@Then("validate logout link")
public void validate_logout_link() {
	Assert.assertTrue("Logout link is present", welcompage.isLogoutAvailable());
}

@Then("validate welcome page")
public void validate_welcome_page() {
   Assert.assertEquals("Welcome page text present", "Welcome to the new Tricentis store!", welcompage.getWelcomeText());
}

}
