package com.e2etests.automation.page_objects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class RegisterPage {

	private ConfigFileReader configFileReader;
	private WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
	
	/* @FindBy */
	@FindBy(xpath = "//a[@href='register.php']")
	public static WebElement register;
	
	@FindBy(how = How.NAME, using = "firstName")
	public static WebElement firstName;

	@FindBy(how = How.NAME, using = "lastName")
	public static WebElement lastName;

	@FindBy(how = How.NAME, using = "phone")
	public static WebElement phoneNumber;

	@FindBy(how = How.ID, using = "userName")
	public static WebElement emailName;

	@FindBy(how = How.NAME, using = "address1")
	public static WebElement addressOne;

	@FindBy(how = How.NAME, using = "city")
	public static WebElement cityName;

	@FindBy(how = How.NAME, using = "state")
	public static WebElement stateName;

	@FindBy(how = How.NAME, using = "postalCode")
	public static WebElement postalCode;

	@FindBy(how = How.NAME, using = "country")
	public static WebElement countryName;

	@FindBy(how = How.ID, using = "email")
	public static WebElement userName;

	@FindBy(how = How.NAME, using = "password")
	public static WebElement passWord;

	@FindBy(how = How.NAME, using = "confirmPassword")
	public static WebElement confirmPassWord;

	@FindBy(how = How.NAME, using = "submit")
	public static WebElement btnEnvoyer;

	@FindBy(how = How.TAG_NAME, using = "b")
	public static WebElement noteMessage;

	public RegisterPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		this.configFileReader = new ConfigFileReader();
	}

	/* Create Method */
	public void gotoURL() {
		Setup.getDriver().get(configFileReader.getProperties("home.url"));
	}
	public void registerBtn() {
		WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(register));
		registerBtn.click();
	}
	public void fillFirstName(String firstname) {
		firstName.sendKeys("firstname");
	}

	public void fillLastName(String lastname) {
		lastName.sendKeys("lastname");
	}

	public void fillPhone(String phone) {
		phoneNumber.sendKeys("phone");
	}

	public void fillAddressEmail(String username) {
		emailName.sendKeys("username");
	}

	public void fillAdressOne(String address1) {
		addressOne.sendKeys("address1");
	}

	public void fillCityName(String city) {
		cityName.sendKeys("city");
	}

	public void fillStateName(String state) {
		stateName.sendKeys("state");
	}

	public void fillPostalCode(String postalcode) {
		postalCode.sendKeys("postalCode");
	}

	public void fillCountryName(String country) {
		Select registerPage = new Select(countryName);
		registerPage.selectByValue(country);
	}

	public void fillUserName(String email) {
		userName.sendKeys("email");
	}

	public void fillPassWord(String password) {
		passWord.sendKeys("password");
	}

	public void fillConfirmPassword(String confirmPassword) {
		confirmPassWord.sendKeys("confirmPassword");
	}

	public void clickOnSentButton() {
		btnEnvoyer.click();
	}
	public String confirmationRegisterMessage() {
		WebElement confMessage = wait.until(ExpectedConditions.visibilityOf(noteMessage));
		return confMessage.getText();
	}
}