package JavaMavenTestNG.JavaMavenTestNG;

//import JavaMavenTestNG.JavaMavenTestNG.Test1;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtility extends ParentClass  {
	
	/*
    public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
    
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        String dest = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        
       File destination = new File(dest);
        FileHandler.copy(source, destination);
        
        return dest; 
    } */
	
	public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
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
            String destPath = artifactDir + "/" + testName + ".png";
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
