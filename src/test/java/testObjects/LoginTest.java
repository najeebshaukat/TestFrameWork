package testObjects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomeDepotLogin;
import resources.Base;

public class LoginTest extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	HomeDepotLogin hdLogin;
	
  @BeforeTest
  public void initialize() throws IOException {
	  driver = initializeDriver();
  }
  
  @Test(dataProvider="getData") //data driven
  public void testLogin(String email, String password, String text) {
	  
	  driver.get(prop.getProperty("url"));
	  
	  hdLogin = new HomeDepotLogin(driver);
	  
	  hdLogin.clickHeaderMyAccount().click();
	  hdLogin.clickSignIn().click();
	  
	  Assert.assertEquals(hdLogin.clickSubmit().isDisplayed(), true, "Submit button greyed out");
	  hdLogin.enterEmail().sendKeys(email);
	  hdLogin.enterPassword().sendKeys(password);
	  hdLogin.clickSubmit().click();
	  log.error(hdLogin.getAlert().getText());
	  System.out.println(text);
	  log.info(text);
  }
  
  @AfterTest
  public void closeBrowser() {
	  driver.close();
	  driver = null;
  }
  
  //data driven
  @DataProvider
  public Object[][] getData() {
	  
	  Object[][] data = new Object[2][3];
	  
	  data[0][0] = "testOne@test.com";
	  data[0][1] = "testPasswordOne";
	  data[0][2] = "Test User One";
	  
	  data[1][0] = "testTwo@test.com";
	  data[1][1] = "testPasswordTwo";
	  data[1][2] = "Test User Two";
	  
	  return data;
  }
}