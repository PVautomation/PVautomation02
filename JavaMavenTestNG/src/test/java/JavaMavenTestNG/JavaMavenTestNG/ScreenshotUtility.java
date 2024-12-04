package JavaMavenTestNG.JavaMavenTestNG;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {
    public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
    
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        String dest = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        
       File destination = new File(dest);
        FileHandler.copy(source, destination);
        
        return dest; 
    }
}
