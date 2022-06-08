package com.files.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;


public class DriverFactory {
	public enum browsers{
		CHROME, FIREFOX, EDGE
	}
	
  public static WebDriver LevantarBrowser(WebDriver driver, String browserName, String url) {
	  switch(browsers.valueOf(browserName)) {
	  case CHROME:
	  {
		  System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
		  Reporter.log("Abrir navegador Chrome");
		  driver = new ChromeDriver();
		  break;
	  }
	  case FIREFOX:
	  {
		  System.setProperty("webdriver.gecko.driver", "C:/Drivers/geckodriver.exe");
		  Reporter.log("Abrir navegador Firefox");
		  driver = new FirefoxDriver();
		  break;
	  }
	  case EDGE:
	  {
		  System.setProperty("webdriver.edge.driver", "C:/Drivers/msedgedriver.exe");
		  Reporter.log("Abrir navegador Edge");
		  driver = new EdgeDriver();
		  break;
	  }
	  default:
	  {
		  Reporter.log("No se selecciono un navegador");
		  System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
		  Reporter.log("Abrir navegador Chrome");
		  driver = new ChromeDriver();
		  break;
	  }
	  }
	  
	  driver.manage().window().maximize();
	  
	  driver.get(url);
	  
	  return driver;
  }
  
  public static void CloseBrowser(WebDriver driver) {
	  driver.quit();
  }
}
