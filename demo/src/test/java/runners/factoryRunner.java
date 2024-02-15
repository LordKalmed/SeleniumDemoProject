package runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class factoryRunner {

    public WebDriver driver;



    public WebDriver createDriver(){
        this.driver = new FirefoxDriver();
        return this.driver;
    }

    public void destroyDriver(WebDriver sentDriver){
        sentDriver.quit();
    }
    
}
