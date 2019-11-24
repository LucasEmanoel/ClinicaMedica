package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerfilPage extends RegisterPage {

	By btnSalvar = By.id("j_idt11:iconOnly");
	By btnDel = By.id("j_idt11:iconOnly2");

	public PerfilPage(WebDriver driver) {
		super(driver);
	}

	public void editar(String nome) {
		this.getDriver().findElement(this.nomeInput).clear();
		this.getDriver().findElement(this.nomeInput).sendKeys(nome);

		this.getDriver().findElement(this.btnSalvar).click();
	}

	public void deletar() {
		this.getDriver().findElement(this.btnDel).click();
	}
}
