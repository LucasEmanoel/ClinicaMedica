package pages;

import org.openqa.selenium.WebDriver;

public class RegisterClinicaPage extends RegisterPage {

	public RegisterClinicaPage(WebDriver driver) {
		super(driver);
	}

	public void registrarClinica(String cnpj, String nome, String email, String bairro, String cep, String rua,
			String senha, String idade, String tel1, String tel2) {

		this.getDriver().findElement(this.cnpjInput).sendKeys(cnpj);
		this.getDriver().findElement(this.nomeInput).sendKeys(nome);
		this.getDriver().findElement(this.emailInput).sendKeys(email);
		this.getDriver().findElement(this.bairroInput).sendKeys(bairro);
		this.getDriver().findElement(this.cepInput).sendKeys(cep);
		this.getDriver().findElement(this.ruaInput).sendKeys(rua);
		this.getDriver().findElement(this.senhaInput).sendKeys(senha);
		this.getDriver().findElement(this.idadeInput).sendKeys(idade);
		this.getDriver().findElement(this.tel1Input).sendKeys(tel1);
		this.getDriver().findElement(this.tel2Input).sendKeys(tel2);

		this.getDriver().findElement(this.registerClinicaBtn).click();
	}

}
