package tests;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjectmodels.contextMenuPOM;
import pageobjectmodels.digestAuthPOM;
import pageobjectmodels.homePagePOM;
import runners.factoryRunner;
import utility.Retry;
import utility.ScreenShot;

public class digestAuthTest extends TestTemplate{

    @Test (enabled = false, retryAnalyzer = Retry.class)
    public void digestAuthURLTest(){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            driver.findElement(homepom.digestAuthenticationLink).click();
            String expectedURL = "";
            boolean pass = driver.getCurrentUrl().equalsIgnoreCase(expectedURL) ? true : false;
            scrn.screenShot(methodName, pass, "To be fixed");
            Assert.assertEquals(pass, true);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test(enabled = true, retryAnalyzer = Retry.class, dataProvider = "getLoginData")
    public void digestAuthLoginTest(String user, String passwd, boolean auth){
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
                // using inbedded code for authentication below
                String authURL = "https://the-internet.herokuapp.com/digest_auth";
                driver.get("https://"+user+":"+passwd+"@"+authURL);
                boolean pass = false;
            if (auth){
                pass = driver.findElement(digestPOM.title).getText().equals("Digest Auth");
                scrn.screenShot(methodName, pass, "Auth");
                softAssert.assertEquals(pass, true);
              }
              else if (!auth){
                pass = !driver.findElement(digestPOM.title).getText().equals("Digest Auth");
                scrn.screenShot(methodName, pass, "NotAuth");
                softAssert.assertEquals(pass, false);
              }
              else {
                pass = false;
                scrn.screenShot(methodName, pass, "Not expected");
              }
                //below 
                // This "HasAuthentication" interface is the key!
                //HasAuthentication authentication (HasAuthentication) driver;
                // You can either register something for all sites
                //authentication.register(() -> new UsernameAndPassword("admin", "admin"));
                Assert.assertTrue(pass);
        } catch (Exception e) {
            log.error(e);    
        }
    }

    @BeforeClass
    public void setup(){
        runner = new factoryRunner();
        setDriver(runner.createDriver());
        homepom = new homePagePOM(driver);
        // replace with page POM
        contextPOM = new contextMenuPOM(driver);
        digestPOM = new digestAuthPOM(driver);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        // Setup folder for screenshot below
        scrn = new ScreenShot("contextMenuTest", driver);
        softAssert = new SoftAssert();
        log = LogManager.getLogger();
        report = new Reporter();
        act = new Actions(driver);
    }

    @AfterClass
    public void teardown(){
        
    }

    @DataProvider
    public Object[][] getLoginData(){
        return new Object[][]{
            new Object[] { "admin", "admin" , true },
            new Object[] { "user", "userPass" , false},
            //new Object[] {"usernames here", "password here" , "authenticated here"}
        };
    }
    
}
