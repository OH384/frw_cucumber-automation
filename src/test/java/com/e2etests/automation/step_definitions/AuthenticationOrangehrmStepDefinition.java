package com.e2etests.automation.step_definitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2etests.automation.page_objects.AuthenticationOrangehrmPage;
import com.e2etests.automation.utils.BasePage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SelectFromListUtils;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationOrangehrmStepDefinition extends BasePage {
	private WebDriver driver;
	private AuthenticationOrangehrmPage authenticationOrangehrmPage;
	private Validations validations;
	private ConfigFileReader configfilereader;
	private SeleniumUtils seleniumutils;
	private Wait wait;
	private SelectFromListUtils selectFromListUtils;

	public AuthenticationOrangehrmStepDefinition() {
		this.authenticationOrangehrmPage = new AuthenticationOrangehrmPage();
		this.validations = new Validations();
		this.configfilereader = new ConfigFileReader();
		this.seleniumutils = new SeleniumUtils();
		this.wait = new Wait (driver);
		this.selectFromListUtils = new SelectFromListUtils();
	}

	@Given("je suis sur la page de connexion d OrangeHRM {string}")
	public void jeSuisSurLaPageDeConnexionDOrangeHRM(String url) {
		seleniumutils.get(configfilereader.getProperties(url));
		driver = Setup.getDriver();
	}

	@When("je saisis un nom d utilisateur {string}")
	public void jeSaisisUnNomDUtilisateur(String userName) {
		wait.forElementToBeDisplayed(Duration.ofSeconds(10), authenticationOrangehrmPage.userName, "Username field");
		seleniumutils.writeText(authenticationOrangehrmPage.userName, configfilereader.getProperties("home.login"));
	}

	@When("je saisis un mot de passe  {string}")
	public void jeSaisisUnMotDePasse(String passWord) {
		seleniumutils.writeText(authenticationOrangehrmPage.passWord, configfilereader.getProperties("home.password"));
	}

	@When("je clique sur le bouton de connexion")
	public void jeCliqueSurLeBoutonDeConnexion() {
		seleniumutils.click(authenticationOrangehrmPage.loginButton);
	}

//	@Then("je me redirige vers le tableau de bord d OrangeHRM")
//	public void jeMeRedirigeVersLeTableauDeBordDOrangeHRM() {
//		Assert.assertEquals("Redirection vers le tableau de bord échouée",
//				authenticationOrangehrmPage.accountMenuButton);
//		driver.quit();
//	}
	
	@Then("je me redirige vers le tableau de bord d OrangeHRM")
	public void jeMeRedirigeVersLeTableauDeBordDOrangeHRM() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(30), authenticationOrangehrmPage.dashboardNote, "dashboardNote");
		Assert.assertEquals("Dashboard",authenticationOrangehrmPage.dashboardNote.getText());
		driver.quit();
	}

	@When("je clique sur l icone de proprieteaire du compte")
	public void jeCliqueSurLIconeDeProprietaireDuCompte() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(30), authenticationOrangehrmPage.accountMenuButton, "accountMenuButton");
		seleniumutils.click(authenticationOrangehrmPage.accountMenuButton);
//		selectFromListUtils.selectDropDownListByVisibleText(authenticationOrangehrmPage.logOut,"Logout");
	}

	@When("je clique sur le bouton de déconnexion")
	public void jeCliqueSurLeBoutonDeDeconnexion() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(30), authenticationOrangehrmPage.logOut, "Logout");
		seleniumutils.click(authenticationOrangehrmPage.logOut);
	}

	@Then("je me redirige vers la page de connexion")
	public void jeSuisRedirigeVersLaPageDeConnexion() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(30), authenticationOrangehrmPage.loginNote, "loginNote");
		Assert.assertEquals("Login",authenticationOrangehrmPage.loginNote.getText());
		driver.quit();
	}

}
