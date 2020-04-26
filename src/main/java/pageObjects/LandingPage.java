package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(id="loginbutton")
	private WebElement login;
	
	@FindBy(xpath="//h2[@class='_8est']")
	private WebElement title;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement sendEmail() {
		return email;
	}
	
	public WebElement sendPass() {
		return password;
	}
	
	public WebElement clickLogin() {
		return login;
	}
	
	public WebElement getTitle() {
		return title;
	}
}