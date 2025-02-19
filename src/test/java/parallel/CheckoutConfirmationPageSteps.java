package parallel;

import com.pages.CheckoutConfirmationPage;

import io.cucumber.java.en.And;

public class CheckoutConfirmationPageSteps
{
	private CheckoutConfirmationPage checkoutConfirmationPage = new CheckoutConfirmationPage();
	
	
	 @And("User finishes the checkout process")
	 public void userFinishesTheCheckoutProcess()
	 {
		 checkoutConfirmationPage.userClicksOnFinishButton();
	 }


}
