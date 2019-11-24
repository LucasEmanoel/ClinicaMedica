package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterMedicoPage extends RegisterPage {

	public RegisterMedicoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void registrarMedico(String nome, String crm, String cpf, String sal, String rg, String idade, String rua,
			String bairro, String cep, String tel1, String tel2, String email, String senha, String clinica) {

		this.getDriver().findElement(this.nomeInput).sendKeys(nome);
		this.getDriver().findElement(this.crmInput).sendKeys(crm);
		this.getDriver().findElement(this.cpfInput).sendKeys(cpf);
		this.getDriver().findElement(this.rgInput).sendKeys(rg);
		Select clinicas = new Select(this.getDriver().findElement(this.selectClinica));
		clinicas.selectByVisibleText(clinica);
		this.getDriver().findElement(this.salarioInput).sendKeys(sal);
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
