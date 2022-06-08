package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarResultsPage {
	WebDriver driver = null;
	  
	WebDriverWait wait;
	
	@FindBy(css="aloha-cluster-container[index='0']")
	private WebElement resultado;
	
	public DespegarResultsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean ValidarPrimerElemento() {
		return resultado.isDisplayed();
	}
}
