package parallel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps
{
	private HomePage homePage=new HomePage();
	
	 @Then("User is navigated to the home page of the site")
	 public void isUserOnHomePage()
	 {
		 Assert.assertTrue(homePage.isLogoPresent());
	 }
	 
	 @When("User adds the products {string} to the cart")
	 public void addProductsToCart(String product_names) throws InterruptedException
	 {
		 homePage.addProductsToCart(product_names);
	 }
	 
	 @And("User goes to the cart")
	 public void clickOnCart()
	 {
		 homePage.clickOnCartIcon();
	 }


}
