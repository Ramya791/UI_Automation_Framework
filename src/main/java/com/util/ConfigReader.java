package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
  public Properties prop;
  
  
  //This file is used to load properties from the config file
  public Properties init_prop()
  {
	  prop = new Properties();
	  
	  try {
//		  System.out.println("Classpath: " + System.getProperty("java.class.path"));
//		  System.out.println("Trying to load: " + getClass().getClassLoader().getResource("/config.properties"));

    InputStream ip = getClass().getClassLoader().getResourceAsStream("config.properties");

	 // FileInputStream ip=new FileInputStream(".test\\resources\\config\\config.properties");
	  prop.load(ip);
	  }
	  
	  catch(FileNotFoundException e)
	  {
		  e.printStackTrace();
		  
	  }
	  
	  catch(IOException e)
	  {
		  e.printStackTrace();
	  }
	  
	  return prop;
  }
  
}
