package JavaMavenTestNG.JavaMavenTestNG;

import org.testng.annotations.Test;

//import com.pv.project1.PageObjectModelClass;

//import com.pv.project1.PageObjectModelClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestContext;
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

public class Test1 {
	public WebDriver driver;
	private String baseUrl;
	// private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;
	Actions a1;

	@BeforeClass(alwaysRun = true)
	public void setUp(ITestContext context) throws Exception {

		//WebDriverManager.chromedriver().driverVersion("131.0.6778.87").setup();
		WebDriverManager.chromedriver().clearResolutionCache().setup();
		//WebDriverManager.chromedriver().setup();
		// ChromeOptions option = new ChromeOptions();
		// option.addArguments("--headless");

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		
		ops.addArguments("--headless"); // headless mode
		ops.addArguments("--disable-gpu"); // Disable GPU acceleration for headless mode
		ops.addArguments("--no-sandbox"); // for headless mode in CI/CD environments
		ops.addArguments("--window-size=1920x1080");
		ops.addArguments("--disable-dev-shm-usage");
		// System.setProperty("webdriver.chrome.driver", "./lib/chromedriver");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\pvenkatarajan\\Downloads\\chromedriver-win64\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		
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

	@Test
	public void crmTest1() throws Exception {

		try {
		// through direct crm site
		driver.get("https://republicfinance--qa.sandbox.my.salesforce.com/");
		Thread.sleep(5000);
		System.out.println("svc acct getURL done");
		// ERROR: Caught exception [ERROR: Unsupported command [windowMaximize | | ]]
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("svcQSETA@republicfinance.com.qa");
		Thread.sleep(2000);
		System.out.println("svc acct uid done");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("-tEp66BWR#F#P*");
		Thread.sleep(10000);
		System.out.println("svc acct pwd done");
		WebElement login = driver.findElement(By.id("Login"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(login));
		JavascriptExecutor js0 = (JavascriptExecutor) driver;
		js0.executeScript("arguments[0].focus();", login);
		js0.executeScript("arguments[0].click();", login);
		System.out.println("svc acct login click done");
		Thread.sleep(5000);
		
		//-----
		  Thread.sleep(3000);
		  System.out.println("before screeshot2");
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String path = System.getProperty("user.dir") + "/screenshot.png"; // Save relative to the project root
		String path = System.getenv("Build.ArtifactStagingDirectory") + "/screenshot2.png";
		FileUtils.copyFile(screenshot, new File(path));
		Thread.sleep(3000);
		  System.out.println("after screenshot2");
		//-----
		
		} catch (Exception e) {
			System.out.println("CRM-TEST1 LOGIN DID NOT HAPPEN");
			//-----
			  Thread.sleep(3000);
			  System.out.println("before screenshot3");
			  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//String path = System.getProperty("user.dir") + "/screenshot.png"; // Save relative to the project root
			String path = System.getenv("Build.ArtifactStagingDirectory") + "/screenshot3.png";
			FileUtils.copyFile(screenshot, new File(path));
			Thread.sleep(3000);
			  System.out.println(" after screenshot3");
			//-----
		}

		
		/*
		 * // THROUGN OKTA START
		 * driver.get("https://republic.okta.com/login/login.htm");
		 * driver.findElement(By.xpath("//*[@id='okta-signin-username']")).click();
		 * driver.findElement(By.xpath("//*[@id='okta-signin-username']")).clear();
		 * driver.findElement(By.xpath("//*[@id='okta-signin-username']")).sendKeys(
		 * "pvenkatarajan@republicfinance.com");
		 * driver.findElement(By.xpath("//*[@id='okta-signin-password']")).click();
		 * driver.findElement(By.xpath("//*[@id='okta-signin-password']")).clear();
		 * driver.findElement(By.xpath("//*[@id='okta-signin-password']")).sendKeys(
		 * "P@ssword123mm123#"); Thread.sleep(500);
		 * driver.findElement(By.id("okta-signin-submit")).click(); Thread.sleep(20000);
		 * driver.get(
		 * "https://republic.okta.com/app/UserHome?iss=https%3A%2F%2Frepublic.okta.com&login_hint=pvenkatarajan%40republicfinance.com"
		 * ); driver.get(
		 * "https://republic.okta.com/enduser/callback?code=me9OlxNuZH7P0nnxJcwAL_m2nzIu6cwAJ29fxcMmNVg&state=XBtGLl6dnVqBdbgqEQwTe8I07wMbLHcKhjPOjhRDbtTeTJnvNgC5U8TGBoIGrwUB"
		 * ); driver.get("https://republic.okta.com/app/UserHome");
		 * driver.findElement(By.xpath(
		 * "//section[@id='main-content']/section/section/div/section/div/a/article/footer/o-tooltip/div[2]/span"
		 * )) .click(); // ERROR: Caught exception [ERROR: Unsupported command
		 * [selectWindow | win_ser_1 // | ]] driver.get(
		 * "https://republic.okta.com/app/salesforce/exk1y2a6uext0cYkP0h8/sso/saml");
		 * driver.get(
		 * "https://republicfinance--qa.sandbox.file.force.com/secur/contentDoor?startURL=https%3A%2F%2Frepublicfinance--qa.sandbox.my.salesforce.com%2Fone%2Fone.app&sid=00DEk0000097rgl%21AQEAQK6dpOhLkCiJvAl7PNaRoL9VSkv7W8JLYDt48KN365mFV63HrcjUwtK3.NGcA_tD1DIjJQ5UWE.oj.iZPPjxHgl0tdaq&skipRedirect=1&lm=eyJlbmMiOiJBMjU2R0NNIiwiYXVkIjoiMDBERWswMDAwMDk3cmdsIiwia2lkIjoie1widFwiOlwiMDBERWswMDAwMDk3cmdsXCIsXCJ2XCI6XCIwMkc1ZTAwMDAwMDlqOU1cIixcImFcIjpcImNvbnRlbnRkb29ydXNlcnRyYW5zaWVudGtleWVuY3J5cHRcIixcInVcIjpcIjAwNUVrMDAwMDBFMU9VdlwifSIsImNyaXQiOlsiaWF0Il0sImlhdCI6MTczMTM0MDQ5MzEyMywiZXhwIjowfQ%3D%3D..4lNPXPy_fOSuzUyS.sl1qX9E7zAslKTyoBtFEEg%3D%3D.x2O0yTql2fOU5DveT7F9-A%3D%3D"
		 * ); driver.get(
		 * "https://republicfinance--qa.sandbox.lightning.force.com/one/one.app");
		 * driver.get(
		 * "https://republicfinance--qa.sandbox.lightning.force.com/lightning/r/Account/001Ek00000pza62IAA/view"
		 * ); Thread.sleep(9000); String w1 = driver.getWindowHandle();
		 * driver.switchTo().window(w1); // THROUGN OKTA END
		 */
		System.out.println("came outside crm login try catch");
		Thread.sleep(20000);
		waitForPageToLoad(driver);
		System.out.println("Waiting for page to fully load.");
		//-----
		  Thread.sleep(3000);
		  System.out.println("before screenshot4");
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String path = System.getProperty("user.dir") + "/screenshot.png"; // Save relative to the project root
		String path = System.getenv("Build.ArtifactStagingDirectory") + "/screenshot4.png";
		FileUtils.copyFile(screenshot, new File(path));
		Thread.sleep(3000);
		  System.out.println(" after screenshot4");
		//-----
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@id=\"oneHeader\"]/div[2]/span/div[2]/ul/li[2]")).click();

		// ((JavascriptExecutor)
		// (driver)).executeScript("arguments[0].scrollIntoView(true)",
		// driver.findElement(By.xpath("//*[@id=\"oneHeader\"]/div[2]/span/div[2]/ul/li[2]")));
		// Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(
				"/html/body/div[4]/div[1]/section/header/div[2]/span/div[2]/ul/li[2]/div/div/div[1]/div/div/a/div/lightning-icon/span/lightning-primitive-icon")));
		Thread.sleep(8000);

		/*
		 * crmtest1 start
		 * 
		 * a1.sendKeys(Keys.ARROW_DOWN).perform(); a1.sendKeys(Keys.ENTER).perform();
		 * 
		 * 
		 * //driver.findElement(By.xpath(
		 * "/html/body/div[4]/div[1]/section/header/div[2]/span/div[2]/ul/li[2]/div/div/div[1]/div/div/a/div/lightning-icon/span/lightning-primitive-icon"
		 * )).click(); Thread.sleep(8000);
		 * 
		 * //((JavascriptExecutor)driver).executeScript("arguments[0].click();",
		 * driver.findElement(By.xpath(
		 * "//header[@id='oneHeader']/div[2]/span/div[2]/ul/li[2]/div/div/div[2]/div/ul/li[2]/a/span[2]"
		 * ))); //Thread.sleep(8000);
		 * 
		 * // ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
		 * driver.findElement(By.xpath(
		 * "/html/body/div[4]/div[1]/section/div[2]/div[1]/div[4]/div/div/div/div[1]/div/div[2]/span[2]/button/lightning-primitive-icon"
		 * ))); // Thread.sleep(8000);
		 * 
		 * a1.sendKeys(Keys.TAB).perform(); Thread.sleep(500);
		 * a1.sendKeys("MARTHA").perform(); a1.sendKeys(Keys.TAB).perform();
		 * a1.sendKeys(Keys.TAB).perform(); Thread.sleep(500);
		 * a1.sendKeys("YYCPXHA").perform(); a1.sendKeys(Keys.TAB).perform();
		 * a1.sendKeys(Keys.TAB).perform(); a1.sendKeys(Keys.TAB).perform();
		 * a1.sendKeys("st1").perform(); a1.sendKeys(Keys.TAB).perform();
		 * //a1.sendKeys("st1").perform(); //a1.sendKeys(Keys.TAB).perform();
		 * a1.sendKeys("kycity").perform(); a1.sendKeys(Keys.TAB).perform();
		 * a1.sendKeys("KY").perform(); a1.sendKeys(Keys.TAB).perform();
		 * a1.sendKeys("42001").perform(); a1.sendKeys(Keys.TAB).perform();
		 * a1.sendKeys("USA").perform(); a1.sendKeys(Keys.TAB).perform();
		 * a1.sendKeys("666034693").perform(); a1.sendKeys(Keys.TAB).perform();
		 * a1.sendKeys("5125011234").perform(); a1.sendKeys(Keys.TAB).perform();
		 * a1.sendKeys("pvenkatarajan@republicfinance.com").perform();
		 * a1.sendKeys(Keys.TAB).perform(); //Thread.sleep(3000);
		 * //a1.sendKeys(Keys.ENTER).perform(); //666034693 //Thread.sleep(3000);
		 * 
		 * Assert.assertTrue(true, "Test pass"); //driver.close();
		 * 
		 * 
		 * crmtest1 end
		 */
	}
	// driver.findElement(By.id("15311:0")).clear();
	// driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[2]/div[1]/div[4]/div/div/div/div[2]/div/div[2]/div/div[1]/section/div/section/div/div/fieldset/div/div/dl[1]/div[1]/div/div/fieldset/div/div[2]/input")).sendKeys("MARTHA");
	// driver.findElement(By.id("15331:0")).clear();
	// driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[2]/div[1]/div[4]/div/div/div/div[2]/div/div[2]/div/div[1]/section/div/section/div/div/fieldset/div/div/dl[1]/div[1]/div/div/fieldset/div/div[4]/input")).sendKeys("YYCPXHA");

	/*
	 * driver.findElement(By.id("15433:0")).clear();
	 * driver.findElement(By.id("15433:0")).sendKeys("666034693");
	 * driver.findElement(By.id("15311:0")).click();
	 * driver.findElement(By.id("15331:0")).click();
	 * driver.findElement(By.id("15391:0")).click();
	 * driver.findElement(By.id("15391:0")).clear();
	 * driver.findElement(By.id("15391:0")).sendKeys("st1");
	 * driver.findElement(By.id("15401:0")).click();
	 * driver.findElement(By.id("15401:0")).clear();
	 * driver.findElement(By.id("15401:0")).sendKeys("austin");
	 * driver.findElement(By.id("15362:0")).click();
	 * driver.findElement(By.id("15362:0")).clear();
	 * driver.findElement(By.id("15362:0")).sendKeys("KY");
	 * driver.findElement(By.id("15412:0")).click();
	 * driver.findElement(By.id("15412:0")).clear();
	 * driver.findElement(By.id("15412:0")).sendKeys("42001");
	 * driver.findElement(By.id("15370:0")).click();
	 * driver.findElement(By.id("15370:0")).clear();
	 * driver.findElement(By.id("15370:0")).sendKeys("USA");
	 * driver.findElement(By.id("15501:0")).click();
	 * driver.findElement(By.id("15501:0")).clear();
	 * driver.findElement(By.id("15501:0")).sendKeys(
	 * "pvenkatarajan@republicfinance.com");
	 * driver.findElement(By.id("15467:0")).click();
	 * driver.findElement(By.id("15467:0")).clear();
	 * driver.findElement(By.id("15467:0")).sendKeys("5125011234");
	 */

	/*
	 * Thread.sleep(9000); driver.findElement(By.xpath(
	 * "/html/body/div[4]/div[1]/section/div[2]/div[1]/div[4]/div/div/div/div[1]/div/div[2]/span[3]/button"
	 * )).click(); Thread.sleep(9000); driver.findElement(By.
	 * xpath("//*[contains(text(), 'JIFWP M OAFZXIFMDT') and contains(@class, 'title slds-truncate')]"
	 * )).click(); //Thread.sleep(20000);
	 */

	// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	// }

	@Test
	public void crmTest2() throws Exception {

		driver.navigate().refresh();
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		waitForPageToLoad(driver);
		System.out.println("Waiting for page to fully load.");
		js.executeScript("window.scroll(0,0);");
		Thread.sleep(8000);

		try {
			// Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//*[@title= 'Branch Operations']")));
			Thread.sleep(3000);
			System.out.println("clicked on branch operations");
		} catch (Exception e) {
			// Assert.assertTrue(false, "Test fail");
			System.out.println("unable to click on branch operations");
		}

		Thread.sleep(8000);
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath("//button[@aria-label='Search']"));
			System.out.println("Element found using the first XPath");
		} catch (NoSuchElementException e) {
			System.out.println("First XPath failed. Trying alternate XPath..");
			try {
				element = driver
						.findElement(By.xpath("//div[contains(@class, 'slds-global-header__item_search')]//input"));
				System.out.println("Element found using the alternate XPath");
			} catch (NoSuchElementException ex) {
				System.out.println("First 2 XPaths failed.");

			}
		}
		/*
		 * try {
		 * 
		 * element = driver.findElement(By.
		 * xpath("//div[contains(@class, 'slds-global-header__item_search')]"));
		 * System.out.println("Element found using the third XPath"); } catch
		 * (NoSuchElementException e) { System.out.println("The 3rd xpath failed"); }
		 */

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));

			JavascriptExecutor js0 = (JavascriptExecutor) driver;
			js0.executeScript("arguments[0].click();", element);

			// JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js0.executeScript("arguments[0].focus();", element);

			Thread.sleep(5000);
			Actions actions = new Actions(driver);
			actions.sendKeys(element, "MARTHA YYCPXHA").sendKeys(Keys.ENTER).perform();
			//actions.sendKeys(element, "JENNIFER FRCZL").sendKeys(Keys.ENTER).perform();
			Thread.sleep(5000);
			// element.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.out.println("NOT clicked searchbox and pressed enter and sleep 5");
		}

		/*
		 * Thread.sleep(8000); element.click(); Thread.sleep(8000);
		 * element.sendKeys("MARTHA YYCPXHA"); Thread.sleep(8000);
		 * element.sendKeys(Keys.ENTER);
		 */

		/*
		 * WebElement e01 = driver.switchTo().activeElement();
		 * e01.sendKeys("MARTHA YYCPXHA"); a1.sendKeys(Keys.ENTER).build().perform();
		 * System.out.println("Switch to active element completed");
		 */

		/*
		 * // a1.sendKeys(Keys.TAB).perform();
		 * a1.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
		 * a1.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
		 * a1.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
		 * a1.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
		 * a1.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
		 * a1.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
		 * a1.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
		 * a1.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
		 * a1.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
		 */
		/*
		 * a1.sendKeys(Keys.SHIFT, Keys.TAB).perform(); a1.sendKeys(Keys.SHIFT,
		 * Keys.TAB).perform(); a1.sendKeys(Keys.SHIFT, Keys.TAB).perform();
		 * a1.sendKeys(Keys.SHIFT, Keys.TAB).perform(); a1.sendKeys(Keys.SHIFT,
		 * Keys.TAB).perform(); a1.sendKeys(Keys.SHIFT, Keys.TAB).perform();
		 * a1.sendKeys(Keys.SHIFT, Keys.TAB).perform(); a1.sendKeys(Keys.SHIFT,
		 * Keys.TAB).perform(); a1.sendKeys(Keys.SHIFT, Keys.TAB).perform();
		 */
		/*
		 * a1.sendKeys(Keys.ENTER).perform();
		 * a1.sendKeys("MARTHA YYCPXHA").sendKeys(Keys.ENTER).build().perform();
		 */

		/*
		 * //for (int i = 1; i < 12; i++) {
		 * //driver.findElement(By.xpath("//input[1]")); } List<WebElement> elements =
		 * driver.findElements(By.xpath("//input[1]")); if (!elements.isEmpty()) {
		 * 
		 * WebElement lastElement = elements.get(elements.size() - 1);
		 * lastElement.click(); }
		 * driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
		 * driver.findElement(By.xpath("(//input[@type='search'])[2]")).
		 * sendKeys("MARTHA YYCPXHA"); Thread.sleep(5000);
		 */

		/*
		 * driver.findElement(By.xpath("(//input[@type='search'])[2]"));
		 * driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
		 * driver.findElement(By.xpath("(//input[@type='search'])[2]")).
		 * sendKeys("MARTHA YYCPXHA"); Thread.sleep(5000);
		 */
		/*
		 * for (int i = 1; i < 3; i++) { driver.findElement(By.
		 * xpath("//input[contains(@class, 'slds-input') and contains(@id, 'input-') and @autocomplete='off']"
		 * )); System.out.println("search customer loop"); } driver.findElement(By.
		 * xpath("//input[contains(@class, 'slds-input') and contains(@id, 'input-') and @autocomplete='off']"
		 * )).click(); driver.findElement(By.
		 * xpath("//input[contains(@class, 'slds-input') and contains(@id, 'input-') and @autocomplete='off']"
		 * )).sendKeys("MARTHA YYCPXHA");
		 */

		// driver.findElement(By.xpath("//*[contains(text(), 'Sandbox:')]")).click();
		// driver.findElement(By.xpath("//*[contains(text(), 'Sandbox:')]")).click();

		/*
		 * for (int i=1; i<5; i++) {a1.sendKeys("\u0009").perform();}
		 * a1.sendKeys(Keys.ENTER);
		 * a1.sendKeys("MARTHA YYCPXHA").sendKeys(Keys.ENTER).build().perform();
		 * //a1.sendKeys(Keys.ENTER).perform(); //driver.findElement(By.
		 * xpath("//*[contains(text(), 'MARTHA YYCPXHA') and contains(@class, 'title slds-truncate')]"
		 * )).click(); Thread.sleep(5000);
		 */

		/*
		 * driver.findElement(By.id("276:0")).clear();
		 * driver.findElement(By.id("276:0")).sendKeys("MARTHA YYCPXHA");
		 */
		// a1.sendKeys(Keys.ENTER);
		// Thread.sleep(2000);
		// *[@id='276:0']

		driver.navigate().refresh();
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		waitForPageToLoad(driver);
		System.out.println("Waiting for page to fully load.");
		// js.executeScript("window.scroll(0,0);");
		Thread.sleep(3000);

		driver.navigate().refresh();
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		waitForPageToLoad(driver);
		System.out.println("Waiting for page to fully load.");
		js.executeScript("window.scroll(0,0);");
		Thread.sleep(3000);

		List<String> xPaths = Arrays.asList(
				"//a[contains(@data-recordid, '001Ek00000qsRWsIAM') and contains(@class, 'outputLookupLink')]",
				"//a[@title='MARTHA YYCPXHA' and contains(@class, 'outputLookupLink')]",
				// "(//a[@title='JENNIFER FRCZL' and contains(@class, 'outputLookupLink')])[1]",
				"//a[contains(@data-ownerid, '17288:0') and contains(@class, 'outputLookupLink')]",
				"//a[contains(@class, 'outputLookupLink') and contains(@data-recordid, '001Ek00000qsRWsIAM')]",
				"//div[contains(@class, 'some-class')]//a[contains(@class, 'outputLookupLink') and contains(@data-recordid, '001Ek00000qsRWsIAM')]");
		boolean found = false;

		for (String xpath : xPaths) {
			try {
				WebElement element2 = driver.findElement(By.xpath(xpath));

				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait2.until(ExpectedConditions.elementToBeClickable(element2));

				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("arguments[0].click();", element2);

				// element2.click();
				System.out.println("Element found and clicked using XPath: " + xpath);
				found = true;
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element not found using XPath: " + xpath);
			}
		}
		if (!found) {
			System.out.println("ArrayList - No element found with any of the provided list of XPaths.");
		}

		/*
		 * for (int i = 1; i < 21; i++) { a1.sendKeys("\u0009").perform(); }
		 * a1.sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).build().perform();
		 */
		Thread.sleep(5000);

		driver.navigate().refresh();
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		waitForPageToLoad(driver);
		System.out.println("Waiting for page to fully load.");
		js.executeScript("window.scroll(0,0);");
		Thread.sleep(3000);
	}
	
	
	
	@Test
	public void crmTest002() throws Exception {
		System.out.println("Waiting for page to fully load. - WAITING FOR 'VIEW' TO JUMP TO APPROVED PAGE - before try");
		
		
		try {
			WebElement element3 = driver.findElement(By.xpath("(//omnistudio-flex-action[contains(@class, 'flexActionElement')]//a[contains(@class, 'slds-action_item')])[71]"));
			//WebElement element3 = driver.findElement(By.xpath("(//omnistudio-flex-action[contains(@class, 'flexActionElement')]//a[contains(@class, 'slds-action_item')])[15]"));		
			
			WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait3.until(ExpectedConditions.elementToBeClickable(element3));

			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].click();", element3);

		} catch (NoSuchElementException e) {
			System.out.println("VIEW xpath not found n clicked - CATCH ");
		}
		
		Thread.sleep(50000);
		System.out.println("Waiting for page to fully load. - WAITING FOR 'VIEW' TO JUMP TO APPROVED PAGE - after try");
	}
		
		/*
		 * WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(60));
		 * wait0.until(ExpectedConditions.elementToBeClickable(
		 * driver.findElement(By.xpath(
		 * "(//span[@title='Start'][normalize-space()='Start'])[3]")))); //
		 * wait.Until(ExpectedConditions.ElementToBeClickable(PageObjectModelClass.
		 * purpose_HowMuch)); // PageObjectModelClass.purpose_HowMuch.click();
		 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		 * driver.findElement(By.xpath(
		 * "(//span[@title='Start'][normalize-space()='Start'])[3]")));
		 */

	

	@Test
	public void crmTest02() throws Exception {

		List<String> xPaths1 = Arrays.asList("//div[@class='slds-col condition-element']//span[@title='Start']",
				"//div[contains(@class, 'slds-col') and contains(@class, 'condition-element')]//a[@aria-label='Start']//span[@title='Start']",
				"//div[contains(@class, 'block-container')]//span[@title='Start']"

		);
		boolean found1 = false;

		for (String xpath01 : xPaths1) {
			try {
				WebElement element3 = driver.findElement(By.xpath(xpath01));
				//(//omnistudio-flex-action[contains(@class, 'flexActionElement')]//a[contains(@class, 'slds-action_item')])[65]
						
				WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait3.until(ExpectedConditions.elementToBeClickable(element3));

				JavascriptExecutor js3 = (JavascriptExecutor) driver;
				js3.executeScript("arguments[0].click();", element3);

				// element3.click();
				System.out.println("Element3 found and clicked using XPath: " + xpath01);
				found1 = true;
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element3 not found using XPath: " + xpath01);
			}
		}
		if (!found1) {
			System.out.println(
					"start button find - ArrayList - No element3 found with any of the provided list of XPaths.");
		}

		// driver.findElement(By.xpath("(//span[@title='Start'][normalize-space()='Start'])[3]")).click();
		// Thread.sleep(9000);
		// WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));

		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@class='title
		// slds-truncate'][normalize-space()='App - JIFWP M OAFZXIFMDT']"))));
		// ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
		// driver.findElement(By.xpath("//span[@class='title
		// slds-truncate'][normalize-space()='App - JIFWP M OAFZXIFMDT']")));
		// System.out.println("inner tab clicked");

		// Thread.sleep(9000);
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section[1]/div/div/section[2]/div/div[2]/div/div/div/c-r-f-k-y-c-details-english/div/article/div[2]/omnistudio-omniscript-step[2]"))));
		// ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
		// driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section[1]/div/div/section[2]/div/div[2]/div/div/div/c-r-f-k-y-c-details-english/div/article/div[2]/omnistudio-omniscript-step[2]")));

		Thread.sleep(25000);
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='input2-1082']"))));
		// ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
		// driver.findElement(By.xpath("//*[@id='input2-1082']")));

		// 88888888 test2 DIVIDE 88888888888

		try {
			driver.findElement(By.xpath(
					"//*[text()='New Application' and contains(@class, 'slds-page-header__title slds-p-horizontal_medium slds-text-heading--medium slds-m-top_medium os-step-label')]"))
					.click();
			System.out.println("new-application text clicked -before frame1");
		} catch (Exception e) {
			System.out.println("new-application text not clicked -before frame1");
			Assert.assertTrue(false, "Test fail");
		}

		// Actions a = new Actions(driver);
		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);

		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		a1.sendKeys("7000").perform();

		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		a1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
		a1.sendKeys(Keys.ENTER).perform();

		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		a1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
		a1.sendKeys(Keys.ENTER).perform();

		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		a1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
		a1.sendKeys(Keys.ENTER).perform();

		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);

		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);

		a1.sendKeys(Keys.SPACE).perform();
		Thread.sleep(1000);

		for (int i = 1; i < 7; i++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		a1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(8000);

		// Thread.sleep(500);
		Assert.assertTrue(true, "Test pass");

	}

	@Test
	public void crmTest3() throws Exception {

		/*
		 * driver.navigate().refresh(); //
		 * driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 * waitForPageToLoad(driver);
		 * System.out.println("Waiting for page to fully load.");
		 * js.executeScript("window.scroll(0,0);"); Thread.sleep(3000);
		 */

		Thread.sleep(20000);
		driver.findElement(By.xpath(
				"//h3[text()='Please verify the information below is correct, update any incorrect/outdated information & fill in any additional fields.']"))
				.click();

		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		a1.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT).perform();
		Thread.sleep(500);
		for (int i = 1; i < 6; i++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		a1.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT).perform();
		Thread.sleep(500);
		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		a1.sendKeys("11/11/1999").perform();
		Thread.sleep(500);
		for (int i = 1; i < 4; i++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		a1.sendKeys("666034693").perform();
		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		a1.sendKeys("0").perform();
		a1.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT).perform();
		Thread.sleep(500);
		for (int i = 1; i < 11; i++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		Thread.sleep(500);
		// a1.sendKeys(Keys.TAB);
		// Thread.sleep(500);
		a1.sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_RIGHT).perform();
		Thread.sleep(500);
		for (int i = 1; i < 3; i++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		Thread.sleep(500);
		a1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(500);
		for (int i = 1; i < 4; i++) {
			a1.sendKeys(Keys.ARROW_DOWN).perform();
		}
		Thread.sleep(500);
		a1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(10000);

		try {
			driver.findElement(By.xpath(
					"(//*[contains(text(), 'By submitting the information in this application for credit')]/preceding-sibling::span[@class='slds-checkbox_faux'])[1]"))
					.click();
			Thread.sleep(20000);
			System.out.println("test3 checkbox done");

			Thread.sleep(3000);
			WebElement e8 = driver.findElement(By.xpath("(//span[text()='Next'])[1]"));
			System.out.println("ssn next STARTED");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", e8);

			WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait8.until(ExpectedConditions.elementToBeClickable(e8));
			js.executeScript("arguments[0].click();", e8);
			// Thread.sleep(3000);
			// driver.findElement(By.xpath("(//*[contains(text(), 'Next')])[3]")).click();
			Thread.sleep(10000);
			System.out.println("test3 next done");
		} catch (Exception e) {
			System.out.println("test3 checkbox or next caught");
		}

		/*
		 * List<String> xPaths2 = Arrays.asList(
		 * "//label[contains(text(), 'Move-In Date/Purchase Date')]/parent::div//input[@id='my-date-input-1366' and @type='Month']"
		 * ,
		 * "//label[contains(text(), 'Move-In Date/Purchase Date')]/parent::div//input[@id='my-date-input-1366' and @type='Month' and @max='2024-11' and contains(@class, 'slds-input') and contains(@class, 'OSDatePickerClass')]"
		 * 
		 * ); boolean found2 = false;
		 * 
		 * for (String xpath02 : xPaths2) { try { WebElement element4 =
		 * driver.findElement(By.xpath(xpath02));
		 * 
		 * WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait4.until(ExpectedConditions.elementToBeClickable(element4));
		 * 
		 * JavascriptExecutor js4 = (JavascriptExecutor) driver;
		 * js4.executeScript("arguments[0].click();", element4);
		 * 
		 * for(int i=1; i<3; i++) { a1.sendKeys(Keys.TAB).perform(); }
		 * a1.sendKeys(Keys.ENTER).perform(); Thread.sleep(500); // element3.click();
		 * System.out.println("Element3 found and clicked using XPath: " + xpath02);
		 * found2 = true; break; } catch (NoSuchElementException e) {
		 * System.out.println("Element3 not found using XPath: " + xpath02); } } if
		 * (!found2) { System.out.
		 * println("ArrayList - No element3 found with any of the provided list of XPaths."
		 * ); }
		 * 
		 * 
		 * Thread.sleep(5000);
		 * driver.findElement(By.xpath("//input[contains(@id, 'input66-')]")).click();
		 * driver.findElement(By.xpath("//input[contains(@id, 'input66-')]")).sendKeys(
		 * "100"); Thread.sleep(1000);
		 * 
		 * a1.sendKeys(Keys.TAB).perform(); Thread.sleep(500);
		 * a1.sendKeys(Keys.SPACE).perform(); Thread.sleep(1000);
		 * a1.sendKeys(Keys.TAB).perform(); a1.sendKeys(Keys.ENTER).perform();
		 */

		Thread.sleep(15000);
		System.out.println("test3 sleep completed");

	}
	/*
	 * driver.switchTo().frame(1);
	 * 
	 * Thread.sleep(9000);
	 * 
	 * try { driver.findElement(By.
	 * xpath("//*[text()='New Application' and contains(@class, 'slds-page-header__title slds-p-horizontal_medium slds-text-heading--medium slds-m-top_medium os-step-label')]"
	 * )).click(); System.out.println("new-application text clicked -after frame1");
	 * } catch(Exception e) {
	 * System.out.println("new-application text not clicked -after frame1"); }
	 * 
	 * driver.findElement(By.xpath("//*[@id='input2-1082']")).click();
	 * driver.findElement(By.xpath("//*[@id='input2-1082']")).sendKeys("1000");
	 * Thread.sleep(20000);
	 */

	// driver.findElement(By.xpath("//span[3]/button/lightning-primitive-icon")).click();

	// Assert.assertTrue(false, "Test fail");

	// driver.close();
	// ERROR: Caught exception [ERROR: Unsupported command [selectWindow |
	// win_ser_local | ]]
	// driver.close();
	// }

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	/*
	 * private boolean isElementPresent(By by) { try { driver.findElement(by);
	 * return true; } catch (NoSuchElementException e) { return false; } }
	 * 
	 * private boolean isAlertPresent() { try { driver.switchTo().alert(); return
	 * true; } catch (NoAlertPresentException e) { return false; } }
	 * 
	 * private String closeAlertAndGetItsText() { try { Alert alert =
	 * driver.switchTo().alert(); String alertText = alert.getText(); if
	 * (acceptNextAlert) { alert.accept(); } else { alert.dismiss(); } return
	 * alertText; } finally { acceptNextAlert = true; } }
	 */

	@Test
	public void crmTest4() throws Exception {
		try {

			/*
			 * driver.navigate().refresh(); //
			 * driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			 * waitForPageToLoad(driver);
			 * System.out.println("Waiting for page to fully load.");
			 */
			/*
			 * //driver.manage().window().setSize(new Dimension(1024, 768));
			 * waitForPageToLoad(driver);
			 * System.out.println("Waiting for page to fully load."); JavascriptExecutor js
			 * = (JavascriptExecutor) driver;
			 * js.executeScript("document.body.style.zoom='30%'");
			 * js.executeScript("window.scroll(0,0);"); Thread.sleep(3000);
			 */

			Thread.sleep(25000);

			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load. - crmTest4 ");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scroll(0,0);");

			WebElement e7 = driver.findElement(By.xpath(
					"//p[text()='Note that alimony, child support, or separate maintenance income need not be revealed if you do not wish to have it considered as a basis of repaying this obligation.']"));

			js.executeScript("arguments[0].scrollIntoView(true);", e7);

			WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait7.until(ExpectedConditions.elementToBeClickable(e7));

			js.executeScript("arguments[0].click();", e7);
			Thread.sleep(2000);

			for (int i = 1; i < 5; i++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.ARROW_RIGHT).perform();
			Thread.sleep(500);

			a1.sendKeys(Keys.TAB).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.SPACE).perform();
			Thread.sleep(500);

			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load.");
			js.executeScript("window.scroll(0,0);");
			Thread.sleep(3000);

			e7.click();
			for (int i = 1; i < 7; i++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			Thread.sleep(500);
			a1.sendKeys(Keys.SPACE).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.TAB).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.SPACE).perform();
			Thread.sleep(500);

			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load.");
			js.executeScript("window.scroll(0,0);");
			Thread.sleep(3000);

			e7.click();
			for (int i = 1; i < 9; i++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			Thread.sleep(5000);
			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load.");
			js.executeScript("window.scroll(0,0);");
			// Thread.sleep(3000);
			// a1.sendKeys(Keys.ENTER).perform();
			// Thread.sleep(15000);
			// -----

			Thread.sleep(5000);
			WebElement e8 = driver.findElement(By.xpath("(//*[contains(text(), 'Next')])[6]"));
			System.out.println("Waiting for page to fully load. - NAOP STARTED");
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", e8);

			WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait8.until(ExpectedConditions.elementToBeClickable(e8));
			js.executeScript("arguments[0].click();", e8);
			Thread.sleep(3000);
			System.out.println("Waiting for page to fully load. - NAOP PROGRESS1");
			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load. -end of test4");
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println("Caught in crmTest4");
		}

	}

	@Test
	public void crmTest5() throws Exception {
		try {

			/*
			 * //WebElement e8; //driver.navigate().refresh(); //
			 * driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			 * waitForPageToLoad(driver);
			 * System.out.println("Waiting for page to fully load.");
			 * js.executeScript("window.scroll(0,0);");
			 */
			Thread.sleep(50000);
			System.out.println("test5 sleep completed");
			waitForPageToLoad(driver);
			System.out.println("test5 load completed");

			// driver.manage().window().setSize(new Dimension(1024, 768));
			// waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load.");
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("document.body.style.zoom='30%'");
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js8.executeScript("window.scroll(0,0);");
			Thread.sleep(2000);
			WebElement e8 = driver.findElement(By.xpath("//h3[text()='Verifications']"));

			// Thread.sleep(9000);
			// WebElement e8 = driver.findElement(By.xpath("//h3[text()='Verifications']"));
			// p[text()='Tell me about any unsatisfied judgments you may have, if
			// applicable.']"));

			WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(160));
			wait8.until(ExpectedConditions.elementToBeClickable(e8));

			js8.executeScript("arguments[0].click();", e8);
			Thread.sleep(15000);
			js8.executeScript("arguments[0].click();", e8);
			Thread.sleep(15000);

		} catch (NoSuchElementException e) {
			System.out.println("Thexe of radio button-1 clicked");
		}

		Thread.sleep(5000);
		/*
		 * for(int i=1; i<3; i++) { a1.sendKeys(Keys.TAB).perform(); }
		 * a1.sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(500);
		 * a1.sendKeys(Keys.SPACE).perform(); Thread.sleep(500);
		 */
		for (int i = 1; i < 6; i++) {
			a1.sendKeys(Keys.TAB).perform();
			a1.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.SPACE).perform();
			Thread.sleep(500);
		}

		// manage debt - start
		try {
			// Thread.sleep(9000);
			Thread.sleep(500);
			WebElement e9 = driver.findElement(By.xpath("//*[text()='Manage Debts']"));
			Thread.sleep(500);
			WebElement e10 = driver.findElement(By.xpath("//div[text()='Manual | MARTHA YYCPXHA']"));
			Thread.sleep(500);

			WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait9.until(ExpectedConditions.elementToBeClickable(e9));

			JavascriptExecutor js9 = (JavascriptExecutor) driver;
			js9.executeScript("arguments[0].click();", e9);
			Thread.sleep(5000);

			WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait10.until(ExpectedConditions.elementToBeClickable(e10));

			JavascriptExecutor js10 = (JavascriptExecutor) driver;
			js10.executeScript("arguments[0].click();", e10);
			Thread.sleep(2000);

		} catch (NoSuchElementException e) {
			System.out.println("Manage debt catch issue");
		}
		// manage debt- end

		for (int i = 1; i < 6; i++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		Thread.sleep(500);
		a1.sendKeys(Keys.SPACE).perform();
		Thread.sleep(5000);

		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		a1.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(500);
		a1.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(500);
		a1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(500);

		a1.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		a1.sendKeys("c").perform();
		Thread.sleep(500);

		for (int i = 1; i < 4; i++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		Thread.sleep(500);
		a1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(500);

		waitForPageToLoad(driver);
		System.out.println("Waiting for page to fully load.");
		js.executeScript("window.scroll(0,0);");
		Thread.sleep(3000);

		// e8.click();
		// driver.findElement(By.xpath("//p[text()='Tell me about any unsatisfied
		// judgments you may have, if applicable.']")).click();

		WebElement e8 = driver.findElement(By.xpath("//h3[text()='Verifications']"));

		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait8.until(ExpectedConditions.elementToBeClickable(e8));

		JavascriptExecutor js9 = (JavascriptExecutor) driver;
		js9.executeScript("arguments[0].scrollIntoView(true);", e8);
		js9.executeScript("arguments[0].click();", e8);
		Thread.sleep(2000);
		js9.executeScript("arguments[0].click();", e8);

		for (int i = 1; i < 18; i++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		// Thread.sleep(500);
		// a1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(9000);

		// ------

		WebElement e9 = driver.findElement(By.xpath("(//*[contains(text(), 'Next')])[8]"));
		System.out.println("Waiting for page to fully load. - DEBT STARTED");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", e9);

		// WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait8.until(ExpectedConditions.elementToBeClickable(e9));
		js.executeScript("arguments[0].click();", e9);
		Thread.sleep(3000);
		System.out.println("Waiting for page to fully load. - DEBT ABOUT TO COMPLETE");
		waitForPageToLoad(driver);
		System.out.println("Waiting for page to fully load. - crmTest5 COMPLETED");
		// js.executeScript("window.scroll(0,0);");
		// Thread.sleep(3000);

	}

	@Test
	public void crmTest6() throws Exception {

		/*
		 * //WebElement e8; //driver.navigate().refresh(); //
		 * driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 * waitForPageToLoad(driver);
		 * System.out.println("Waiting for page to fully load.");
		 * js.executeScript("window.scroll(0,0);");
		 */
		// Thread.sleep(30000);

		try {
			/*
			 * //scroll to middle of page JavascriptExecutor js = (JavascriptExecutor)
			 * driver; Long documentHeight = (Long)
			 * js.executeScript("return document.body.scrollHeight");
			 * js.executeScript("window.scrollTo(0, arguments[0] / 2);", documentHeight);
			 */

			// driver.manage().window().setSize(new Dimension(1024, 768));
			// waitForPageToLoad(driver);
			// System.out.println("Waiting for page to fully load.");
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("document.body.style.zoom='30%'");
			// js.executeScript("window.scroll(0,0);");

			Thread.sleep(9000);
			WebElement e8 = driver.findElement(By.xpath("(//*[text()='Open'])[1]"));
			// p[text()='Tell me about any unsatisfied judgments you may have, if
			// applicable.']"));
			System.out.println("Waiting for page to fully load. - crmTest6 STARTED");
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", e8);

			WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait8.until(ExpectedConditions.elementToBeClickable(e8));
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js8.executeScript("arguments[0].click();", e8);
			Thread.sleep(500);

			System.out.println("Waiting for page to fully load. - crmTest6 PROGRESS1");
			// a1.sendKeys(Keys.TAB).perform();
			// a1.sendKeys(Keys.ENTER).perform();
			waitForPageToLoad(driver);
			Thread.sleep(10000);

			driver.findElement(By.xpath("//*[text()='Personal Information Verification']")).click();
			Thread.sleep(3000);
			for (int i = 1; i < 3; i++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[text()='Personal Information Verification']")).click();
			Thread.sleep(2000);
			for (int i1 = 1; i1 < 14; i1++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			Thread.sleep(2000);
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.ARROW_DOWN).perform();
			a1.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(500);

			for (int i2 = 1; i2 < 3; i2++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.ARROW_DOWN).perform();
			a1.sendKeys(Keys.ARROW_DOWN).perform();
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.TAB).perform();
			a1.sendKeys(Keys.SPACE).perform();
			Thread.sleep(500);
			for (int i3 = 1; i3 < 3; i3++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			Thread.sleep(5000);
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(500);
			waitForPageToLoad(driver);

		} catch (NoSuchElementException e) {
			System.out.println("verification catch 1 - 1st section of verification catch");
		}

		Thread.sleep(8000);

		try {
			for (int i = 1; i < 3; i++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(500);

			for (int i = 1; i < 3; i++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			a1.sendKeys("c").perform();
			Thread.sleep(500);

			for (int i1 = 1; i1 < 3; i1++) {
				a1.sendKeys(Keys.TAB).perform();
				a1.sendKeys(Keys.SPACE).perform();
			}
			Thread.sleep(500);

			for (int i1 = 1; i1 < 4; i1++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			a1.sendKeys(Keys.ARROW_DOWN).perform();
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.TAB).perform();
			a1.sendKeys("111111").perform();
			Thread.sleep(500);

			for (int i1 = 1; i1 < 3; i1++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			Thread.sleep(500);
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.ARROW_DOWN).perform();
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(500);

			for (int i1 = 1; i1 < 3; i1++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			Thread.sleep(5000);
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(5000);
			// driver.findElement(By.xpath("//*[text()='Personal Information
			// Verification']")).click();
			a1.sendKeys(Keys.TAB).perform();
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(8000);
			a1.sendKeys(Keys.ESCAPE).perform();
			Thread.sleep(9000);

		} catch (NoSuchElementException e) {
			System.out.println("Verification catch 2 - section2 catch");
		}

		// ++++++++++++

		WebElement e8 = driver.findElement(By.xpath("(//*[text()='Open'])[2]"));
		// p[text()='Tell me about any unsatisfied judgments you may have, if
		// applicable.']"));

		js.executeScript("arguments[0].scrollIntoView(true);", e8);

		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait8.until(ExpectedConditions.elementToBeClickable(e8));
		JavascriptExecutor js8 = (JavascriptExecutor) driver;
		js8.executeScript("arguments[0].click();", e8);
		Thread.sleep(2000);

		// a1.sendKeys(Keys.TAB).perform();
		// a1.sendKeys(Keys.ENTER).perform();
		waitForPageToLoad(driver);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[text()='+ Add Property']")).click();
		Thread.sleep(2000);
		a1.sendKeys(Keys.TAB).perform();
		a1.sendKeys("d").perform();
		Thread.sleep(500);
		a1.sendKeys(Keys.TAB).perform();
		a1.sendKeys("800000").perform();
		Thread.sleep(500);
		for (int i1 = 1; i1 < 3; i1++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		a1.sendKeys("m").perform();
		Thread.sleep(500);
		a1.sendKeys(Keys.TAB).perform();
		a1.sendKeys("111111").perform();
		Thread.sleep(500);

		for (int i1 = 1; i1 < 3; i1++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		a1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);

		a1.sendKeys(Keys.TAB).perform();
		a1.sendKeys(Keys.ENTER).perform();
		a1.sendKeys(Keys.ESCAPE).perform();

		waitForPageToLoad(driver);
		Thread.sleep(500);
		System.out.println("Waiting for page to fully load.");
		js.executeScript("window.scroll(0,0);");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[text()='Loan Details']")).click();
		for (int i = 1; i < 3; i++) {
			a1.sendKeys(Keys.TAB).perform();
		}
		a1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(500);
		a1.sendKeys(Keys.ARROW_DOWN).perform();
		a1.sendKeys(Keys.ARROW_DOWN).perform();
		a1.sendKeys(Keys.ENTER).perform();

		waitForPageToLoad(driver);
		js.executeScript("window.scroll(0,0);");

		WebElement e10 = driver.findElement(By.xpath("//button[text()='Generate Offers']"));
		// p[text()='Tell me about any unsatisfied judgments you may have, if
		// applicable.']"));

		js.executeScript("arguments[0].scrollIntoView(true);", e10);

		WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait10.until(ExpectedConditions.elementToBeClickable(e10));
		// JavascriptExecutor js8 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", e10);
		// Thread.sleep(500);

		// +++++++++++++

		Thread.sleep(15000);
		System.out.println("crmTest6 COMPLETED");
		// driver.findElement(By.xpath("//button[text()='PresentOffers']")).click();
		// Thread.sleep(8000);

	}

	@Test
	public void crmTest7() throws Exception {

		/*
		 * //WebElement e8; //driver.navigate().refresh(); //
		 * driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 * waitForPageToLoad(driver);
		 * System.out.println("Waiting for page to fully load.");
		 * js.executeScript("window.scroll(0,0);");
		 */
		// Thread.sleep(30000);

		// driver.manage().window().setSize(new Dimension(1024, 768));

		try {

			System.out.println("Waiting for page to fully load. - crmTest7 STARTED");
			waitForPageToLoad(driver);
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("document.body.style.zoom='30%'");
			js.executeScript("window.scroll(0,0);");
			// waitForPageToLoad(driver);
			// js.executeScript("window.scroll(0,0);");
			/*
			 * //scroll to middle of page JavascriptExecutor js = (JavascriptExecutor)
			 * driver; Long documentHeight = (Long)
			 * js.executeScript("return document.body.scrollHeight");
			 * js.executeScript("window.scrollTo(0, arguments[0] / 2);", documentHeight);
			 */
			
			// kkkkkkkkkkkkkkkkkkk
			js.executeScript("document.body.style.zoom='30%'");
			Thread.sleep(25000);
			System.out.println("entered into crmTest7 - changed size 30% ");
			Thread.sleep(3000);
			// kkkkkkkkkkkkkkkkkkk

			//Thread.sleep(25000);

			WebElement e10 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			// p[text()='Tell me about any unsatisfied judgments you may have, if
			// applicable.']"));

			js.executeScript("arguments[0].scrollIntoView(true);", e10);

			WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(180));
			wait8.until(ExpectedConditions.elementToBeClickable(e10));
			// JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", e10);

			Thread.sleep(40000);
			System.out.println("Waiting for page to fully load. - crmTest7 STARTED n clicked on CHECKBOX");
			waitForPageToLoad(driver);

			WebElement e8 = driver.findElement(By.xpath("(//*[text()='Select Loan Class'])[2]"));
			// p[text()='Tell me about any unsatisfied judgments you may have, if
			// applicable.']"));

			js.executeScript("arguments[0].scrollIntoView(true);", e8);

			// WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait8.until(ExpectedConditions.elementToBeClickable(e8));
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js8.executeScript("arguments[0].click();", e8);
			System.out.println("Waiting for page to fully load. - crmTest7 STARTED n clicked loan class dropdown ");
			Thread.sleep(20000);

			// for(int i=1; i<14; i++) { a1.sendKeys(Keys.TAB).perform(); }
			a1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(5000);
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(30000);
			a1.sendKeys(Keys.TAB).perform();
			Thread.sleep(2000);
			a1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(30000);
			a1.sendKeys(Keys.TAB).perform();
			Thread.sleep(500);
			a1.sendKeys("24").perform();
			Thread.sleep(500);
			for (int i1 = 1; i1 < 3; i1++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			Thread.sleep(500);
			a1.sendKeys("4").perform();
			Thread.sleep(500);
			a1.sendKeys(Keys.TAB).perform();
			Thread.sleep(500);
			a1.sendKeys("2000").perform();
			Thread.sleep(3000);

			Thread.sleep(20000);
			WebElement e11 = driver.findElement(By.xpath("(//button[contains(text(), 'Calculate')])[2]"));
			System.out.println("Waiting for page to fully load. - CALCULATE STARTED");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", e11);

			// WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait8.until(ExpectedConditions.elementToBeClickable(e11));
			js.executeScript("arguments[0].click();", e11);

			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load. - CLACULATE CLICKED - load completed");
			Thread.sleep(40000);
			System.out.println("Waiting for page to fully load. - CLACULATE CLICKED - sleep completed");
			// a1.sendKeys(Keys.TAB).perform();
			// a1.sendKeys(Keys.TAB).perform();
			// a1.sendKeys(Keys.ENTER).perform();

			// 222222222222222222222

			// waitForPageToLoad(driver);
			// js.executeScript("window.scroll(0,0);");
			/*
			 * //scroll to middle of page JavascriptExecutor js = (JavascriptExecutor)
			 * driver; Long documentHeight = (Long)
			 * js.executeScript("return document.body.scrollHeight");
			 * js.executeScript("window.scrollTo(0, arguments[0] / 2);", documentHeight);
			 */
			// Thread.sleep(9000);

			Thread.sleep(3000);
			System.out.println("Waiting for page to fully load. - SLEEPING 3sec- BEFORE SUBMIT START");
			WebElement e12 = driver.findElement(By.xpath("(//button[text()='Submit'])[2]"));
			System.out.println("Waiting for page to fully load. - SUBMIT STARTED");
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", e12);

			// WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait8.until(ExpectedConditions.elementToBeClickable(e12));
			js.executeScript("arguments[0].click();", e12);
			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load. - SUBMIT CLICKED - load completed");
			Thread.sleep(50000);
			System.out.println("Waiting for page to fully load. - SUBMIT CLICKED  - sleep completed");
			Thread.sleep(10000);

			Thread.sleep(3000);
			WebElement e13 = driver.findElement(By.xpath("(//button[text()='Expand/Collapse'])[2]"));
			System.out.println("Waiting for page to fully load. - Expand STARTED");
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", e13);

			// WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait8.until(ExpectedConditions.elementToBeClickable(e13));
			js.executeScript("arguments[0].click();", e13);
			Thread.sleep(3000);
			System.out.println("Waiting for page to fully load. - Expand Clicked");
			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load. - Expand load completed");
			Thread.sleep(3000);
			System.out.println("Waiting for page to fully load. - Expand sleep completed");

			Thread.sleep(3000);
			WebElement e14 = driver.findElement(By.xpath("//*[text()='Sales Comments']/following::textarea[1]"));
			System.out.println("Waiting for page to fully load. - comment STARTED");
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", e14);

			// WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait8.until(ExpectedConditions.elementToBeClickable(e14));
			js.executeScript("arguments[0].click();", e14);
			Thread.sleep(3000);
			System.out.println("Waiting for page to fully load. - comment Clicked");
			e14.sendKeys("Need Approval");
			Thread.sleep(6000);
			// waitForPageToLoad(driver);
			// System.out.println("Waiting for page to fully load. - comment load
			// completed");
			// Thread.sleep(3000);
			System.out.println("Waiting for page to fully load. - comment sleep completed");
			a1.sendKeys(Keys.TAB).perform();
			Thread.sleep(2000);
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(30000);
			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load. - comment load completed");
			Thread.sleep(3000);

			// a1.sendKeys(Keys.TAB).perform();
			// a1.sendKeys("Need Approval").perform();
			// waitForPageToLoad(driver);
			// js.executeScript("window.scroll(0,0);");

			// Thread.sleep(3000);
			WebElement e15 = driver.findElement(By.xpath("//*[text()='Needs Review']"));
			System.out.println("Waiting for page to fully load. - need review STARTED");
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", e15);

			// WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait8.until(ExpectedConditions.elementToBeClickable(e15));
			js.executeScript("arguments[0].click();", e15);
			Thread.sleep(3000);
			System.out.println("Waiting for page to fully load. - need review Clicked");
			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load. - need review load completed");
			Thread.sleep(3000);
			System.out.println("Waiting for page to fully load. - need review sleep completed");

			// driver.findElement(By.xpath("//*[text()='Needs Review']")).click();
			// waitForPageToLoad(driver);
			// Thread.sleep(6000);
			// System.out.println("Waiting for page to fully load. - need review clicked ");
			js.executeScript("window.scroll(0,0);");
			Thread.sleep(6000);

			// Thread.sleep(3000);
			WebElement e16 = driver.findElement(By.xpath("//*[text()='Send for Review']"));
			System.out.println("Waiting for page to fully load. - send review STARTED");
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", e16);
			// WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(120));
			wait8.until(ExpectedConditions.elementToBeClickable(e16));
			js.executeScript("arguments[0].click();", e16);
			Thread.sleep(3000);
			System.out.println("Waiting for page to fully load. - send review Clicked");
			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load. - send review load completed");
			Thread.sleep(3000);
			System.out.println("Waiting for page to fully load. - send review sleep completed");

			// driver.findElement(By.xpath("//*[text()='Needs Review']")).click();
			// waitForPageToLoad(driver);
			// Thread.sleep(6000);
			// System.out.println("Waiting for page to fully load. - need review clicked ");
			js.executeScript("window.scroll(0,0);");
			Thread.sleep(15000);

			// driver.findElement(By.xpath("//*[text()='Send for Review']")).click();
			// Thread.sleep(15000);
			System.out.println("Waiting for page to fully load. - send for review completed and scrolled up");
			// Thread.sleep(15000);
			a1.sendKeys(Keys.TAB).perform();
			a1.sendKeys(Keys.SPACE).perform();
			Thread.sleep(5000);
			for (int i = 1; i < 4; i++) {
				a1.sendKeys(Keys.TAB).perform();
			}
			a1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(15000);
			waitForPageToLoad(driver);
			System.out.println("Waiting for page to fully load. - all tabs completed");
			Thread.sleep(10000);

			/*
			 * //WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(60));
			 * wait8.until(ExpectedConditions.elementToBeClickable(e8));
			 * //JavascriptExecutor js8 = (JavascriptExecutor) driver;
			 * js8.executeScript("arguments[0].click();", e8); Thread.sleep(500);
			 * 
			 * for(int i=1; i<11; i++) { a1.sendKeys(Keys.TAB).perform(); }
			 * a1.sendKeys(Keys.ENTER).perform(); Thread.sleep(5000); e8.click(); for(int
			 * i=1; i<11; i++) { a1.sendKeys(Keys.TAB).perform(); } e8.click(); for(int i=1;
			 * i<25; i++) { a1.sendKeys(Keys.TAB).perform(); }
			 * a1.sendKeys("Need Approval").perform(); waitForPageToLoad(driver);
			 * js.executeScript("window.scroll(0,0);");
			 * driver.findElement(By.xpath("//*[text()='Needs Review']")).click();
			 * waitForPageToLoad(driver); js.executeScript("window.scroll(0,0);");
			 * driver.findElement(By.xpath("//*[text()='Send for Review']")).click();
			 * a1.sendKeys(Keys.TAB).perform(); a1.sendKeys(Keys.SPACE).perform(); for(int
			 * i=1; i<4; i++) { a1.sendKeys(Keys.TAB).perform(); }
			 * a1.sendKeys(Keys.ENTER).perform();
			 */

			/*
			 * wait fr pg load 30 pointer click 10th tab --enter ponter click 10th tab - no
			 * enter pointer click 24th tab sendkets - need approval wait fr pg load - 30
			 * click xpath = //*[text()='Needs Review'] wait fr pg load - 10 click xpath =
			 * //*[text()='Send for Review'] tab plus space 3rd tab n enter
			 */
			// 000000000000000000000000++++++++++++

		} catch (NoSuchElementException e) {
			System.out.println("caught issue during crmTest7");
		}

	}

	@Test
	public void crmTest8() throws InterruptedException {

		try {
			System.out.println("entered into crmTest8");
			Thread.sleep(3000);
			waitForPageToLoad(driver);

			// driver.get(url);
			System.out.println("entered into crmTest8 - try");
			Thread.sleep(10000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(160));

			// kkkkkkkkkkkkkkkkkkk
			js.executeScript("document.body.style.zoom='30%'");
			Thread.sleep(25000);
			System.out.println("entered into crmTest8 - changed size 30% ");
			Thread.sleep(3000);
			// kkkkkkkkkkkkkkkkkkk
			
			// SECTION IN TXT START-1
			  
			  
			  WebElement presentOffersButton =
			  driver.findElement((By.xpath("//button[text()='PresentOffers']")));
			  wait.until(ExpectedConditions.elementToBeClickable(presentOffersButton));
			  System.out.
			  println("entered into crmTest8 - presentoffersbutton wait until completed");
			  Thread.sleep(10000); scrollToElement(driver, presentOffersButton);
			  //JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("arguments[0].scrollIntoView(true);", presentOffersButton);
			  System.out.
			  println("entered into crmTest8 - presentoffersbutton scroll completed");
			  js.executeScript("window.scroll(0,0);"); Thread.sleep(10000);
			  presentOffersButton.click(); System.out.
			  println("entered into crmTest8 - presentoffersbutton click completed and started waiting"
			  );
			  
			  Thread.sleep(30000);
			  System.out.println("entered into crmTest8 - next checkbox 4 loop start");
			  
			  for (int i = 0; i < 4; i++) {
			  System.out.println("entered into crmTest8 - next checkbox loop number" +i);
			  //WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[6]")));
			  //System.out.println("entered into crmTest8 - chkbox wait completed");
			  //Thread.sleep(8000); 
			  //scrollToElement(driver, checkbox);
			  //System.out.println("entered into crmTest8 - chkbox scroll completed");
			  //Thread.sleep(8000); 
			  // js.executeScript("arguments[0].click();", checkbox);
			  //checkbox.click(); Thread.sleep(8000);
			  
			  WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next']"))); 
			  //scrollToElement(driver, nextButton);
			  //nextButton.click(); 
			  //Thread.sleep(8000); 
			  //---
			  System.out.println("entered into crmTest8 - next wait completed");
			  Thread.sleep(8000); 
			  scrollToElement(driver, nextButton);
			  System.out.println("entered into crmTest8 - next scroll completed");
			  Thread.sleep(8000); 
			  js.executeScript("arguments[0].click();", nextButton);
			  //checkbox.click(); 
			  Thread.sleep(8000); 
			  }
			  System.out.println("entered into crmTest8 - next checkbox 4 loop completed");
			  
			  Thread.sleep(2000); 
			  WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']"))); 
			  Thread.sleep(8000);
			  System.out.println("entered into crmTest8 - save wait completed");
			  scrollToElement(driver, saveButton); 
			  Thread.sleep(15000);
			  System.out.println("entered into crmTest8 - save scroll completed");
			  js.executeScript("arguments[0].click();", saveButton); 
			  Thread.sleep(15000);
			  System.out.println("entered into crmTest8 - save click completed");
			  // 77777777777777
			  Thread.sleep(2000); waitForPageToLoad(driver); System.out.
			  println("entered into crmTest8 - beginbook scroll-pg load completed 0");
			  // 7777777777777
			  Thread.sleep(5000);
			  
			  //scroll to middle of page JavascriptExecutor 
			  js = (JavascriptExecutor) driver; 
			  Long documentHeight = (Long) js.executeScript("return document.body.scrollHeight");
			  js.executeScript("window.scrollTo(0, arguments[0] / 2);", documentHeight);
			  Thread.sleep(5000); js.executeScript("document.body.style.zoom='30%'");
			  Thread.sleep(5000); System.out.
			  println("entered into crmTest8 - scrolled to middle - changed size 30% - to see beginBooking"
			  ); Thread.sleep(50000);
			  
			  
			  WebElement beginBookingButton =
			  wait.until(ExpectedConditions.elementToBeClickable(By.
			  xpath("(//button[text()='Begin Booking'])[2]"))); Thread.sleep(8000);
			  System.out.println("entered into crmTest8 - beginbooking wait completed");
			  scrollToElement(driver, beginBookingButton); Thread.sleep(30000);
			  System.out.println("entered into crmTest8 - beginbook scroll completed1");
			  waitForPageToLoad(driver); System.out.
			  println("entered into crmTest8 - beginbook scroll-pg load completed2");
			  Thread.sleep(5000); js.executeScript("arguments[0].focus();",
			  beginBookingButton);
			  System.out.println("entered into crmTest8 - beginbook focus complete");
			  Thread.sleep(5000); js.executeScript("arguments[0].click();",
			  beginBookingButton); Thread.sleep(50000);
			  System.out.println("entered into crmTest8 - beginbook click completed");
			  Thread.sleep(30000); System.out.
			  println("entered into crmTest8 - closingprep small n big frame wait complete"
			  );
			  
			  /*
			  WebElement closeButton =
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@data-key='close'])[48]"))); 
			  Thread.sleep(8000); 
			  System.out.println("entered into crmTest8 - beginbooking close wait completed");
			  scrollToElement(driver, closeButton); Thread.sleep(8000); System.out.
			  println("entered into crmTest8 - beginbooking close scroll completed");
			  closeButton.click(); 
			  Thread.sleep(2000); 
			  System.out.println("entered into crmTest8 - beginbooking close click completed");
			  */
			  
			  WebElement closingPrepButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Move to Closing Prep']"))); Thread.sleep(8000);
			  System.out.println("entered into crmTest8 - closingprep wait completed");
			  scrollToElement(driver, closingPrepButton); 
			  Thread.sleep(15000);
			  System.out.println("entered into crmTest8 - closingprep scroll completed");
			  //closingPrepButton.click(); 
			  js.executeScript("arguments[0].click();", closingPrepButton); 
			  Thread.sleep(30000);
			  System.out.println("entered into crmTest8 - closingprep click completed");
			  
			  // SECTION IN TXT END-1
			 
			// kkkkkkkkkkkkkkkkkkk
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("catch of crmTest8");
		}
		/*
		 * finally { driver.quit(); }
		 */
	}
			
			  
				@Test
				public void crmTest9() throws InterruptedException {
			  
			  
					try {
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(160));
			  // SECTION IN TXT START-2
			  
			  Thread.sleep(5000);
			  System.out.println("entered into crmTest8 - ACH STEP START");
			  js.executeScript("document.body.style.zoom='30%'"); 
			  Thread.sleep(15000);
			  System.out.
			  println("entered into crmTest8 - ACH - changed size 30% - to see ACH");
			  Thread.sleep(5000); waitForPageToLoad(driver);
			  System.out.println("entered into crmTest8 - ACH - pg load complete fr ach");
			  Thread.sleep(3000); // kkkkkkkkkkkkkkkkkkk
			  
			  WebElement achButton =
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
			  "//*[text()='ACH']"))); Thread.sleep(8000);
			  System.out.println("entered into crmTest8 - ACH wait completed");
			  scrollToElement(driver, achButton); Thread.sleep(8000);
			  System.out.println("entered into crmTest8 - ACH scroll completed");
			  Thread.sleep(3000); js.executeScript("arguments[0].focus();", achButton);
			  System.out.println("entered into crmTest8 - ACH focus complete");
			  Thread.sleep(5000); js.executeScript("arguments[0].click();", achButton);
			  Thread.sleep(10000);
			  System.out.println("entered into crmTest8 - ACH click completed");
			  Thread.sleep(5000);
			  
			  WebElement inOfficeButton = wait.until(
			  ExpectedConditions.elementToBeClickable(By.
			  xpath("//*[text()='In Office-Personal Device']"))); Thread.sleep(8000);
			  scrollToElement(driver, inOfficeButton); Thread.sleep(8000);
			  inOfficeButton.click();
			  
			  Thread.sleep(9000);
			  
			  for (int i1 = 1; i1 < 7; i1++) 
			  { a1.sendKeys(Keys.TAB).perform();
			  Thread.sleep(500); } 
			  a1.sendKeys("a").perform(); 
			  Thread.sleep(2000);
			  a1.sendKeys(Keys.TAB).perform(); Thread.sleep(2000);
			  a1.sendKeys("5125011234").perform(); Thread.sleep(2000);
			  System.out.println(" beneficiary added"); 
			  Thread.sleep(5000);
			  
			  try {
				  System.out.println("came into EXISTING addReference try block");
				  Thread.sleep(5000);

			  if(driver.findElement(By.xpath("//*[text()='We found these references, do you want to include them as current references?']")).isDisplayed())
			  {
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("(//omnistudio-block[contains(@data-style-id, 'state0element0block_element0block_element2')]//div[contains(@class, 'slds-col') and contains(@class, 'slds-text-align_center')])[1]")).click();
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("(//omnistudio-block[contains(@data-style-id, 'state0element0block_element0block_element2')]//div[contains(@class, 'slds-col') and contains(@class, 'slds-text-align_center')])[2]")).click();
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("(//omnistudio-block[contains(@data-style-id, 'state0element0block_element0block_element2')]//div[contains(@class, 'slds-col') and contains(@class, 'slds-text-align_center')])[3]")).click();
				  Thread.sleep(5000);
			  }}
			  catch(Exception e)
			  {System.out.println("came into EXISTING addReference catch block");
			  Thread.sleep(5000);}
			  
			  
			  /*
			  try {
				  System.out.println("came into addReference try block");
			  WebElement addReferenceButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add Reference']"))); 
			  
			  if (addReferenceButton.isEnabled()) {
				  System.out.println("came into addReference isEnabled if condition");
			  //for (int i2 = 1; i2 < 4; i2++) 
			  {
				  System.out.println("came into addReference isEnabled- for loop");
				  Thread.sleep(5000);
				 // WebElement addReferenceButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add Reference']"))); 
				
			  //scrollToElement(driver, addReferenceButton); 
			  //Thread.sleep(3000);
			  //addReferenceButton.click();
			  js.executeScript("arguments[0].click();", addReferenceButton); 
			  Thread.sleep(20000);
			  
			  Actions actions = new Actions(driver);
			  actions.sendKeys(Keys.TAB).perform();
			  Thread.sleep(500);
			  actions.sendKeys("a").perform();
			  Thread.sleep(500);
			  actions.sendKeys(Keys.TAB).perform();
			  Thread.sleep(500);
			  actions.sendKeys("a").perform();
			  Thread.sleep(500);
			  actions.sendKeys(Keys.TAB).perform();
			  Thread.sleep(500);
			  actions.sendKeys(Keys.ENTER).perform();
			  Thread.sleep(500);
			  actions.sendKeys(Keys.DOWN).perform();
			  Thread.sleep(500);
			  actions.sendKeys(Keys.ENTER).perform();
			  Thread.sleep(500);
			  actions.sendKeys(Keys.TAB).perform();
			  Thread.sleep(500);
			  actions.sendKeys("5125011234").perform(); 
			  Thread.sleep(5000);
			  actions.sendKeys(Keys.TAB).perform();
			  Thread.sleep(500);
			  actions.sendKeys(Keys.TAB).perform(); 
			  Thread.sleep(8000);
			  actions.sendKeys(Keys.ENTER).perform(); 
			  Thread.sleep(30000);
			  System.out.println(" reference added" );
			  Thread.sleep(2000);
			  }}}
			  catch(Exception e)
			  {System.out.println("came into addReference catch block - Need to add existing reference steps in catch");
			  Thread.sleep(20000);}
			  */
			  
					} catch (InterruptedException e) {
						e.printStackTrace();
						System.out.println("Outer catch of crmTest9");
					}
					/*
					 * finally { driver.quit(); }
					 */
				}
			  
			  
			  //>>>>>>>>>>>>>>>>>>>>>>>>>
			  
				@Test
				public void crmTest10() throws InterruptedException {
			  
			  
					try {
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(160));
			  
			  Thread.sleep(8000); 
			  WebElement nextButton1 = wait
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(
			  "(//*[text()='Next'])[1]"))); 
			  Thread.sleep(8000);
			  System.out.println("ach next wait complete"); 
			  scrollToElement(driver,
			  nextButton1); 
			  Thread.sleep(8000);
			  System.out.println("ach next scroll complete"); 
			  // nextButton1.click();
			  js.executeScript("arguments[0].click();", nextButton1);
			  System.out.println("entered into crmTest8 - nextButton1 click completed");
			  Thread.sleep(50000);
			  System.out.println("entered into crmTest8 - nextButton1 sleep completed");
			  Thread.sleep(3000);
			  
			  // kkkkkkkkkkkkkkkkkkk 
			  js.executeScript("document.body.style.zoom='30%'");
			  Thread.sleep(15000); System.out.
			  println("entered into crmTest8 - docs - changed size 30% - to see docs");
			  Thread.sleep(3000); waitForPageToLoad(driver);
			  System.out.println("entered into crmTest8 - docs - pg load completed");
			  Thread.sleep(3000); // kkkkkkkkkkkkkkkkkkk
			  
			  WebElement generateDocsButton = wait.until(ExpectedConditions
			  .elementToBeClickable(By.
			  xpath("(//button[@aria-label='Next: Generate Docs'])[1]")));
			  Thread.sleep(8000); scrollToElement(driver, generateDocsButton);
			  Thread.sleep(8000); generateDocsButton.click();
			  
			  Thread.sleep(50000);
			  
			  // SECTION IN TXT END-2
			 		
			
			
			// kkkkkkkk CHECK1 KKKKKKKKKK
			// kkkkkkkk CHECK1 KKKKKKKKKK
			// kkkkkkkk CHECK1 KKKKKKKKKK
			
			// kkkkkkkkkkkkkkkkkkk
			js.executeScript("document.body.style.zoom='30%'");
			Thread.sleep(15000);
			System.out.println("entered into crmTest8 - docs - changed size 30% - view doc -done1");
			Thread.sleep(3000);
			waitForPageToLoad(driver);
			System.out.println("entered into crmTest8 - docs - pg load completed- view doc -done2");
			Thread.sleep(3000);
			// kkkkkkkkkkkkkkkkkkk
			
			/*
			WebElement viewDocumentsButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='View Documents']")));
			Thread.sleep(8000);
			System.out.println("entered into crmTest8 - docs - wait complete - view doc -done1");
			scrollToElement(driver, viewDocumentsButton);
			Thread.sleep(8000);
			System.out.println("entered into crmTest8 - docs - scroll complete - view doc -done1");
			//viewDocumentsButton.click();  
			js.executeScript("arguments[0].click();", viewDocumentsButton);
			System.out.println("entered into crmTest8 - docs - click complete - view doc -done1");
			Thread.sleep(30000);
*/
			
			
			  // SECTION IN TXT START-3
			  
			  WebElement doneButton = wait
			  .until(ExpectedConditions.elementToBeClickable(By.xpath(
			  "(//*[text()='Done'])[1]"))); Thread.sleep(8000);
			  System.out.println("done01"); scrollToElement(driver, doneButton);
			  Thread.sleep(8000); System.out.println("done02"); //doneButton.click();
			  js.executeScript("arguments[0].click();", doneButton);
			  
			  Thread.sleep(60000); System.out.println("done03");
			  
			  // SECTION IN TXT END-3
			 			
			
			
			WebElement regenerateButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Regenerate Loan Packet']")));
			Thread.sleep(8000);
			System.out.println("done04");
			scrollToElement(driver, regenerateButton);
			Thread.sleep(8000);
			System.out.println("done05");
			//regenerateButton.click(); 
			js.executeScript("arguments[0].click();", regenerateButton);

			Thread.sleep(40000);
			System.out.println("done06");
			
			/*
			WebElement viewDocumentsAgainButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='View Documents'])[1]")));
			Thread.sleep(8000);
			System.out.println("done07");
			scrollToElement(driver, viewDocumentsAgainButton);
			Thread.sleep(8000);
			System.out.println("done08");
			//viewDocumentsAgainButton.click(); 
			js.executeScript("arguments[0].click();", viewDocumentsAgainButton);

			Thread.sleep(30000);
			System.out.println("done09");
			*/
			
			
			//  REMOVE 'WEBELEMENT' - ALREADY IN PREVIOUS 'DONE BUTTON SECTION'
			//WebElement 
			doneButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Done'])[1]")));
			Thread.sleep(8000);
			System.out.println("done10");
			scrollToElement(driver, doneButton);
			Thread.sleep(8000);
			System.out.println("done11");
			//doneButton.click(); 
			js.executeScript("arguments[0].click();", doneButton);

			Thread.sleep(20000);
			System.out.println("done12");

		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("catch of crmTest8");
		}
		/*
		 * finally { driver.quit(); }
		 */
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void waitForPageToLoad(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver,
				Duration.ofSeconds(120));
		wait.until(driver1 -> js.executeScript("return document.readyState").equals("complete"));
	}

}
