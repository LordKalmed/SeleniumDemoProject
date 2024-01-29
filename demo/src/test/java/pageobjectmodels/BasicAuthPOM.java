package pageobjectmodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuthPOM extends basicPOMtemplate{

    WebDriver driver;

    public BasicAuthPOM(WebDriver driver){
        super(driver);
    }


    public By titleText = By.xpath("/html/body/div[2]/div/div/h3");
    public By messageText = By.xpath("/html/body/div[2]/div/div/p");

}
