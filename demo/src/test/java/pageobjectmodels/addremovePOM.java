package pageobjectmodels;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addremovePOM {
    


    WebDriver driver;

    public addremovePOM(WebDriver newDriver){
        this.driver=newDriver;
    }

    public By addBtn = By.xpath("/html/body/div[2]/div/div/button");
    public By removeBtn = By.xpath("/html/body/div[2]/div/div/div/button");
}
