package JavaMavenTestNG.JavaMavenTestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoanCalculatorTestClass extends ParentClass  {
	@Test(description = "Owner: pv_test")
	  @Parameters("ownerName")
	  public void loanCalculatorTest() throws InterruptedException, IOException {
		

	    driver.get("https://www-test.republicfinance.com/monthly-payment-calculator");
	    Thread.sleep(8000);
		 js.executeScript("document.body.style.zoom='30%'");
		 js.executeScript("window.scroll(0,0);"); 
	    driver.findElement(By.id("field-5")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("field-5")).clear();
	    Thread.sleep(2000);
	    driver.findElement(By.id("field-5")).sendKeys("78748");
	    Thread.sleep(8000);
	    driver.findElement(By.xpath("//select[@id='field-5']")).click();
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.xpath("//select[@id='field-5']"))).selectByVisibleText("$2001-$3000");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div/div/form/div/div/div[3]/div/select")).click();
	    Thread.sleep(3000);
	    new Select(driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div/div/form/div/div/div[3]/div/select"))).selectByVisibleText("24 months");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div/div/form/div/div/div[4]/div/select")).click();
	    Thread.sleep(3000);
	    new Select(driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div/div/form/div/div/div[4]/div/select"))).selectByVisibleText("500-599 (Fair)");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(15000);
	   // driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div[2]/div/div/p[3]")).click();
	    //Warning: assertTextPresent may require manual changes
	   // Thread.sleep(15000);
	    //assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*xpath=//div\\[@id='root'\\]/div/div/div/div/div/div\\[2\\]/div/div/p\\[3\\][\\s\\S]*$"));
	    Thread.sleep(3000);
	    verifyTextPresent("$159");
	    System.out.println("complete1");
	    //Assert.assertEquals(true, true, "Assertion Success: Expected value matched the actual value.");
	    Reporter.log("LOAN CALCULATOR TEST GOT COMPLETED");
	  
	
	}

}
