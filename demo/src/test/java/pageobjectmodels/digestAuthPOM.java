package pageobjectmodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class digestAuthPOM extends basicPOMtemplate {

    public digestAuthPOM(WebDriver driver) {
        super(driver);
    }

    public By title = By.xpath("/html/body/div[2]/div/div/h3");
    
    
}
