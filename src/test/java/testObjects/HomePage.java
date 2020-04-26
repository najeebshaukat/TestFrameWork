package testObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class HomePage extends Base {

	// logger
	public static Logger Log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() {

		LandingPage i = new LandingPage(driver);
		i.sendEmail().sendKeys("testemail@testemail.com");
		i.sendPass().sendKeys("testpassword");
		i.clickLogin().click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver = null;
	}
}