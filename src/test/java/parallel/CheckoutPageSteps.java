package parallel;

import org.junit.Assert;

import com.pages.CheckoutPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CheckoutPageSteps 
{
	
	private CheckoutPage checkoutPage=new CheckoutPage();
	
	
	 @And("User enters the {string}, {string}, and {string} to continue the checkout process.")
	 public void userEntersCheckoutDetails(String first_name, String last_name, String postal_code)
	 {
		 Assert.assertTrue(checkoutPage.isCheckoutPageLogoPresent());
		 checkoutPage.fillCheckoutDetails(first_name, last_name, postal_code);
		 
		 
	 }
	 
	 @Then("Order success message appears")
	 public void orderSuccessMessageAppears()
	 {
		 Assert.assertTrue(checkoutPage.isOrderConfirmationMessagePresent());

	 }
	 
	 @Then("Details required message appears for the given {string}, {string}, {string}")
	 public void isDetailsRequiredMessageAppears(String first_name, String last_name, String pincode)
	 {
		 Assert.assertTrue(checkoutPage.isDetailsRequiredMessageAppears(first_name, last_name,pincode));
	 }

	 
	 


}
