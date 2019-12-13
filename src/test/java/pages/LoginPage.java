package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	By emailInputLogin = By.id("j_idt6:j_idt9");
	By senhaInputLogin = By.id("j_idt6:j_idt10");
	By btnLogar = By.id("j_idt6:j_idt12");
	By erro = By.id("j_idt6:messages");
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public boolean loginErrado() {
		return this.driver.findElement(this.erro).isDisplayed();
	}
	
	public void goToLogin() {
		driver.get("http://localhost:8080/ClinicaMedica/LoginView.xhtml");
	}
	
	public void logar(String email, String senha) {
		this.driver.findElement(this.emailInputLogin).clear();
		
		this.driver.findElement(this.emailInputLogin).sendKeys(email);
		this.driver.findElement(this.senhaInputLogin).sendKeys(senha);

		this.driver.findElement(this.btnLogar).click();
	}
}
