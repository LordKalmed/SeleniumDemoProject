package tests;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjectmodels.brokenImagePOM;
import pageobjectmodels.contextMenuPOM;
import pageobjectmodels.homePagePOM;
import runners.factoryRunner;
import utility.Retry;
import utility.ScreenShot;

public class contestMenuTest extends TestTemplate{


    @Test(enabled = true, retryAnalyzer = Retry.class)
    public void contextMenuTestURL(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            driver.findElement(homepom.contextMenuLink).click();
            String expectedURL = "https://the-internet.herokuapp.com/context_menu";
            boolean pass = driver.getCurrentUrl().equalsIgnoreCase(expectedURL) ? true : false;
            if (pass){
                scrn.screenShot(methodName, pass, expectedURL);
            }
            else scrn.screenShot(methodName, pass, "failed");
            Assert.assertEquals(pass, true);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test(enabled = true, dependsOnMethods = {"contextMenuTestURL"}, retryAnalyzer = Retry.class)
    public void contextMenuContextBbuttonTest(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            boolean pass = false;
            if (driver.findElement(contextPOM.contextMenu).isEnabled()){
                // Assert here
                act.contextClick(driver.findElement(contextPOM.contextMenu)).perform();
                try {
                    driver.switchTo().alert();
                    pass = true;
                    scrn.screenShot(methodName, pass, methodName);
                } catch (NoAlertPresentException e) {
                    scrn.screenShot(methodName, false, methodName);
                    log.error(e);
                }
            }
            Assert.assertTrue(pass);
            //final assert here
        } catch (Exception e) {
            log.error(e);
            
        }
    }

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
        scrn = new ScreenShot("contextMenuTest", driver);
        softAssert = new SoftAssert();
        log = LogManager.getLogger();
        report = new Reporter();

        //unique for actions below
        act = new Actions(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        //runner.destroyDriver(driver);
    }
    
}
