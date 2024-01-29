package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import org.apache.logging.log4j.Logger;

import pageobjectmodels.BasicAuthPOM;
import pageobjectmodels.addremovePOM;
import pageobjectmodels.brokenImagePOM;
import pageobjectmodels.checkBoxes;
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

    //Page Object models setup here. Require driver sent to constructor.
    homePagePOM homepom;
    addremovePOM addpom;
    BasicAuthPOM basicAuthpom;
    brokenImagePOM brokenImagePOM;
    checkBoxes checkbox;


    // Useful functions for tests here
    public void setDriver(WebDriver newDriver){
        this.driver = newDriver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}
