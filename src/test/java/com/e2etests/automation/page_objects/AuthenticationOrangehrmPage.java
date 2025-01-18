package com.e2etests.automation.page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SelectFromListUtils;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;


public class AuthenticationOrangehrmPage {
	private ConfigFileReader configFileReader;
	private Validations validations;
	private SeleniumUtils seleniumutils;
	private Wait wait;
	private SelectFromListUtils selectFromListUtils;
	
	final static String USER_NAME = "username";
	final static String PASS_WORD = "password";
	final static String LOGIN_BUTTON = "//button[@type='submit']";
	final static String ACCOUNT_MENU = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']";
	final static String LOG_OUT = "//a[contains(text(),'Logout')]";
	final static String LOGIN_NOTE = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']";
	final static String DASHBOARD_NOTE = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";
	
	@FindBy(how = How.NAME, using = USER_NAME )
	public static WebElement userName;

	@FindBy(how = How.NAME, using = PASS_WORD)
	public static WebElement passWord;

	@FindBy(how = How.XPATH, using = LOGIN_BUTTON)
	public static WebElement loginButton;
	@FindBy(how = How.XPATH, using = DASHBOARD_NOTE)
	public static WebElement dashboardNote;
	
	@FindBy(how = How.XPATH, using = ACCOUNT_MENU)
	public static WebElement accountMenuButton;

	@FindBy(how = How.XPATH, using = LOG_OUT)
	public static WebElement logOut;
	
	@FindBy(how = How.XPATH, using = LOGIN_NOTE)
	public static WebElement loginNote;
	
	public AuthenticationOrangehrmPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		
	}
}