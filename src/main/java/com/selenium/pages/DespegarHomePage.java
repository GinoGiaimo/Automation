package com.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DespegarHomePage {
  List<WebElement>listaElementos = null;
  
  @FindBy(css="a.header-logo-container")
  private WebElement logo;
  
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
  
  public void verificarListaProductos() {
	  listaElementos = driver.findElements(By.cssSelector("ul.header-list-products > li"));
	  
	  Boolean b = null;
		for(WebElement elemento : listaElementos) {
			//elemento.click();
			//wait.until(ExpectedConditions.elementToBeClickable(logo));
			//Thread.sleep(000);
			WebElement label = elemento.findElement(By.cssSelector(" label"));
			//label.click();
			if(elemento.isDisplayed() == true && label.getText().isEmpty() == false) {
				b = true;
			}
			
			Assert.assertTrue(b, "El elemento: " + label.getText() + " no es visible");
  }
  
}
}
