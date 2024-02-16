package tests;

import org.apache.logging.log4j.LogManager;
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
import utility.ScreenShot;

public class contestMenuTest extends TestTemplate{


    @Test
    public void contextMenuTestURL(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            driver.findElement(homepom.contextMenuLink).click();
            String expectedURL = "https://the-internet.herokuapp.com/context_menu";
            boolean pass = driver.getCurrentUrl().equalsIgnoreCase(expectedURL) ? true : false;
            if (pass){
                scrn.screenShot(methodName, pass, expectedURL);
            }
            Assert.assertEquals(pass, true);
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
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        //runner.destroyDriver(driver);
    }
    
}
