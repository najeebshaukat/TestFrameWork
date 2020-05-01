package testObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomeDepotCreateAccount;
import resources.Base;

public class CreateAccountTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	HomeDepotCreateAccount hd;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void homedepotCreateAccount() {
		hd = new HomeDepotCreateAccount(driver); 
		
		hd.clickHeaderMyAccount().click();
		hd.clickRegister().click();
		hd.enterEmail().sendKeys("testemail@testemail.com");
		hd.enterPass().sendKeys("TestPassword");
		hd.enterZipCode().sendKeys("12345");
		hd.enterPhoneNumber().sendKeys("1234567890");
		hd.clickCheckBox().click();
		hd.clickSubmit().click();
		hd.clickSkipLink().click();
		String err = hd.getErrorMessage().getText();
		log.error(err);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver = null;
	}
}