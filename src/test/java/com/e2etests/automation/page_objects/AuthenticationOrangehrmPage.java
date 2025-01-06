package com.e2etests.automation.page_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;

public class AuthenticationOrangehrmPage {
	private ConfigFileReader configFileReader;
	private Validations validations;
	private SeleniumUtils seleniumutils;
	
	final static String USER_NAME = "username";
	final static String PASS_WORD = "password";
	final static String LOGIN_BUTTON = "//button[@type='submit']";
	final static String DASHBOARD_NOTE = "//h6[normalize-space()='Dashboard']";
	final static String ACCOUNTMENU_BUTTON = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']";
	final static String LOG_OUT = "//a[text()='Logout']";
	final static String LOGIN_NOTE = "//h5[normalize-space()='Login']";
	
	@FindBy(how = How.NAME, using = USER_NAME )
	public static WebElement userName;

	@FindBy(how = How.NAME, using = PASS_WORD)
	public static WebElement passWord;

	@FindBy(how = How.XPATH, using = LOGIN_BUTTON)
	public static WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = DASHBOARD_NOTE)
	public static WebElement dashboardNote;

	@FindBy(how = How.XPATH, using = ACCOUNTMENU_BUTTON)
	public static WebElement accountMenuButton;

	@FindBy(how = How.XPATH, using = LOG_OUT)
	public static WebElement logOut;
	
	@FindBy(how = How.XPATH, using = LOGIN_NOTE)
	public static WebElement loginNote;
	
	public AuthenticationOrangehrmPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		
	}
}