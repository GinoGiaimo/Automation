package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;
import com.selenium.pages.DespegarAlojamientoPage;
import com.selenium.pages.DespegarHomePage;
import com.selenium.pages.DespegarResultsPage;

public class TestDespegar {
	WebDriver driver = null;
	@BeforeMethod(alwaysRun=true)
	public void iniciarTest(ITestContext context) {
		String navegadorSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorSuite !=null ? navegadorSuite : "CHROME";
		
		String url = "https://www.despegar.com.ar/";
		driver = DriverFactory.LevantarBrowser(driver, navegador, url);
		}
	
	@DataProvider(name="lugares")
	public Object[][] LugaresProvider(){
		return new Object[][] {{"Buenos aires"}};
	}
	
	@Test(groups= {"grupo_1"}, dataProvider="lugares", description = "Validar seleccion de alojamiento")
	public void ValidarAlojamiento(String searchText) throws Exception {	
		DespegarHomePage homePage = new DespegarHomePage(driver);
		DespegarAlojamientoPage alojamientoPage = homePage.AlojamientoPage();
		alojamientoPage.IngresarDestino(searchText);
		alojamientoPage.ingresarFechaEntrada();
		alojamientoPage.IngresarFechaSalida();
		alojamientoPage.AgregarAdulto();
		alojamientoPage.AgregarMenor();
		DespegarResultsPage resultsPage = alojamientoPage.AceptarYBuscar();
		Assert.assertTrue(resultsPage.ValidarPrimerElemento(), "El elemento no es visible");
		}
	
	@Test(groups= {"grupo_1"}, description = "Validar lista")
	public void validarLista() {
		DespegarHomePage homePage = new DespegarHomePage(driver);
		homePage.verificarListaProductos();
	}
	
	@AfterMethod(alwaysRun=true)
	public void cerrarTest() {
		driver.close();
	}
	
	
}
