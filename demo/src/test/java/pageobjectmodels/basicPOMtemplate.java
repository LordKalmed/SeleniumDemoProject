package pageobjectmodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class basicPOMtemplate {

        WebDriver driver;

    public basicPOMtemplate(WebDriver driver){
        this.driver = driver;
    }

    By setup;
    
}
