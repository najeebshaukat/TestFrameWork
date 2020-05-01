package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeDepotLogin {

	public WebDriver driver;
	
	//elements
	@FindBy(id = "headerMyAccount")
	private WebElement headerMyAccount;
	
	@FindBy(id = "SPSOSignIn")
	private WebElement signIn;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "password-input-field")
	private WebElement password;
	
	@FindBy(xpath = "//span[contains(text(),'Sign In')]")
	private WebElement submit;
	
	@FindBy(xpath = "//span[@class='alert-inline__message']")
	private WebElement alert;
	
	//constructor
	public HomeDepotLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public WebElement clickHeaderMyAccount() {
		return headerMyAccount;
	}
	
	public WebElement clickSignIn() {
		return signIn;
	}
	
	public WebElement enterEmail() {
		return email;
	}
	
	public WebElement enterPassword() {
		return password;
	}
	
	public WebElement clickSubmit() {
		return submit;
	}
	
	public WebElement getAlert() {
		return alert;
	}
}
