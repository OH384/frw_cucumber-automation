package com.e2etests.automation.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.e2etests.automation.page_objects.RegisterPage;
import com.e2etests.automation.utils.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinition {

	private RegisterPage registerPage;

	public RegisterStepDefinition() {

		this.registerPage = new RegisterPage();

	}

	@Given("je me connecte sur la page enregistrement")
	public void jeMeConnecteSurLaPageEnregistrement() {
		registerPage.gotoURL();
	}

	@When("je saisi le First Name {string}")
	public void jeSaisiLeFirstName(String firstname) {
		registerPage.fillFirstName(firstname);

	}

	@When("je saisi le Last Name {string}")
	public void jeSaisiLeLastName(String lastname) {
		registerPage.fillLastName(lastname);
	}

	@When("je saisi le Phone Number {string}")
	public void jeSaisiLePhoneNumber(String phone) {
		registerPage.fillPhone(phone);
	}

	@When("je saisi le Address Email {string}")
	public void jeSaisiLeAddressEmail(String username) {
		registerPage.fillAddressEmail(username);
	}

	@When("je saisi le Address One {string}")
	public void jeSaisiLeAddressOne(String address1) {
		registerPage.fillAdressOne(address1);
	}

	@When("je saisi le City Name {string}")
	public void jeSaisiLeCityName(String city) {
		registerPage.fillCityName(city);
	}

	@When("je saisi le State Name {string}")
	public void jeSaisiLeStateName(String state) {
		registerPage.fillStateName(state);
	}

	@When("je saisi le Postal Code {string}")
	public void jeSaisiLePostalCode(String postalCode) {
		registerPage.fillPostalCode(postalCode);
	}

	@When("je selectionne le Country Name {string}")
	public void jeSelectionneLeCountryName(String country) {
		registerPage.fillCountryName(country);
	}

	@When("je saisi le User Name {string}")
	public void jeSaisiLeUserName(String email) {
		registerPage.fillUserName(email);
	}

	@When("je saisi le Password {string}")
	public void jeSaisiLePassword(String password) {
		registerPage.fillPassWord(password);
	}

	@When("je saisi le Confirm Password {string}")
	public void jeSaisiLeConfirmPassword(String confirmPassword) {
		registerPage.fillConfirmPassword(confirmPassword);

	}

	@When("je clique sur le Bouton Envoyer")
	public void jeCliqueSurLeBoutonEnvoyer() {
		registerPage.clickOnSentButton();

	}

	@Then("je me redirige vers la page validation du formulaire inscription {string}")
	public void jeMeRedirigeVersLaPageValidationDuFormulaireInscription(String text) {
		String message =  registerPage.noteMessage.getText();
		Assert.assertEquals("Note: Your user name is test.", text);
	}
}
