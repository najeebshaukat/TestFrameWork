package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	WebDriver driver;
	
	@FindAll(value = { @FindBy(xpath="//span[contains(.,'Add to Cart')]") })
	private List<WebElement> itemList;
	
	@FindBy(xpath = "//span[@class='MyCart__label']")
	private WebElement viewCart;
	
	@FindBy(xpath = "//input[@data-automation-id='itemQuantityBoxQuantityInput']")
	private WebElement quantity;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> items() {
		return itemList;
	}
	
	public WebElement viewcart() {
		return viewCart;
	}
	
	public WebElement checkQuantity() {
		return quantity;
	}
}