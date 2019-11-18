package selenium;

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

public class LoginComSeleniumTest {

	private static ChromeDriverService service;
	private WebDriver driver;

	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("C:\\Users\\Lucas Barros\\chromedriver.exe"))
				.usingAnyFreePort()
				.build();
		service.start();
	}

	@AfterClass
	public static void stopService() {
		service.stop();
	}

	@Before
	public void createDriver() {
		driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
	}

	@After
	public void quitDriver() {
		driver.quit();
	}
	
	@Test
	public void loginErradoTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt12")).click();
		
		driver.findElement(By.name("j_idt6:j_idt9")).sendKeys("errado@gmail.com");
		driver.findElement(By.name("j_idt6:j_idt10")).sendKeys("errado");
		driver.findElement(By.name("j_idt6:j_idt12")).click();
		Thread.sleep(50000);
		
		boolean msg = driver.findElement(By.id("j_idt6:messages")).isDisplayed();
		assertTrue(msg);
		
	}
	
	@Test
	public void loginClienteTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt12")).click();
		
		driver.findElement(By.name("j_idt6:j_idt9")).sendKeys("clienteSelenium@gmail.com");
		driver.findElement(By.name("j_idt6:j_idt10")).sendKeys("5");
		driver.findElement(By.name("j_idt6:j_idt12")).click();
		Thread.sleep(10000);
		
		boolean navBar = driver.findElement(By.id("j_idt13:j_idt16")).isDisplayed();
		assertTrue(navBar);
	}
	
	@Test
	public void loginClinicaTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt12")).click();
		
		driver.findElement(By.name("j_idt6:j_idt9")).sendKeys("clinicaSelenium@gmail.com");
		driver.findElement(By.name("j_idt6:j_idt10")).sendKeys("5");
		driver.findElement(By.name("j_idt6:j_idt12")).click();
		
		Thread.sleep(10000);
		
		boolean navBar = driver.findElement(By.id("form:j_idt14")).isDisplayed();
		assertTrue(navBar);
	}
	
	@Test
	public void loginMedicoTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt12")).click();
		
		driver.findElement(By.name("j_idt6:j_idt9")).sendKeys("medicoSelenium@gmail.com");
		driver.findElement(By.name("j_idt6:j_idt10")).sendKeys("5");
		driver.findElement(By.name("j_idt6:j_idt12")).click();
		
		
		
		Thread.sleep(10000);
		
		boolean navBar = driver.findElement(By.id("j_idt12:j_idt15")).isDisplayed();
		assertTrue(navBar);
	}
	
	@Test
	public void loginSecretariaTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt12")).click();
		
		driver.findElement(By.name("j_idt6:j_idt9")).sendKeys("secretariaSelenium@gmail.com");
		driver.findElement(By.name("j_idt6:j_idt10")).sendKeys("10");
		driver.findElement(By.name("j_idt6:j_idt12")).click();
		
		Thread.sleep(10000);
		
		boolean navBar = driver.findElement(By.id("j_idt12:j_idt15")).isDisplayed();
		assertTrue(navBar);
		
	}
}
