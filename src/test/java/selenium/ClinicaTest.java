package selenium;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import pages.LoginPage;
import pages.PerfilPage;
import pages.RegisterClinicaPage;

public class ClinicaTest {

	private static ChromeDriverService service;
	private static WebDriver driver;
	private RegisterClinicaPage register;
	private LoginPage login;
	private PerfilPage perfil;
	
	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("C:\\Users\\Lucas Barros\\chromedriver.exe"))
				.usingAnyFreePort()
				.build();
		service.start();
		driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
	}

	@AfterClass
	public static void stopService() {
		driver.quit();
		service.stop();
	}

	@Before
	public void initialize() {
		this.register = new RegisterClinicaPage(driver);
		this.login = new LoginPage(driver);
		this.perfil =  new PerfilPage(driver);
	}

	@Test
	public void registerClinicaTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt13")).click();
		driver.findElement(By.name("clinica")).click();
		
		this.register.registrarClinica("14528336000136", "clinica", "clinicaSelenium@gmail.com", "13", "12", "10", "5", "40", "20", "20");
		Thread.sleep(1000);
		this.login.logar("clinicaSelenium@gmail.com", "5");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Perfil")).click();
		Thread.sleep(1000);
		assertTrue(driver.getPageSource().contains("14528336000136"));
		
		this.perfil.editar("clinicaSelenium");
		Thread.sleep(1000);
		assertTrue(driver.getPageSource().contains("clinicaSelenium"));
		Thread.sleep(1000);
		this.perfil.deletar();
		driver.get("http://localhost:8080/ClinicaMedica/LoginView.xhtml");
		Thread.sleep(1000);
		this.login.logar("clinicaSelenium@gmail.com", "5");
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.id("j_idt6:messages")).isDisplayed());
		
	}

}
