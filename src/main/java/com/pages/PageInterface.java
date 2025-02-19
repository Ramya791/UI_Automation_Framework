package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface PageInterface 
{
	String getPageTitle();
	void clickElement(WebElement e);
	void enterText(WebElement e, String text);
	void waitForElementToBeVisible(WebElement e);
	void waitForPageToLoad();
	WebElement getWebElement(By locator);
    boolean isElementPresent(By locator);
    boolean isElementVisible(By locator);
    List<WebElement> getWebElements(By locator);

}
