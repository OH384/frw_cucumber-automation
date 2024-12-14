package com.e2etests.automation.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.e2etests.automation.page_objects.AuthenticationPage;
import com.e2etests.automation.utils.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationStepDefinition {


	private AuthenticationPage authenticationPage; 

	public AuthenticationStepDefinition() {
		this.authenticationPage = new AuthenticationPage();
	}

	@Given("je me connecte sur l application Mercury")
	public void jeMeConnecteSurLApplicationMercury() {
		authenticationPage.gotoURL();
	}

	@When("je saisi le user name {string}")
	public void jeSaisiLeUserName(String name) {
		authenticationPage.fillUserName(name);
	}

	@When("je saisi le password {string}")
	public void jeSaisiLePassword(String passWord) {
		authenticationPage.fillPassWord(passWord);
	}

	@When("je clique sur le bouton submit")
	public void jeCliqueSurleBoutonSubmit() {
		authenticationPage.clickOnSubmitButton();
	}

	@Then("je me redirige vers la page home {string}")
	public void jeMeRedirigeVersLaPageHome(String text) {
		String message = authenticationPage.welcomeMessage.getText();
		Assert.assertEquals(message, text);
		
	}

}
