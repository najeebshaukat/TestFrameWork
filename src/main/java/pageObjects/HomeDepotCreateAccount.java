package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeDepotCreateAccount {

	public WebDriver driver;

	// locators
	@FindBy(id = "headerMyAccount")
	private WebElement headerMyAccount;

	@FindBy(xpath = "//span[contains(text(), 'Register')]")
	private WebElement register;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password-input-field")
	private WebElement password;

	@FindBy(id = "zipCode")
	private WebElement zipCode;

	@FindBy(id = "phone")
	private WebElement phone;

	@FindBy(xpath = "//label[@for='is-pro-checkbox']")
	private WebElement checkBox;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement submit;

	@FindBy(id = "pro-skip-link")
	private WebElement skipLink;

	@FindBy(xpath = "//*[@class='alert-inline__message']")
	private WebElement errorMessage;

	// constructor
	public HomeDepotCreateAccount(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	// methods
	public WebElement clickHeaderMyAccount() {
		return headerMyAccount;
	}

	public WebElement clickRegister() {
		return register;
	}

	public WebElement enterEmail() {
		return email;
	}

	public WebElement enterPass() {
		return password;
	}

	public WebElement enterZipCode() {
		return zipCode;
	}

	public WebElement enterPhoneNumber() {
		return phone;
	}

	public WebElement clickCheckBox() {
		return checkBox;
	}

	public WebElement clickSubmit() {
		return submit;
	}

	public WebElement clickSkipLink() {
		return skipLink;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}
}