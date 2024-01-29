package runners;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class tester {

    
    public static void main(String[] args) throws IOException, InterruptedException{
        factoryRunner runner = new factoryRunner();
        WebDriver driver = runner.createDriver();
        //testing selenium below
        String authURL = "the-internet.herokuapp.com/basic_auth";
        driver.get("https://"+"admin"+":"+"none"+"@"+authURL);
        runner.destroyDriver(driver);
    }

    @Test (dataProvider =  "dp")
    public void testDP(String msg1, int number, String msg2){
        System.out.println("Test "+number);
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println("end of Test____________");

    }

    @DataProvider
    public Object[][] dp(){
        return new Object[][]{
            new Object[] {"first object", 1 , "end first object"},
            new Object[] {"second object", 2 , "end second object"},
            new Object[] {"third object", 3 , "end third object"},
            new Object[] {"last object", 4, "True ENd"}
        };
    }
}
