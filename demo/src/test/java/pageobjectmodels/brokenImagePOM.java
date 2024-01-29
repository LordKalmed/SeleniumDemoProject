package pageobjectmodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class brokenImagePOM extends basicPOMtemplate{

    
    public brokenImagePOM(WebDriver driver){
        super(driver);
    }


    public By titleText = By.xpath("/html/body/div[2]/div/div/h3");
    public By image1 = By.xpath("/html/body/div[2]/div/div/img[1]");
    public By image2 = By.xpath("/html/body/div[2]/div/div/img[2]");
    public By image3 = By.xpath("/html/body/div[2]/div/div/img[3]");

    public By images = By.xpath("/html/body/div[2]/div/div/img[*]");
    
}
