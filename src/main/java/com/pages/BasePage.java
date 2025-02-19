package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.factory.DriverFactory;

public class BasePage implements PageInterface
{
	
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage()
	{
		this.driver=DriverFactory.getDriver();
		this.wait=new WebDriverWait(driver, 10);
	}
	@Override
	public String getPageTitle() {
		return driver.getTitle();
		
	}
	@Override
	public void clickElement(WebElement ele) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		element.click();
	}

	@Override
	public void enterText(WebElement ele, String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		element.clear();
		element.sendKeys(text);
	}


	@Override
	public void waitForPageToLoad() {
		 wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) driver)
	                .executeScript("return document.readyState").equals("complete"));		
	}
	@Override
	public void waitForElementToBeVisible(WebElement e) {
	    wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	@Override
	public WebElement getWebElement(By locator) {
	    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	@Override
	public boolean isElementPresent(By locator) {
	        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	        return true;
	   
	}
	@Override
	public boolean isElementVisible(By locator) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        return true;
	    
	}
	@Override
	public List<WebElement> getWebElements(By locator) {
//        wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
//		return driver.findElements(locator);
		//wait.until(driver -> !driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
	}

	
	



	

}
