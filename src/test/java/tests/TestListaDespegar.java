package tests;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;


public class TestListaDespegar {
	WebDriver driver = null;
	WebDriverWait wait;
	List<WebElement>listaElementos = null;
	@FindBy(css="a.header-logo-container")
	WebElement logo;
	
	@BeforeMethod(alwaysRun=true)
	public void iniciarTest(ITestContext context) {
		String navegadorSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorSuite !=null ? navegadorSuite : "CHROME";
		
		String url = "https://www.despegar.com.ar/";
		driver = DriverFactory.LevantarBrowser(driver, navegador, url);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		listaElementos = driver.findElements(By.cssSelector("ul.header-list-products > li"));
		}
	@Test(description = "Validar lista")
	public void ValidarLista() throws Exception {	
		//Integer errorer;
		Boolean b = null;
		for(WebElement elemento : listaElementos) {
			//elemento.click();
			//wait.until(ExpectedConditions.elementToBeClickable(logo));
			//Thread.sleep(000);
			WebElement label = elemento.findElement(By.cssSelector(" label"));
			label.click();
			if(elemento.isDisplayed() == true && label.getText().isEmpty() == false) {
				b = true;
			}
			
			Assert.assertTrue(b, "El elemento: " + label.getText() + " no es visible");
		}
		}
	@AfterMethod()
	public void cerrarTest() {
		driver.close();
	}
}
