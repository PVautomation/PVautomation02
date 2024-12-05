/*
package JavaMavenTestNG.JavaMavenTestNG;

import JavaMavenTestNG.JavaMavenTestNG.Test1;
import JavaMavenTestNG.JavaMavenTestNG.ScreenshotUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



import java.io.IOException;

public class ScreenshotListener extends Test1 implements ITestListener {

     //WebDriver driver;

    
    @Override
    public void onTestFailure(ITestResult result) {
         driver = (WebDriver) result.getTestContext().getAttribute("driver");

        try {
            String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName());
            		//captureScreenshot(driver, result.getName());
            Reporter.log("<a href='" + screenshotPath + "' target='_blank'>Screenshot</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public void onTestSuccess(ITestResult result) {
             driver = (WebDriver) result.getTestContext().getAttribute("driver");

        try {
            String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName());
            Reporter.log("<a href='" + screenshotPath + "' target='_blank'>Screenshot</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
*/