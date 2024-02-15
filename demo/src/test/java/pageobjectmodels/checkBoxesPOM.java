package pageobjectmodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkBoxesPOM extends basicPOMtemplate{

    public checkBoxesPOM(WebDriver driver) {
        super(driver);
    }
    
    public By checkbox1 = By.xpath("/html/body/div[2]/div/div/form/input[1]");
    public By checkbox2 = By.xpath("/html/body/div[2]/div/div/form/input[2]");

}
