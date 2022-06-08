package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WikiHomePage {
	WebDriver driver = null;
	
	@FindBy(css="a[href='/wiki/Wikipedia:Bienvenidos']")
	private WebElement texto;
	
	public WikiHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validarTextoBienvenida(){
	  Assert.assertEquals("Bienvenidos", texto.getText(), "Los textos no coinciden");
	  }
}
