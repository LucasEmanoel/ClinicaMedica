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

import pages.HomePage;
import pages.LoginPage;
import pages.PerfilPage;
import pages.RegisterClientePage;
import pages.UserPage;


public class ClienteTest {

	private static ChromeDriverService service;
	private static WebDriver driver;
	private RegisterClientePage register;
	private LoginPage login;
	private PerfilPage perfil;
	private HomePage home;
	private UserPage userLogado;
	
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
		this.home = new HomePage(driver);
		this.userLogado = new UserPage(driver);
	}
	
	//teste pratico 
	@Test	
	public void registerClientTest() throws InterruptedException {
		this.home.goToHomePage();
		this.home.goToRegisterClient();

		this.register.registrarCliente("joao", "29853596008", "5", "30", "10", "10", "10", "10", "10", "clienteSelenium@gmail.com", "5");
		
		this.login.logar("clienteSelenium@gmail.com", "5");
		
		this.userLogado.goToPerfil();
		assertTrue(driver.getPageSource().contains("29853596008"));
		this.perfil.editar("Doidao");
		assertTrue(driver.getPageSource().contains("Doidao"));
		this.perfil.deletar();
		this.login.goToLogin();
		this.login.logar("clienteSelenium@gmail.com", "5");
		assertTrue(this.login.loginErrado());
		
	}

}
