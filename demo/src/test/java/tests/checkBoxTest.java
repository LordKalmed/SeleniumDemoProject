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

import pageobjectmodels.checkBoxesPOM;
import pageobjectmodels.homePagePOM;
import runners.factoryRunner;
import utility.Retry;
import utility.ScreenShot;

public class checkBoxTest extends TestTemplate{

    @Test (enabled = true, retryAnalyzer = Retry.class)
    public void CheckBoxesURLTest(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            driver.findElement(homepom.checkBoxesLink).click();
            String expectedURL = "https://the-internet.herokuapp.com/checkboxes";
            boolean pass = driver.getCurrentUrl().equalsIgnoreCase(expectedURL) ? true: false;
            if (pass){
                scrn.screenShot(methodName, pass, "Test Passed");
            }
            else {
                scrn.screenShot(methodName, pass, "Test Failed");
            }
            Assert.assertEquals(pass, true);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test (enabled = false, dependsOnMethods = {"CheckBoxesURLTest"}, retryAnalyzer = Retry.class)
    public void CheckBox1Test(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            boolean pass = false;
            if (driver.findElement(checkbox.checkbox1).isEnabled() && driver.findElement(checkbox.checkbox1).isDisplayed()){
                driver.findElement(checkbox.checkbox1).click();
                pass = driver.findElement(checkbox.checkbox1).isSelected() ? true : false;
            }
            scrn.screenShot(methodName, pass, "Test results");
            Assert.assertTrue(pass);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test (enabled = true, dependsOnMethods = {"CheckBoxesURLTest"}, retryAnalyzer = Retry.class)
    public void CheckboxRandomTest(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            List<WebElement> boxes = driver.findElements(By.tagName("checkbox"));
            for (WebElement box : boxes){
                boolean pass = box.isDisplayed() && box.isEnabled() ? true : false;
                if (pass){
                    if (box.isSelected()){
                        box.click();
                        softAssert.assertEquals(box.isSelected(), false);
                    }
                    else if (!box.isSelected()){
                        box.click();
                        softAssert.assertEquals(box.isSelected(), true);
                    }
                    else log.debug("Box is not selected");
                }
                scrn.screenShot(methodName, pass, "Checkbox");
            }
        } catch (Exception e) {
            log.error(e);
        }
        
    }

    @BeforeClass
    public void setup(){
        factoryRunner runner = new factoryRunner();
        driver = runner.createDriver();
        homepom = new homePagePOM(driver);
        checkbox = new checkBoxesPOM(driver);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        scrn = new ScreenShot("checkBoxTest", driver);
        softAssert = new SoftAssert();
        log = LogManager.getLogger();
        report = new Reporter();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
        //runner.destroyDriver(driver);
    }
    
}
