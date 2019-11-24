package selenium;


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
import pages.RegisterMedicoPage;

public class MedicoTest {

	private static ChromeDriverService service;
	private static WebDriver driver;
	private RegisterClinicaPage registerCli;
	private RegisterMedicoPage register;
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
		this.register = new RegisterMedicoPage(driver);
		this.login = new LoginPage(driver);
		this.perfil =  new PerfilPage(driver);
		this.registerCli = new RegisterClinicaPage(driver);
		
	}

	@Test
	public void registerMedicoTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt13")).click();
		driver.findElement(By.name("clinica")).click();
		this.registerCli.registrarClinica("21981767000119", "clinicaMedico", "clinicaMedico@gmail.com", "152", "12", "211", "5", "15","15", "541");
		Thread.sleep(1000);
		
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt13")).click();
		driver.findElement(By.name("medico")).click();
		
		this.register.registrarMedico(
				"medicoSelenium", "153", "64859690044", "10.000", "154", "54",
				"654", "654", "12", "126", "16545", "medicoSelenium@gmail.com", "5","clinicaMedico");
		Thread.sleep(1000);
		driver.findElement(By.id("j_idt11:j_idt30")).click();
		Thread.sleep(1000);
		this.login.logar("medicoSelenium@gmail.com", "5");
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Perfil")).click();
		Thread.sleep(5000);
		assertTrue(driver.getPageSource().contains("medicoSelenium"));
	
		this.perfil.editar("medicoSeleniumZ");
		Thread.sleep(1000);
		assertTrue(driver.getPageSource().contains("medicoSeleniumZ"));
		
		this.perfil.deletar();
		Thread.sleep(1000);
		driver.get("http://localhost:8080/ClinicaMedica/LoginView.xhtml");
		Thread.sleep(1000);
		this.login.logar("medicoSelenium@gmail.com", "5");
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.id("j_idt6:messages")).isDisplayed());
		Thread.sleep(1000);
		this.login.logar("clinicaMedico@gmail.com", "5");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Perfil")).click();
		this.perfil.deletar();
		driver.get("http://localhost:8080/ClinicaMedica/LoginView.xhtml");
		Thread.sleep(1000);
		this.login.logar("clinicaMedico@gmail.com", "5");
		assertTrue(driver.findElement(By.id("j_idt6:messages")).isDisplayed());
	}
}
