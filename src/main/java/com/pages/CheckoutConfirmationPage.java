package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutConfirmationPage extends BasePage{

	public CheckoutConfirmationPage()
	{
		super();
	}
	
	private By finish_button = By.xpath("//button[@name='finish']");
	
	public WebElement getFinishButton() {
		return getWebElement(finish_button);
	}
	
	public void userClicksOnFinishButton()
	{
		clickElement(getFinishButton());
    }
}

