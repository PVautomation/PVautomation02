package JavaMavenTestNG.JavaMavenTestNG;

import JavaMavenTestNG.JavaMavenTestNG.ScreenshotUtility;
import JavaMavenTestNG.JavaMavenTestNG.ParentClass;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class ScreenshotListener implements ITestListener {

    private WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        driver = (WebDriver) result.getTestContext().getAttribute("driver");

        try {
            // Update test name dynamically with identifier
            Object[] parameters = result.getParameters();
            String identifier = parameters.length > 0 ? parameters[0].toString() : "test-fail";
            String newTestName = result.getMethod().getMethodName() + " [" + identifier + "]";
            result.getTestContext().getCurrentXmlTest().setName(newTestName);
            System.out.println("Updated test name: " + newTestName);

            // Capture and log screenshot
            String screenshotPath = ScreenshotUtility.captureScreenshot(driver, newTestName + "_FAILURE");
            Reporter.log("<a href='" + screenshotPath + "' target='_blank'>Screenshot</a>");
            Reporter.log("Screenshot saved for failed test: " + newTestName + " -> " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        driver = (WebDriver) result.getTestContext().getAttribute("driver");

        try {
            // Update test name dynamically with identifier
            Object[] parameters = result.getParameters();
            String identifier = parameters.length > 0 ? parameters[0].toString() : "test-pass";
            String newTestName = result.getMethod().getMethodName() + " [" + identifier + "]";
            result.getTestContext().getCurrentXmlTest().setName(newTestName);
            System.out.println("Updated test name: " + newTestName);

            // Capture and log screenshot
            String screenshotPath = ScreenshotUtility.captureScreenshot(driver, newTestName + "_SUCCESS");
            Reporter.log("<a href='" + screenshotPath + "' target='_blank'>Screenshot</a>");
            Reporter.log("Screenshot saved for successful test: " + newTestName + " -> " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Optionally handle skipped tests if needed
    }

    @Override
    public void onStart(ITestContext context) {
        // Optionally handle test start if needed
    }

    @Override
    public void onFinish(ITestContext context) {
        // Optionally handle test finish if needed
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Optionally handle test start if needed
    }
}
