package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarAlojamientoPage {
	
  WebDriver driver = null;
  
  WebDriverWait wait;
  
  @FindBy(css="div[id='searchbox-sbox-box-hotels'] "
	  		+ "div.sbox5-3-input.sbox5-3-validation.-top-right.-lg.-icon-left input.input-tag")
  private WebElement destino;
  
  @FindBy(css="div.input-container "
	  		+ "input[placeholder='Entrada']")
  private WebElement fechaEntradaInput;
  
  @FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened")
  private WebElement calOpen;
  
  @FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div.sbox5-monthgrid.sbox5-compact-view div.-today")
  private WebElement fechaEntrada;
  
  @FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div.sbox5-3-floating-tooltip-datepicker-wrapper.sbox5-compact-view div.calendar-container > div.sbox5-monthgrid.sbox5-compact-view:nth-child(3) div.sbox5-monthgrid-datenumber.sbox5-monthgrid-datenumber-28")
  private WebElement fechaSalida;
  
  
  @FindBy(css="div.sbox5-3-distribution-passengers.sbox5-3-validation.-top-right div.sbox5-3-double-input")
  private WebElement habitaciones;
  
  @FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div.stepper__distribution_container "
				  + "div.stepper__room__row:nth-child(1) div.stepper__room__row__stepper__contaer "
				  + "button.steppers-icon-right.stepper__icon")
  private WebElement agregarAdulto;
  
  @FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div.stepper__distribution_container "
		  + "div.stepper__room__row:nth-child(2) "
		  + "div.stepper__room__row__stepper__contaer button.steppers-icon-right.stepper__icon")
  private WebElement agregarMenor;
  
  @FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened select.select")
  private WebElement edadMenor;
  
  @FindBy(css="option.select-option[value='10']")
  private WebElement edadSeleccionada;
  
  @FindBy(css="div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened a.sbox5-3-btn.-md.-primary")
  private WebElement btnAceptar;

  @FindBy(css="div.sbox5-box-content svg.sbox5-btn-svg")
  private WebElement btnBuscar;
   
  public DespegarAlojamientoPage(WebDriver driver) {
	  this.driver = driver;
	  this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	  PageFactory.initElements(driver, this);
  }
  
  public void IngresarDestino(String ciudad) throws Exception {
	  wait.until(ExpectedConditions.elementToBeClickable(destino));
	  destino.click();
	  destino.sendKeys(ciudad);
	  Thread.sleep(1000);
	  destino.sendKeys(Keys.CONTROL);
	  Thread.sleep(1000);		  
	  destino.sendKeys(Keys.ENTER);
  }
  
  public void ingresarFechaEntrada() {
	  fechaEntradaInput.click();
	  wait.until(ExpectedConditions.visibilityOf(calOpen));
	  fechaEntrada.click();
  }
  
  public void IngresarFechaSalida() {
	  wait.until(ExpectedConditions.elementToBeClickable(fechaSalida));
	  fechaSalida.click();
	  fechaSalida.click();
  }
  
  public void AgregarAdulto() {
	  habitaciones.click();
	  habitaciones.click();
	  
	  wait.until(ExpectedConditions.elementToBeClickable(agregarAdulto));
	  agregarAdulto.click();
  }
  
  public void AgregarMenor() {
	  agregarMenor.click();
	  wait.until(ExpectedConditions.elementToBeClickable(edadMenor));
	  edadMenor.click();
	  wait.until(ExpectedConditions.elementToBeClickable(edadSeleccionada));
	  edadSeleccionada.click();
	  edadMenor.click();
  }
  
  public DespegarResultsPage AceptarYBuscar() {
	  wait.until(ExpectedConditions.elementToBeClickable(btnAceptar));
	  btnAceptar.click();
	  btnBuscar.click();
	  
	  return new DespegarResultsPage(this.driver);
  }
  
  
  
  
}
