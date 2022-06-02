package com.selenium.testaut;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;

public class DespegarTest {
	WebDriver driver;
	WebDriverWait wait = null;
	int tiempoEspera = 2;
	@SuppressWarnings("deprecation")
	@Test(description = "Validar seleccion de alojamiento")
	  public void ValidarSeleccionAlojamiento() throws Exception {
		  
		  driver = DriverFactory.LevantarBrowser(driver, "CHROME", "https://www.despegar.com.ar/");
		  
		  wait = new WebDriverWait(driver, 30);
		  
		  WebElement btnCookies = driver.findElement(By.cssSelector("a.lgpd-banner--button.eva-3-btn.-white.-md"));
		  btnCookies.click();
		  
		
		  //Buscamos el boton de alojamiento
		  WebElement btnAlojamiento = driver.findElement(By.cssSelector("a.shifu-3-button-circle.HOTELS."
		  		+ "paint-circle "));
		  btnAlojamiento.click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='searchbox-sbox-box-hotels'] "
			  		+ "div.sbox5-3-input.sbox5-3-validation.-top-right.-lg.-icon-left input.input-tag")));
		  
		  //Buscamos el input "destino" e ingresamos el mismo
		  WebElement destino = driver.findElement(By.cssSelector("div[id='searchbox-sbox-box-hotels'] "
		  		+ "div.sbox5-3-input.sbox5-3-validation.-top-right.-lg.-icon-left input.input-tag"));
		  destino.click();
		  destino.sendKeys("Sevilla");
		  Thread.sleep(1000);
		  destino.sendKeys(Keys.CONTROL);
		  Thread.sleep(1000);		  
		  destino.sendKeys(Keys.ENTER);
		  
		  //Buscar y seleccionar el elemento para fecha de entrada
		  WebElement fechaEntradaInput = driver.findElement(By.cssSelector("div.input-container "
		  		+ "input[placeholder='Entrada']"));
		  
		  fechaEntradaInput.click();
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sbox5-floating-tooltip."
			  		+ "sbox5-floating-tooltip-opened")));
		  
		  
		  //Buscar calendario abierto
		  WebElement calOpened = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip."
		  		+ "sbox5-floating-tooltip-opened"));
		  
		  //Seleccionar la fecha de entrada partiendo desde el calendario abierto
		  WebElement fechaEntrada = calOpened.findElement(By.xpath(".//div[@class='sbox5-monthgrid "
		  		+ "sbox5-compact-view' and @data-month='2022-06']//div[@class='sbox5-monthgrid-datenumber-number' and text()='9']"));
		  fechaEntrada.click();

		  WebElement fechaSalida = calOpened.findElement(By.xpath(".//div[@class='sbox5-monthgrid "
		  		+ "sbox5-compact-view' and @data-month='2022-07']//div[@class='sbox5-monthgrid-datenumber-number' and text()='1']"));
		  fechaSalida.click();
		
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox5-3-distribution-passengers.sbox5-3-validation.-top-right div.sbox5-3-double-input")));
		  
		  //Seleccionar habitaciones
		  WebElement habitaciones = driver.findElement(By.cssSelector(
				  "div.sbox5-3-distribution-passengers.sbox5-3-validation.-top-right div.sbox5-3-double-input"));
		  habitaciones.click();
		  habitaciones.click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				  "div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div.stepper__distribution_container "
				  + "div.stepper__room__row:nth-child(1) div.stepper__room__row__stepper__contaer "
				  + "button.steppers-icon-right.stepper__icon")));

		  //Agregamos un adulto
		  WebElement btnAgregarAdulto = driver.findElement(By.cssSelector(
				  "div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div.stepper__distribution_container "
				  + "div.stepper__room__row:nth-child(1) div.stepper__room__row__stepper__contaer "
				  + "button.steppers-icon-right.stepper__icon"));
		  btnAgregarAdulto.click();
		  
		  WebElement btnAgregarMenor = driver.findElement(By.cssSelector(
				  "div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened div.stepper__distribution_container "
				  + "div.stepper__room__row:nth-child(2) "
				  + "div.stepper__room__row__stepper__contaer button.steppers-icon-right.stepper__icon"));
		  btnAgregarMenor.click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened select.select")));

		  
		  WebElement edad = driver.findElement(By.cssSelector(
				  "div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened select.select"));
		  edad.click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option.select-option[value='10']")));

		  //---------------------------------------------------------
		  WebElement edadSeleccion = driver.findElement(By.cssSelector("option.select-option[value='10']"));
		  edadSeleccion.click();
		  edad.click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened a.sbox5-3-btn.-md.-primary")));

		  
		  WebElement btnAceptar = driver.findElement(By.cssSelector(
				  "div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened a.sbox5-3-btn.-md.-primary"));
		  btnAceptar.click();
		  
		  
		  WebElement btnBuscar = driver.findElement(By.cssSelector("div.sbox5-box-content svg.sbox5-btn-svg"));
		  btnBuscar.click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("aloha-cluster-container[index='0']")));

		  WebElement primerElemento = driver.findElement(By.cssSelector("aloha-cluster-container[index='0']"));
		  Assert.assertTrue(primerElemento.isDisplayed(), "El elemento no es visible");
		  
		  driver.close();
		  
	  }

}
