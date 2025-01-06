package com.e2etests.automation.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.e2etests.automation.page_objects.AuthenticationOrangehrmPage;
import com.e2etests.automation.utils.BasePage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationOrangehrmStepDefinition extends BasePage {
	private WebDriver driver;
	private AuthenticationOrangehrmPage authenticationOrangehrmPage;
	private Validations validations;
	private ConfigFileReader configfilereader;
	private SeleniumUtils seleniumutils;

	public AuthenticationOrangehrmStepDefinition() {
		this.authenticationOrangehrmPage = new AuthenticationOrangehrmPage();
		this.validations = new Validations();
		this.configfilereader = new ConfigFileReader();
		this.seleniumutils = new SeleniumUtils();
	}
//
//	@Given("je suis sur la page de connexion d OrangeHRM")
//	public void jeSuisSurLaPageDeConnexionDOrangeHRM(String url) {
//		seleniumutils.get(configfilereader.getProperties(url));
//	}
//
//	@When("je saisis un nom d utilisateur {string}")
//	public void jeSaisisUnNomDUtilisateur(String username) {
//		seleniumutils.writeText(authenticationOrangehrmPage.userName, configfilereader.getProperties("home.login"));
//	}
//
//	@When("je saisis un mot de passe {string}")
//	public void jeSaisisUnMotDePasse(String password) {
//		seleniumutils.writeText(authenticationOrangehrmPage.passWord, configfilereader.getProperties("home.password"));
//	}
//
//	@When("je clique sur le bouton de connexion")
//	public void jeCliqueSurleBoutonDeConnexion() {
//		seleniumutils.click(authenticationOrangehrmPage.loginButton);
//
//	}
//
//	@Then("je me redirige vers le tableau de bord d OrangeHRM")
//	public void jeMeRedirigeVersLeTableauDeBordDOrangeHRM() {
//		Assert.assertEquals("Redirection vers le tableau de bord échouée", authenticationOrangehrmPage.dashboardNote);
//		driver.quit();
//	}
//	
//	@When("je clique sur l'icône de propriétaire du compte")
//    public void jeCliqueSurLIconeDeProprietaireDuCompte() {
//		seleniumutils.click(authenticationOrangehrmPage.accountMenuButton);
//	}
//
//	@When("je clique sur le bouton de déconnexion")
//	public void jeCliqueSurLeBoutonDeDeconnexion() {
//		seleniumutils.click(authenticationOrangehrmPage.logOut);
//	}
//	@Then("je suis redirigé vers la page de connexion")
//    public void jeSuisRedirigeVersLaPageDeConnexion() {
//		Assert.assertEquals("La page de connexion devrait être affichée", authenticationOrangehrmPage.loginNote);
//		driver.quit();
//	}

	@Given("je suis sur la page de connexion d OrangeHRM {string}")
	public void jeSuisSurLaPageDeConnexionDOrangeHRM(String url) {
		seleniumutils.get(configfilereader.getProperties(url));
	}
	@When("je saisis un nom d utilisateur {string}")
	public void jeSaisisUnNomDUtilisateur(String userName) {
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
	@Then("je me redirige vers le tableau de bord d OrangeHRM")
	public void jeMeRedirigeVersLeTableauDeBordDOrangeHRM() {
		Assert.assertEquals("Redirection vers le tableau de bord échouée", authenticationOrangehrmPage.dashboardNote);
		driver.quit();
	}
	
	@When("je clique sur l icone de proprieteaire du compte")
    public void jeCliqueSurLIconeDeProprietaireDuCompte() {
		seleniumutils.click(authenticationOrangehrmPage.accountMenuButton);
	}
	
	@When("je clique sur le bouton de déconnexion")
	public void jeCliqueSurLeBoutonDeDeconnexion() {
		seleniumutils.click(authenticationOrangehrmPage.logOut);
	}
	@Then("je me redirige vers la page de connexion")
    public void jeSuisRedirigeVersLaPageDeConnexion() {
		Assert.assertEquals("La page de connexion devrait être affichée", authenticationOrangehrmPage.loginNote);
		driver.quit();
}


	}
