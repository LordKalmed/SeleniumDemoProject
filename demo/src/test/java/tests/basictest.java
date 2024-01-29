package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class basictest {

    WebDriver driver;


    @Test (retryAnalyzer = utility.Retry.class)
    public void test1_OpenBrowser(){
        driver.get("https://the-internet.herokuapp.com/");
    }


    @Test(dependsOnMethods = "test1_OpenBrowser" )
    public void test2_TestingPOM(){
        WebElement addRemoveBtn = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[2]/a"));
        addRemoveBtn.click();
        String expecteURL = "https://the-internet.herokuapp.com/add_remove_elements/";
        Assert.assertEquals(driver.getCurrentUrl(), expecteURL);
    }


    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

    
}
