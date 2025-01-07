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
	final static String ACCOUNTMENU_BUTTON = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span";
	final static String LOG_OUT = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a";
	final static String LOGIN_NOTE = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5";
	final static String DASHBOARD_NOTE = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6";
	
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