package parallel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPageSteps 
{
	private LoginPage loginPage=new LoginPage();
	
	@Given("User logs in with the credentials {string} and {string}")
	public void userLogsInWithCredentials(String username, String password)
	{
		loginPage.login(username, password);
	
	}
	
	 @Then("Invalid credentials message appears")
	 public void invalidCredentialsMessageAppears()
	 {
		 Assert.assertTrue(loginPage.isInvalidMessageAppears());
	 }
	 
	 @Then("Credentials required message appears for the given {string} and {string}")
	 public void credentialsRequiredMessageAppears(String username, String password)
	 {
		 Assert.assertTrue(loginPage.isCredentialsRequiredMessageAppears(username, password));
	 }



}
