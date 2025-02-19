package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage
{
	
	public LoginPage()
	{
		super();	
	}
	
	//By Locators
	private By username_input=By.id("user-name");
	
	private By password_input=By.id("password");
	
	private By login_button=By.id("login-button");
	
	private By swag_labs_logo=By.xpath("//div[@class='login_logo']");
	
	private By invalid_credentials_message=By.xpath("//h3[normalize-space()='Epic sadface: Username and password do not match any user in this service']");

	private By password_required_message=By.xpath("//h3[normalize-space()='Epic sadface: Password is required']");
	
	private By username_required_message=By.xpath("//h3[normalize-space()='Epic sadface: Username is required']");
	
	public WebElement getUsernameInput()
	{
		return getWebElement(username_input);
	}
	
	public WebElement getPasswordInput()
	{
		return getWebElement(password_input);
	}
	
	public WebElement getLoginButton()
	{
		return getWebElement(login_button);
	}
	
	public WebElement getSwagLabsLogo()
	{
		return getWebElement(swag_labs_logo);
	}
	
	public WebElement getInvalidMessage()
	{
		return getWebElement(invalid_credentials_message);
	}
	
	public WebElement getUsernameRequiredMessage()
	{
		return getWebElement(username_required_message);
	}
	
	public WebElement getPasswordRequiredMessage()
	{
		return getWebElement(password_required_message);
	}
	
	public void login(String username, String password)
	{
		enterText(getUsernameInput(),username);
		enterText(getPasswordInput(),password);
		clickElement(getLoginButton());
		
		
		
	}
	
	public boolean isLogoPresent()
	{
		return isElementVisible(swag_labs_logo);
	}
	
	public boolean isInvalidMessageAppears()
	{
		return isElementVisible(invalid_credentials_message);
	}
	
	public boolean isCredentialsRequiredMessageAppears(String username, String password)
	{
		if(username.isEmpty())
		{
			return isElementVisible(username_required_message);
		}
		else
		{
			return isElementVisible(password_required_message);
		}
	}
	
	
}
