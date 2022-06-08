package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;
import com.selenium.pages.WikiHomePage;

public class TestWiki {
	@Test(description = "Validar texto de bienvenida")
	
	public void ValidarTextoBienvenida() {
		WebDriver driver = null;
		driver = DriverFactory.LevantarBrowser(driver, "CHROME", "https://es.wikipedia.org/wiki/Wikipedia:Portada");
		
		WikiHomePage wiki = new WikiHomePage(driver);
		wiki.validarTextoBienvenida();
		driver.close();
	}
}
