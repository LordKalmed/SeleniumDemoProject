package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

    WebDriver driver;
    String file;
    String filepath = "C:\\Users\\Angus\\Documents\\SeleniumDemoProject\\demo\\reports\\testReports\\";

    public ScreenShot(String file, WebDriver driver){
        this.file=file;
        this.driver=driver;
        Path path = Paths.get(filepath+file);
        if (Files.notExists(path)){
            new File(filepath+file).mkdirs();
        }
    }

    public void screenShot(String methodName, boolean result, String testName) throws IOException{

        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (result){
            FileHandler.copy(screenShotFile, new File(filepath+file+"\\"+methodName+"-"+testName+"-Pass"+".png"));
        }
        else {
             FileHandler.copy(screenShotFile, new File(filepath+file+"\\"+methodName+"-"+testName+"-Fail"+".png"));
        }
    }
    
}

