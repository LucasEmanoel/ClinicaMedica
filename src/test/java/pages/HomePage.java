package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	By btnRegister = By.name("j_idt10:j_idt13");
	By opcaoCliente = By.name("cliente");
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void goToHomePage() {
		driver.get("http://localhost:8080/ClinicaMedica/inicio.xhtml");
	}
	
	public void goToRegisterClient() {
		this.driver.findElement(this.btnRegister).click();
		this.driver.findElement(this.opcaoCliente).click();
	}
	
}
