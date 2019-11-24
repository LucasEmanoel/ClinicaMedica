package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterSecretariaPage extends RegisterPage {

	public RegisterSecretariaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void registrarSecretaria(String nome, String cpf, String rg, String quali, String sal, String idade,
			String rua, String bairro, String cep, String tel1, String tel2, String email, String senha, String clinica) {

		this.getDriver().findElement(this.nomeInput).sendKeys(nome);
		this.getDriver().findElement(this.cpfInput).sendKeys(cpf);
		this.getDriver().findElement(this.rgInput).sendKeys(rg);
		this.getDriver().findElement(this.qualificacaoInput).sendKeys(quali);
		this.getDriver().findElement(this.salarioInput).sendKeys(sal);
		Select clinicas = new Select(this.getDriver().findElement(this.selectClinica));
		clinicas.selectByVisibleText(clinica);
		this.getDriver().findElement(this.idadeInput).sendKeys(idade);
		this.getDriver().findElement(this.ruaInput).sendKeys(rua);
		this.getDriver().findElement(this.bairroInput).sendKeys(bairro);
		this.getDriver().findElement(this.cepInput).sendKeys(cep);
		this.getDriver().findElement(this.tel1Input).sendKeys(tel1);
		this.getDriver().findElement(this.tel2Input).sendKeys(tel2);
		this.getDriver().findElement(this.emailInput).sendKeys(email);
		this.getDriver().findElement(this.senhaInput).sendKeys(senha);
	}

}
