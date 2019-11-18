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
import org.openqa.selenium.support.ui.Select;

public class SecretariaTest {

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
	public void registerSecretariaTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt13")).click();
		driver.findElement(By.name("secretaria")).click();
		
		driver.findElement(By.id("j_idt11:nome")).sendKeys("secretariaSelenium");
		driver.findElement(By.id("j_idt11:cpf")).sendKeys("28970234063");
		driver.findElement(By.id("j_idt11:rg")).sendKeys("153");
		driver.findElement(By.id("j_idt11:quali")).sendKeys("geral");
		driver.findElement(By.id("j_idt11:sal")).sendKeys("5000");
		driver.findElement(By.id("j_idt11:idade")).sendKeys("30");
		
		Select clinicas = new Select(driver.findElement(By.id("j_idt11:somClinica")));
		clinicas.selectByVisibleText("clinicaSelenium");
		
		driver.findElement(By.id("j_idt11:rua")).sendKeys("30");
		driver.findElement(By.id("j_idt11:bairro")).sendKeys("30");
		driver.findElement(By.id("j_idt11:cep")).sendKeys("30");
		driver.findElement(By.id("j_idt11:tel1")).sendKeys("12");
		driver.findElement(By.id("j_idt11:tel2")).sendKeys("12");
		driver.findElement(By.id("j_idt11:email")).sendKeys("secretariaSelenium@gmail.com");
		driver.findElement(By.id("j_idt11:pass")).sendKeys("10");
		
		driver.findElement(By.id("j_idt11:j_idt30")).click();
		Thread.sleep(10000);
		
	}

}
