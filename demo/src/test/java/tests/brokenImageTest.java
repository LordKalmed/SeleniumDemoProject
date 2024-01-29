package tests;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjectmodels.brokenImagePOM;
import pageobjectmodels.homePagePOM;
import runners.factoryRunner;
import utility.Retry;
import utility.ScreenShot;

public class brokenImageTest extends TestTemplate{

    @Test (priority = 1, enabled = true,  retryAnalyzer = Retry.class)
    public void BrokenImageURLTest(){
        try{
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            String expectedURL = "https://the-internet.herokuapp.com/broken_images";
            driver.findElement(homepom.brokenImageLink).click();
            boolean pass = driver.getCurrentUrl().equalsIgnoreCase(expectedURL) ? true: false;
            if (pass) {
                scrn.screenShot(methodName, pass, "Test description");
                log.info("Expected URL is present");
                Reporter.log("Expected URL is present");
            }
            else {
                scrn.screenShot(methodName, pass, "Failed test  ");
                Reporter.log("Expected URL is wrong");
            }
            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        }
        catch(Exception e){
            log.error(e);
        }
    }

    @Test(priority = 2, enabled = true, retryAnalyzer = Retry.class)
    public void FirstImageTest(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            driver.findElement(brokenImagePOM.image1);
            boolean pass = brokenImage(driver.findElement(brokenImagePOM.image1)) ? true : false;            if(pass){
                scrn.screenShot(methodName, pass, "test results");
            }
            else {
                scrn.screenShot(methodName, pass, "test results");
            }
            Assert.assertTrue(pass);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test(priority = 4, enabled = false, dependsOnMethods = {"BrokenImageURLTest"}, retryAnalyzer = Retry.class)
    public void allImageTest(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            List<WebElement> images = driver.findElements(By.cssSelector("image"));
            for (WebElement img : images){
                boolean innerPass = brokenImage(img) ? true : false;
                    String msg = innerPass ? "Pass was a success" : "Pass was a fail";
                if (innerPass){
                    scrn.screenShot(methodName, innerPass, msg);
                    Reporter.log(msg);
                    softAssert.assertEquals(innerPass, true);
                }
                else if (!innerPass && img.getText().equalsIgnoreCase("brokenimage")){
                    // for if image is intentionally broken
                }
                else {
                    scrn.screenShot(methodName, innerPass, msg);
                    Reporter.log(msg);
                }
            }
            softAssert.assertAll();
        }
        catch (Exception e) {
            log.error(e);
        }
    }


    @BeforeClass
    public void beforeClass() {
        factoryRunner runner = new factoryRunner();
        setDriver(runner.createDriver());
        homepom = new homePagePOM(getDriver());
        brokenImagePOM = new brokenImagePOM(driver);
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
        runner.destroyDriver(driver);
    }


    public boolean brokenImage(WebElement img){
        boolean pass = false;
        if (img.getAttribute("naturalWiddth").equalsIgnoreCase("0")){
            return pass = true;
        }
        return pass;
    }
    
}
