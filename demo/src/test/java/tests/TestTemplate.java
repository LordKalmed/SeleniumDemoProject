package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageobjectmodels.BasicAuthPOM;
import pageobjectmodels.addremovePOM;
import pageobjectmodels.brokenImagePOM;
import pageobjectmodels.checkBoxesPOM;
import pageobjectmodels.contextMenuPOM;
import pageobjectmodels.digestAuthPOM;
import pageobjectmodels.homePagePOM;
import runners.factoryRunner;
import utility.ScreenShot;

public class TestTemplate {
	
    // Setup of all class variables below
    WebDriver driver;
    factoryRunner runner;
    ScreenShot scrn;
    SoftAssert softAssert;
    Logger log;
    Reporter report;
    Actions act;

    //Page Object models setup here. Require driver sent to constructor.
    homePagePOM homepom;
    addremovePOM addpom;
    BasicAuthPOM basicAuthpom;
    brokenImagePOM brokenImagePOM;
    checkBoxesPOM checkbox;
    contextMenuPOM contextPOM;
    digestAuthPOM digestPOM;




    // Useful functions for tests here
    public void setDriver(WebDriver newDriver){
        this.driver = newDriver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }


        //cheching whether the before classes can run from test template
    @BeforeClass
    public void beforeClass() {
        factoryRunner runner = new factoryRunner();
        setDriver(runner.createDriver());
        homepom = new homePagePOM(driver);
        brokenImagePOM = new brokenImagePOM(driver);
        contextPOM = new contextMenuPOM(driver);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        // Setup folder for screenshot below
        scrn = new ScreenShot("brokenImageTest", driver);
        softAssert = new SoftAssert();
        log = LogManager.getLogger();
        report = new Reporter();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        //runner.destroyDriver(driver);
    }

    public void SetupTestEnviroment(){

    }

    @Test
    public void blankTest(){
        
    }


}
