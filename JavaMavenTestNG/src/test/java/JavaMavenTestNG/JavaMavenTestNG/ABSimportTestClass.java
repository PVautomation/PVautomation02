
package JavaMavenTestNG.JavaMavenTestNG;

import JavaMavenTestNG.JavaMavenTestNG.CRMtestClass;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;


public class ABSimportTestClass extends ParentClass  {
	@Test(description = "Owner: pv_test")
  @Parameters("ownerName")
  public void ABSimportTest() throws InterruptedException, IOException {
	  //Test1 t = new Test1();
	  //t.setup();
	  driver.get("https://secure-test.republicfinance.com/apps/account/login");
	  WebElement username=driver.findElement(By.id("username"));
	  WebElement password=driver.findElement(By.id("password"));
	  WebElement login=driver.findElement(By.xpath("//*[@id='signInButton']")); 
	  username.sendKeys("pv12324a01@yopmail.com");
	  password.sendKeys("P@ssword123");
	  login.click();
	  //Thread.sleep(20000);
	  //driver.navigate().refresh();
	  Thread.sleep(50000);
	  verifyTextPresent("Account Number: 9-106032-79875");
	  /*
	  WebElement expected = driver.findElement(By.xpath("//*[text()='Account Summary']"));
	  if(expected.isDisplayed())
	  {System.out.println("login confirmed");}
	  System.out.println("test1 outside if condition");
	  Assert.assertTrue(expected.isDisplayed());
	  */
	  Thread.sleep(3000);
	  Reporter.log("ABS IMPORT GOT COMPLETED");
	  System.out.println("test1 outside assert condition");
	  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//String path = System.getProperty("user.dir") + "/screenshot.png"; // Save relative to the project root
	String path = System.getenv("Build.ArtifactStagingDirectory") + "/screenshot1.png";
	FileUtils.copyFile(screenshot, new File(path));
	Thread.sleep(3000);
	  System.out.println("screenshot1");
	  }
  
 @Test(description = "Owner: pv_test")
  @Parameters("ownerName")
  public void test2() {
	  System.out.println("test2");
	 
	  Assert.assertTrue(true, "Test pass");
  }
  
 @Test(description = "Owner: pv_test")
  @Parameters("ownerName")
  public void test3() {
	  System.out.println("test3");
	  Assert.assertTrue(true, "Test pass");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

}

