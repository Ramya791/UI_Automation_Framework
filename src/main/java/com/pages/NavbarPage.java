package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.factory.DriverFactory;

public class NavbarPage extends BasePage
{
	public NavbarPage()
	{
		super();	
	}
	
	private By nav_icon=By.xpath("//button[@id='react-burger-menu-btn']");
	
	private By nav_option_logout=By.xpath("//a[@id='logout_sidebar_link']");
	
	public WebElement getNavIcon()
	{
		return getWebElement(nav_icon);
	}
	
	public WebElement getNavOptionLogout()
	{
		return getWebElement(nav_option_logout);

	}
	
	
	public void userSelectsLogoutOptionFromNavbar()
	{
		clickElement(getNavIcon());
		clickElement(getNavOptionLogout());
		
	}
	

}
