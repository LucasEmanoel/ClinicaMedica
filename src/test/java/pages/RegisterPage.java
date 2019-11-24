package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	private WebDriver driver;

	By nomeInput = By.id("j_idt11:nome");
	By cnpjInput = By.id("j_idt11:cnpj");
	By crmInput = By.id("j_idt11:crm");
	By salarioInput = By.id("j_idt11:sal");
	By qualificacaoInput = By.id("j_idt11:quali");
	By cpfInput = By.id("j_idt11:cpf");
	By rgInput = By.id("j_idt11:rg");
	By idadeInput = By.id("j_idt11:idade");
	By ruaInput = By.id("j_idt11:rua");
	By bairroInput = By.id("j_idt11:bairro");
	By cepInput = By.id("j_idt11:cep");
	By tel1Input = By.id("j_idt11:tel1");
	By tel2Input = By.id("j_idt11:tel2");
	By emailInput = By.id("j_idt11:email");
	By senhaInput = By.id("j_idt11:senha");
	By registerClienteBtn = By.id("j_idt11:j_idt26");
	By registerClinicaBtn = By.id("j_idt11:j_idt25");
	By selectClinica = By.id("j_idt11:somClinica");

	public RegisterPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
