package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageobjectmodels.addremovePOM;
import pageobjectmodels.homePagePOM;
import runners.factoryRunner;
import utility.Retry;
import utility.ScreenShot;

public class testAddRemoveElement {

    // Setup of all class variables below
    WebDriver driver;
    factoryRunner runner;
    ScreenShot scrn;
    SoftAssert softAssert;
    Logger log;
    Reporter report;

    //Page Object models setup here. Require driver sent to constructor.
    homePagePOM homepom;
    addremovePOM addpom;


    //allows the use of parameters in xml file
    @Test(enabled = true, retryAnalyzer = Retry.class)
    public void testAddRemoveURL(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
                //Replace with parameters, hardcode url is not advised
                String urlString = "https://the-internet.herokuapp.com/add_remove_elements/";
            driver.findElement(homepom.addRemoveLink).click();
            boolean pass = driver.getCurrentUrl().equalsIgnoreCase(urlString) ? true: false;
                //Add msg String for failure and pass 
            scrn.screenShot(methodName, pass, "test name here");
            Assert.assertEquals(pass, true);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test(enabled = true, dependsOnMethods = {"testAddRemoveURL"}, retryAnalyzer = Retry.class)
    public void testAddElementBtn(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            boolean pass = driver.findElement(addpom.addBtn).isDisplayed() && driver.findElement(addpom.addBtn).isEnabled() ? true: false;
            scrn.screenShot(methodName,pass, "Button is present");
            softAssert.assertEquals(pass, true);
            driver.findElement(addpom.addBtn).click();
            boolean secondPass = driver.findElement(addpom.removeBtn).isDisplayed() && driver.findElement(addpom.removeBtn).isEnabled() ? true: false;
            String msg = secondPass ? "Remove button is added" : "Remove button not added";
            scrn.screenShot(methodName,secondPass, msg);
            softAssert.assertEquals(secondPass, true);
            softAssert.assertAll();
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test(enabled = true, dependsOnMethods = {"testAddElementBtn"}, retryAnalyzer = Retry.class)
    public void testRemoveElementBtn(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            boolean firstPass = driver.findElement(addpom.removeBtn).isDisplayed() && driver.findElement(addpom.removeBtn).isEnabled() ? true: false;
            String msg1 = firstPass ? "Remove Button is displayed and enabled" : "Remove button is not displayed or enabled";
            scrn.screenShot(methodName,firstPass, msg1);
            driver.findElement(addpom.removeBtn).click();
            boolean secondPass = !driver.findElement(addpom.removeBtn).isEnabled() && !driver.findElement(addpom.removeBtn).isDisplayed() ? true : false;
            String msg2 = secondPass ? "" : "";
            scrn.screenShot(methodName,secondPass, msg2);
            softAssert.assertEquals(secondPass, true);
            softAssert.assertAll();            
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test(enabled = false)
    public void testAddElementBtnMulti(){

    }

    @Test(enabled = false)
    public void testRemoveElementBtnMulti(){

    }



    @BeforeClass
    public void setup(){
        factoryRunner runner = new factoryRunner();
        driver = runner.createDriver();
        homepom = new homePagePOM(driver);
        addpom = new addremovePOM(driver);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        scrn = new ScreenShot("testAddRemoveElement", driver);
        softAssert = new SoftAssert();
        log = LogManager.getLogger();
        report = new Reporter();
    }

    @AfterClass
    public void teardown(){
        runner.destroyDriver(driver);
    }

    @DataProvider
    public Object[] dp(){
        return new Object[] {"https://the-internet.herokuapp.com/"};
    }
    
}
