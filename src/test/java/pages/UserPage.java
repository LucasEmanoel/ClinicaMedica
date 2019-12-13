package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
	
	private WebDriver driver;
	By opcaoPerfil = By.linkText("Perfil");
	
	public UserPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void goToPerfil() {
		this.driver.findElement(this.opcaoPerfil).click();
	}
}
