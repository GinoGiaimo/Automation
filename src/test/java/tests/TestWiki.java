package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;
import com.selenium.pages.WikiHomePage;

public class TestWiki {
	WebDriver driver = null;
	@BeforeMethod(alwaysRun=true)
	public void iniciarTest(ITestContext context) {
		String navegadorSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorSuite !=null ? navegadorSuite : "CHROME";
		
		String url = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
		driver = DriverFactory.LevantarBrowser(driver, navegador, url);
	}
	
	@Test(description = "Validar texto de bienvenida")
	public void ValidarTextoBienvenida() {
		WikiHomePage wiki = new WikiHomePage(driver);
		wiki.validarTextoBienvenida();
	}
	
	@AfterMethod()
	public void cerrarTest() {
		driver.close();
	}
}
