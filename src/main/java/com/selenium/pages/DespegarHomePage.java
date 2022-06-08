package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DespegarHomePage {
  @FindBy(css="a.lgpd-banner--button.eva-3-btn.-white.-md")
  private WebElement btnCookies;
  
  @FindBy(css="a.shifu-3-button-circle.HOTELS.paint-circle ")
  private WebElement btnAlojamiento;

  WebDriver driver = null;
  
  public DespegarHomePage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
  public DespegarAlojamientoPage AlojamientoPage() {
	  btnCookies.click();
	  btnAlojamiento.click();
	  return new DespegarAlojamientoPage(driver);
  }
  
}
