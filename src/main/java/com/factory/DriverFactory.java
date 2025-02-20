package com.factory;

import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

   public WebDriver driver;
   
   public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
   
   public WebDriver init_driver(String browser)
   {
	   System.out.println("browser value is "+browser);
	   
	   if(browser.equals("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   tlDriver.set(new ChromeDriver());
	   }
	   else if(browser.equals("firefox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   tlDriver.set(new FirefoxDriver());
	   }
	   else if (browser.equals("edge"))
	   {
//		   WebDriverManager.edgedriver().setup();
//		   tlDriver.set(new EdgeDriver());
		   
		   WebDriverManager.edgedriver().setup();
		    
		    // Create EdgeOptions
		    EdgeOptions options = new EdgeOptions();

		    // Use setCapability instead of addArguments
		    options.setCapability("ms:edgeOptions", Collections.singletonMap("args", new String[]{"--headless", "--disable-gpu"}));

		    // Initialize EdgeDriver with options
		    tlDriver.set(new EdgeDriver(options));
	   }
	   else if(browser.equals("safari"))
	   {
		   tlDriver.set(new SafariDriver());
	   }
	   else
	   {
		   System.out.println("Incorrect browser value "+browser);
		   
	   }
	   
	   getDriver().manage().deleteAllCookies();
	   getDriver().manage().window().maximize();
	   return getDriver();
	   
	}
   
   
   public static synchronized WebDriver getDriver()
   {
	   return tlDriver.get();
   }
    

}
