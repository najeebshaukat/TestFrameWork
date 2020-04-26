package testObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {

	// logger
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	LandingPage l;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() {
		l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "sign up");
		Log.info("Successfully validated Test message");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver = null;
	}
}