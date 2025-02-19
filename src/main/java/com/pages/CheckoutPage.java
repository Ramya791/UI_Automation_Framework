package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

	public CheckoutPage() {
		super();

	}

	private By checkout_page_title = By.xpath("//span[normalize-space()='Checkout: Your Information']");

	private By first_name_input = By.xpath("//input[@id='first-name']");

	private By last_name_input = By.xpath("//input[@id='last-name']");

	private By pincode_input = By.xpath("//input[@id='postal-code']");

	private By continue_button = By.xpath("//input[@name='continue']");


	private By order_confirmation = By.xpath("//h2[normalize-space()='Thank you for your order!']");
	
	private By first_name_required_message=By.xpath("//h3[normalize-space()='Error: First Name is required']");
	
	private By last_name_required_message=By.xpath("//h3[normalize-space()='Error: Last Name is required']");
	
	private By pincode_required_message=By.xpath("//h3[normalize-space()='Error: Postal Code is required']");



	public WebElement getFirstName() {
		return getWebElement(first_name_input);
	}

	public WebElement getLastName() {
		return getWebElement(last_name_input);
	}

	public WebElement getPincode_input() {
		return getWebElement(pincode_input);
	}

	public WebElement getContinueButton() {
		return getWebElement(continue_button);
	}

	public WebElement getCheckoutPageTitle() {
		return getWebElement(checkout_page_title);
	}

	

	public WebElement getOrderConfirmationMessage() {
		return getCheckoutPageTitle();
	}

	public boolean isOrderConfirmationMessagePresent() {
		return isElementVisible(order_confirmation);

	}

	public boolean isCheckoutPageLogoPresent() {
		return isElementVisible(checkout_page_title);
	}

	public void fillCheckoutDetails(String first_name, String last_name, String pincode) {

		enterText(getFirstName(), first_name);
		enterText(getLastName(), last_name);
		enterText(getPincode_input(), pincode);
		clickElement(getContinueButton());
		
	}

	public boolean isDetailsRequiredMessageAppears(String first_name, String last_name, String pincode) {
		if(first_name.isEmpty())
		{
			return isElementVisible(first_name_required_message);
		}
		else if(last_name.isEmpty())
		{
			return isElementVisible(last_name_required_message);
		}
		else
		{
			return isElementVisible(pincode_required_message);
		}
	}

}
