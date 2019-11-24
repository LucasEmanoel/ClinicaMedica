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

import pages.LoginPage;
import pages.PerfilPage;
import pages.RegisterClientePage;


public class ClienteTest {

	private static ChromeDriverService service;
	private static WebDriver driver;
	private RegisterClientePage register;
	private LoginPage login;
	private PerfilPage perfil;
	
	//ele usa algo similar ao builder do professor onde passa a configuracao do serviço
	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("C:\\Users\\Lucas Barros\\chromedriver.exe"))//caminho do driver
				.usingAnyFreePort()//usar qualquer porta que estiver livre
				.build();
		service.start();
		driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());//ele pega uma url padrao e joga nas opcoes do driver para abrir
	}
	
	//depois que termina tudo ele para o service
	@AfterClass
	public static void stopService() {
		driver.quit();
		service.stop();
	}
	
	//antes cria as pag que vao estar armazenadas atributos e acoes
	@Before
	public void initialize() {
		this.register = new RegisterClientePage(driver);
		this.login = new LoginPage(driver);
		this.perfil = new PerfilPage(driver);
	}
	
	//teste pratico 
	@Test	
	public void registerClientTest() throws InterruptedException {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
		driver.findElement(By.name("j_idt10:j_idt13")).click();//butao registrar
		driver.findElement(By.name("cliente")).click();//opcao de registrar cliente
		
		this.register.registrarCliente("joao", "29853596008", "5", "30", "10", "10", "10", "10", "10", "clienteSelenium@gmail.com", "5");
		//passando oq quero preencher para o pageObject ele msm clica em salvar o cliente e vai para login
		Thread.sleep(1000);
		this.login.logar("clienteSelenium@gmail.com", "5");//logando como cliente cadastrado
		Thread.sleep(1000);
		driver.findElement(By.linkText("Perfil")).click();//clicando na opcao de perfil da navBar
		Thread.sleep(1000);
		assertTrue(driver.getPageSource().contains("29853596008"));//verificando se uma das informaçoes ta la
		
		this.perfil.editar("Doidao");//alterando a informacao
		Thread.sleep(1000);
		assertTrue(driver.getPageSource().contains("Doidao"));//verificando se ficou alterada obs.:JSF bugado e nao redirect essa pagina entao..
		this.perfil.deletar();//deletando 
		Thread.sleep(1000);
		driver.get("http://localhost:8080/ClinicaMedica/LoginView.xhtml");//voltando pra login ja que nao redireciona
		Thread.sleep(1000);
		this.login.logar("clienteSelenium@gmail.com", "5");//se logar tem que aparecer o erro ja que nao ta cadastrado
		assertTrue(driver.findElement(By.id("j_idt6:messages")).isDisplayed());
		
	}

}
