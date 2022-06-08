package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;
import com.selenium.pages.DespegarAlojamientoPage;
import com.selenium.pages.DespegarHomePage;
import com.selenium.pages.DespegarResultsPage;

public class TestDespegar {
	@Test(description = "Validar seleccion de alojamiento")
	
	public void ValidarAlojamiento() throws Exception {
		WebDriver driver = null;
		driver = DriverFactory.LevantarBrowser(driver, "CHROME", "https://www.despegar.com.ar/");
		
		DespegarHomePage homePage = new DespegarHomePage(driver);
		DespegarAlojamientoPage alojamientoPage = homePage.AlojamientoPage();
		alojamientoPage.IngresarDestino("Sevilla");
		alojamientoPage.ingresarFechaEntrada();
		alojamientoPage.IngresarFechaSalida();
		alojamientoPage.AgregarAdulto();
		alojamientoPage.AgregarMenor();
		DespegarResultsPage resultsPage = alojamientoPage.AceptarYBuscar();
		Assert.assertTrue(resultsPage.ValidarPrimerElemento(), "El elemento no es visible");
		driver.close();
		}
	
}
