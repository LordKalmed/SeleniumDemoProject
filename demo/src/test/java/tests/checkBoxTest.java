package tests;

import org.apache.logging.log4j.LogManager;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjectmodels.addremovePOM;
import pageobjectmodels.homePagePOM;
import runners.factoryRunner;
import utility.ScreenShot;

public class checkBoxTest extends TestTemplate{

    @Test
    public void CheckBoxesURLTest(){

    }

    @Test
    public void CheckBox1Test(){

    }

    @Test
    public void CheckboxRandomTest(){
        
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
    
}
