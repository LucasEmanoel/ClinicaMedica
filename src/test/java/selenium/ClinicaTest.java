package selenium;


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

public class ClinicaTest {

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
	public void registerClinicaTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt13")).click();
		driver.findElement(By.name("clinica")).click();
		
		driver.findElement(By.id("j_idt11:cnpj")).sendKeys("72322044000149");
		driver.findElement(By.id("j_idt11:nome")).sendKeys("clinicaSelenium");
		driver.findElement(By.id("j_idt11:idade")).sendKeys("15");
		driver.findElement(By.id("j_idt11:rua")).sendKeys("10");
		driver.findElement(By.id("j_idt11:bairro")).sendKeys("10");
		driver.findElement(By.id("j_idt11:cep")).sendKeys("10");
		driver.findElement(By.id("j_idt11:tel1")).sendKeys("10");
		driver.findElement(By.id("j_idt11:tel2")).sendKeys("10");
		driver.findElement(By.id("j_idt11:email")).sendKeys("clinicaSelenium@gmail.com");
		driver.findElement(By.id("j_idt11:senha")).sendKeys("5");
		
		driver.findElement(By.id("j_idt11:j_idt25")).click();
		Thread.sleep(10000);
		
	}

}
