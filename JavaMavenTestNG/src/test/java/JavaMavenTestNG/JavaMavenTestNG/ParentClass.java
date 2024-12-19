package JavaMavenTestNG.JavaMavenTestNG;

//import com.pv.project1.PageObjectModelClass;

//import com.pv.project1.PageObjectModelClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.sql.Time;
import java.time.Duration;
import org.apache.commons.io.FileUtils;


//@TestOwner("pvenkatarajan@republicfinance.com")

public class ParentClass {
	public WebDriver driver;
	public String baseUrl;
	// private boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	public JavascriptExecutor js;
	Actions a1;

	@BeforeClass(alwaysRun = true)
	public void setUp(ITestContext context) throws Exception {

		//WebDriverManager.chromedriver().driverVersion("131.0.6778.85").setup();
		//WebDriverManager.chromedriver().clearResolutionCache().setup();
		//WebDriverManager.chromedriver().setup();
		// ChromeOptions option = new ChromeOptions();
		// option.addArguments("--headless");

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		/*
		ops.addArguments("--headless"); // headless mode
		ops.addArguments("--disable-gpu"); // Disable GPU acceleration for headless mode
		ops.addArguments("--no-sandbox"); // for headless mode in CI/CD environments
		ops.addArguments("--window-size=1920x1080");
		ops.addArguments("--disable-dev-shm-usage");
		// System.setProperty("webdriver.chrome.driver", "./lib/chromedriver");
		*/
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\pvenkatarajan\\Downloads\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		
		driver = new ChromeDriver(ops);
		context.setAttribute("driver", driver);

		// System.setProperty("webdriver.chrome.driver", "");
		// driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		js = (JavascriptExecutor) driver;
		a1 = new Actions(driver);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	}



	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}


	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
    public void verifyTextNotPresent(String s) {
  
        // Text to verify
        String expectedText = s; 

        // Use WebDriverWait to ensure the page is fully loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement bodyElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Verify if the text is present in the body element
        boolean isTextPresent = bodyElement.getText().contains(expectedText);

        // Log result
        if (isTextPresent) {
            System.out.println("if - ASSERT FALSE CHECK" + "--> "  +isTextPresent );
            Reporter.log("if - REPORTER - ASSERT FALSE CHECK" + "-->\t"  +isTextPresent  + "<br>");
        }
        else
        {System.out.println("else - ASSERT FALSE CHECK" + "--> " +isTextPresent);
        Reporter.log("else - REPORTER - ASSERT FALSE CHECK"  + "-->\t"  +isTextPresent  + "<br>");}
        
        // Assert that the text is found
       // Assert.assertTrue(isTextPresent, "ASSERT SAYS - TEXT PRESENT1" +expectedText);
        Assert.assertFalse(isTextPresent, "assert - ASSERT FALSE CHECK" + "--> " +isTextPresent  + "<br>");
        //Assert.assertEquals(isTextPresent, isTextPresent, expectedText);

    }
    
    
    
    public void verifyTextPresent(String s) {
    	  
    	  
        // Text to verify
        String expectedText = s; 

        // Use WebDriverWait to ensure the page is fully loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement bodyElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Verify if the text is present in the body element
        boolean isTextPresent = bodyElement.getText().contains(expectedText);
        
        if (isTextPresent) {
            System.out.println("if - ASSERT TRUE CHECK" + "--> "  +isTextPresent );
            Reporter.log("if - REPORTER - ASSERT TRUE CHECK" + "-->\t"  +isTextPresent + "<br>");
        }
        else
        {System.out.println("else - ASSERT TRUE CHECK" + "--> " +isTextPresent);
        Reporter.log("else - REPORTER - ASSERT TRUE CHECK"  + "-->\t"  +isTextPresent + "<br>");}
        
        // Assert that the text is found
       // Assert.assertTrue(isTextPresent, "ASSERT SAYS - TEXT PRESENT1" +expectedText);
         Assert.assertTrue(isTextPresent, "assert - ASSERT TRUE CHECK" + "--> " +isTextPresent + "<br>");
        //Assert.assertEquals(isTextPresent, isTextPresent, expectedText);
        // Log result
        }
    
    
    
	
	public static void waitForPageToLoad(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver,
				Duration.ofSeconds(120));
		wait.until(driver1 -> js.executeScript("return document.readyState").equals("complete"));
	}
	


}
