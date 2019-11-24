package selenium;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import pages.LoginPage;
import pages.PerfilPage;
import pages.RegisterClinicaPage;
import pages.RegisterSecretariaPage;

public class SecretariaTest {

	private static ChromeDriverService service;
	private static WebDriver driver;
	private RegisterSecretariaPage register;
	private RegisterClinicaPage registerCli;
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
		this.register = new RegisterSecretariaPage(driver);
		this.login = new LoginPage(driver);
		this.perfil =  new PerfilPage(driver);
		this.registerCli = new RegisterClinicaPage(driver);
	}

	@Test
	public void registerSecretariaTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt13")).click();
		driver.findElement(By.name("clinica")).click();
		
		this.registerCli.registrarClinica("66230422000161", "clinicaSecretaria", "clinicaSecretaria@gmail.com", "152", "12", "211", "5", "15","15", "541");
		Thread.sleep(1000);
		
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt13")).click();
		driver.findElement(By.name("secretaria")).click();
		
		this.register.registrarSecretaria(
				"secretariaSel", "33934914071", "121", "nada", "50.000", "23", "15", "51", "211",
				"54431", "53135", "secretariaSelenium@gmail.com", "5", "clinicaSecretaria");
		Thread.sleep(1000);
		driver.findElement(By.id("j_idt11:j_idt30")).click();
		Thread.sleep(1000);
		this.login.logar("secretariaSelenium@gmail.com", "5");
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Perfil")).click();
		Thread.sleep(1000);
		assertTrue(driver.getPageSource().contains("secretariaSel"));
		
		this.perfil.editar("secretariaSelZ");
		Thread.sleep(1000);
		assertTrue(driver.getPageSource().contains("secretariaSelZ"));
		
		this.perfil.deletar();
		driver.get("http://localhost:8080/ClinicaMedica/LoginView.xhtml");
		Thread.sleep(1000);
		this.login.logar("secretariaSelenium@gmail.com", "5");
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.id("j_idt6:messages")).isDisplayed());
	
		this.login.logar("clinicaSecretaria@gmail.com", "5");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Perfil")).click();
		this.perfil.deletar();
		driver.get("http://localhost:8080/ClinicaMedica/LoginView.xhtml");
		Thread.sleep(1000);
		this.login.logar("clinicaSecretaria@gmail.com", "5");
		assertTrue(driver.findElement(By.id("j_idt6:messages")).isDisplayed());
	}

}
