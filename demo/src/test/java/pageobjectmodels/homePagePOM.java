package pageobjectmodels;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePagePOM {

    WebDriver driver;

    public homePagePOM(WebDriver driver){
        this.driver=driver;
    }
    
    public By addRemoveLink = By.xpath("/html/body/div[2]/div/ul/li[2]/a");
    public By basicAuthLink = By.xpath("/html/body/div[2]/div/ul/li[3]/a");
    public By brokenImageLink = By.xpath("/html/body/div[2]/div/ul/li[4]/a");
    public By challengingDOM = By.xpath("null");
    public By checkBoxesLink = By.xpath("/html/body/div[2]/div/ul/li[6]/a");
    public By contextMenuLink = By.xpath("/html/body/div[2]/div/ul/li[7]/a");
    public By digestAuthenticationLink = By.xpath("null");
    public By disappearingElementsLink = By.xpath("null");

    //WebElement removeBtn1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button"));

    //List<WebElement> removeBtns = driver.findElements(By.xpath("/html/body/div[2]/div/div/div/button"));

    
}
