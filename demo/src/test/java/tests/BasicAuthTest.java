package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjectmodels.BasicAuthPOM;
import pageobjectmodels.homePagePOM;
import runners.factoryRunner;
import utility.ScreenShot;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class BasicAuthTest extends TestTemplate{
	
	@Test(enabled = false)
	public void BasicAuthURLTest() {
		log.info("In URL Test basic Authentication");
    String expectedURL = "https://the-internet.herokuapp.com/basic_auth";
    Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
	}
	
  @Test(enabled = true,dataProvider = "dp")
  public void signInTest(String username, String password, boolean accepted) {
    try {
          //Below is used to get method name for screenshots
      String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
          // using inbedded code for authentication below
      String authURL = "the-internet.herokuapp.com/basic_auth";
      driver.get("https://"+username+":"+password+"@"+authURL);
      boolean pass = false;
      if (accepted){
        pass = driver.findElement(basicAuthpom.messageText).isDisplayed();
        scrn.screenShot(methodName, pass, "Login-"+accepted);
        softAssert.assertEquals(pass, true);
      }
      else if (!accepted){
        pass = !driver.findElement(basicAuthpom.messageText).isDisplayed();
        scrn.screenShot(methodName, pass, "Login-"+accepted);
        softAssert.assertEquals(pass, false);
      }
      else {
        pass = false;
        scrn.screenShot(methodName, pass, "Not expected");
      }
      softAssert.assertAll();
    } catch (Exception e) {
      log.error(e);
    }

  }
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp(){
    return new Object[][]{
      new Object[] { "admin", "admin" , true },
      new Object[] { "user", "userPass" , false},
      //new Object[] {"usernames here", "password here" , "authenticated here"}
  };
  }
  
  @BeforeClass
  public void beforeClass() {
        factoryRunner runner = new factoryRunner();
        setDriver(runner.createDriver());
        homepom = new homePagePOM(getDriver());
        basicAuthpom = new BasicAuthPOM(driver);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        scrn = new ScreenShot("basicAuthTests", driver);
        softAssert = new SoftAssert();
        log = LogManager.getLogger();
        report = new Reporter();
  }

  @AfterClass
  public void afterClass() {
    driver.quit();
    //runner.destroyDriver(driver);
  }

}
