package parallel;

import org.junit.Assert;

import com.pages.CartPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;



public class CartPageSteps 
{
	private CartPage cartPage=new CartPage();
	 
	
	@Then("List of products {string} added is displayed on the cart page")
	public void isSelectedProductsOnCart(String products)
	{
	  	System.out.println("--"+cartPage.checkListOfProductsOnCart(products));
	  	Assert.assertTrue(cartPage.checkListOfProductsOnCart(products));
	}
	
	@And("User clicks on the checkout button to finish the checkout")
	public void userClicksOnCheckoutButton()
	{
		cartPage.clickOnChoeckoutButton();
	}

}
