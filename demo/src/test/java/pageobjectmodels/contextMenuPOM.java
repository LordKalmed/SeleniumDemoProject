package pageobjectmodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class contextMenuPOM extends basicPOMtemplate{

    public contextMenuPOM(WebDriver driver) {
        super(driver);
    }

    public By heading = By.xpath("/html/body/div[2]/div/div/h3");
    public By contentText1 = By.xpath("/html/body/div[2]/div/div/p[1]");
    public By contentText2 = By.xpath("/html/body/div[2]/div/div/p[2]");
    public By contextMenu = By.xpath("/html/body/div[2]/div/div/div");
    
}
