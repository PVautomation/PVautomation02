///*
package JavaMavenTestNG.JavaMavenTestNG;

import JavaMavenTestNG.JavaMavenTestNG.CRMtestClass;
import JavaMavenTestNG.JavaMavenTestNG.ScreenshotUtility;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



import java.io.IOException;

public class ScreenshotListener extends CRMtestClass implements ITestListener {

     //WebDriver driver;

    
    @Override
    public void onTestFailure(ITestResult result) {
         driver = (WebDriver) result.getTestContext().getAttribute("driver");

        try {
            String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName());
            		//captureScreenshot(driver, result.getName());
            Reporter.log("<a href='" + screenshotPath + "' target='_blank'>Screenshot</a>\n");
            Reporter.log("REPORTER for fail in listner1\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public void onTestSuccess(ITestResult result) {
             driver = (WebDriver) result.getTestContext().getAttribute("driver");

        try {
            String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getName());
            Reporter.log("\n");
            Reporter.log("<a href='" + screenshotPath + "' target='_blank'>Screenshot</a>\n");
            Reporter.log("\n");
            Reporter.log("REPORTER for pass in listner1\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
//*/