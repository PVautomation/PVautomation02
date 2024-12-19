package JavaMavenTestNG.JavaMavenTestNG;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {

    /**
     * Captures a screenshot and saves it to a specified directory. Handles both local and CI/CD environments.
     * 
     * @param driver   The WebDriver instance used for taking the screenshot.
     * @param identifier A unique identifier for the screenshot, typically the test name.
     * @return The absolute path of the saved screenshot, or null if an error occurred.
     */
    public static String captureScreenshot(WebDriver driver, String identifier) throws IOException {
        try {
            // Take a screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Determine the artifact directory (CI/CD or local)
            String artifactDir = System.getenv("Build.ArtifactStagingDirectory");
            if (artifactDir == null || artifactDir.isEmpty()) {
                artifactDir = System.getProperty("user.dir") + "/screenshots"; // Local fallback directory
            }

            // Ensure the directory exists
            File directory = new File(artifactDir);
            if (!directory.exists()) {
                directory.mkdirs(); // Create the directory if it doesn't exist
            }

            // Define the destination file
            String destPath = artifactDir + "/screenshot_" + identifier + ".png";
            File destination = new File(destPath);

            // Copy the screenshot to the destination
            FileUtils.copyFile(screenshot, destination);

            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());

            // Return the destination path
            return destPath;
        } catch (IOException e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
            return null; // Return null if there was an error
        }
    }
}
