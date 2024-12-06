package JavaMavenTestNG.JavaMavenTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import JavaMavenTestNG.JavaMavenTestNG.Test1;

public class NewTest extends Test1  {
  @Test
  public void test1() throws InterruptedException {
	  driver.get("https://secure-test.republicfinance.com/apps/account/login");
	  WebElement username=driver.findElement(By.id("username"));
	  WebElement password=driver.findElement(By.id("password"));
	  WebElement login=driver.findElement(By.xpath("//*[@id='signInButton']")); 
	  username.sendKeys("pv12324a01@yopmail.com");
	  password.sendKeys("P@ssword123");
	  login.click();
	  Thread.sleep(60000);
	  WebElement expected = driver.findElement(By.xpath("//*[text()='Account Summary']"));
	  if(expected.isDisplayed())
	  {System.out.println("login confirmed");}
	  System.out.println("test1 outside if condition");
	  Assert.assertTrue(expected.isDisplayed());
	  System.out.println("test1 outside assert condition");
	  }
  
  @Test
  public void test2() {
	  System.out.println("test2");
	 
	  Assert.assertTrue(true, "Test pass");
  }
  
  @Test
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
