package pageobjectmodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkBoxes extends basicPOMtemplate{

    public checkBoxes(WebDriver driver) {
        super(driver);
    }
    
    public By checkbox1 = By.xpath("/html/body/div[2]/div/div/form/input[1]");
    public By checkbox2 = By.xpath("/html/body/div[2]/div/div/form/input[2]");

}
