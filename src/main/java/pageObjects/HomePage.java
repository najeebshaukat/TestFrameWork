package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(id = "headerSearch")
	private WebElement search;
	
	@FindBy(id = "headerSearchButton")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement search() {
		return search;
	}
	
	public WebElement clickSearch() {
		return searchButton;
	}
}