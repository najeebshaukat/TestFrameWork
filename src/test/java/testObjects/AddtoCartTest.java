package testObjects;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import resources.Base;

public class AddtoCartTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(priority=0)
	public void searchItem() {
		HomePage hdSearch = new HomePage(driver);
		hdSearch.search().sendKeys("Mosquito Repellent");
		hdSearch.clickSearch().click();
	}

	@Test(priority=1)
	public void addItem() {
		SearchResultPage item = new SearchResultPage(driver);
		item.items(); //initialize list
		item.items().get(2).click();
		WebElement popUp = driver.findElement(By.xpath("//iframe[@src and contains(@class, 'thd-overlay-frame')]"));
		driver.switchTo().frame(popUp);

		WebElement closePopUpButton = driver
				.findElement(By.xpath("//a[@data-automation-id='closeAddToCartOverlay']"));
		closePopUpButton.click();
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=2)
	public void viewCart() {
		SearchResultPage view = new SearchResultPage(driver);
		view.viewcart().click();
	}
	
	@Test(priority=3)
	public void quintityCheck() {
		Assert.assertEquals(1, 2);
	}
}