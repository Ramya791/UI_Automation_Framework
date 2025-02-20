package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
		   
		   // Set up the EdgeDriver using WebDriverManager
		    WebDriverManager.edgedriver().setup();
		    
		    // Create EdgeOptions and add the unique user-data-dir argument
		    EdgeOptions options = new EdgeOptions();
		    
		    // Ensure the user data directory is unique by using a timestamp
		    String userDataDir = "/tmp/selenium_" + System.currentTimeMillis();  // Unique directory
		    options.addArguments("--user-data-dir=" + userDataDir);
		    
		    // Add other options like headless mode if needed
		    options.addArguments("--headless");
		    options.addArguments("--disable-gpu");
		    
		    // Initialize the driver with the options
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
