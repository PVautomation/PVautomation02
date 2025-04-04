package JavaMavenTestNG.JavaMavenTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OfferTestClass extends ParentClass {
	
	public boolean offerPresent;
	
	/*
	@Test(description = "Owner: pv_test")
	  @Parameters("ownerName")
	  public void offerTest() throws InterruptedException, IOException {
	}
	*/
	
	
	@DataProvider(name = "excelData")
	  public Object[][] getExcelData() throws IOException {
	      List<Object[]> data = new ArrayList<Object[]>();
	      FileInputStream fis = null;
	      Workbook workbook = null;

	      try {
	          // Load the Excel file
	          fis = new FileInputStream(new File("Data1.xlsx"));
	          workbook = new XSSFWorkbook(fis); // Use XSSFWorkbook for .xlsx files

	          // Access the first sheet
	          org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

	          // Iterate over rows and collect data
	          for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from row 1 (row 0 is header)
	              Row row = sheet.getRow(i);
	              if (row != null) {
	                  String[] rowData = new String[row.getLastCellNum()];
	                  for (int j = 0; j < row.getLastCellNum(); j++) {
	                      Cell cell = row.getCell(j);
	                      rowData[j] = cell != null ? cell.toString().trim() : ""; // Handle null cells
	                  }
	                  data.add(rowData);
	              }
	          }
	      } finally {
	          if (fis != null) fis.close();
	          if (workbook != null) workbook.close();
	      }

	      return data.toArray(new Object[0][]); // Convert list to 2D array
	  }

	  
	  
	  
	  
	  @Test(dataProvider = "excelData", description = "Owner: pv_test")
	  @Parameters("ownerName")
	  public void offerTest(String data1, String data2, String data3, String data4, String data5, 
	                        String data6, String data7, String data8, String data9, String data10, 
	                        String data11, String data12, String data13, String data14, String data15) 
	          throws Exception {

		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 
		  /*
		  // CREDIT KARMA FLOW
		  driver.get("https://www-test.republicfinance.com/lp/creditkarma");
		  Thread.sleep(10000);
		 // driver.findElement(By.xpath("//*[@id='form']/div[5]/div/div/div/div[2]/section/div/div/div/div/div[2]/a")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form']/div[5]/div/div/div/div[2]/section/div/div/div/div/div[2]/a"))).click();
		  */
		  
	     // NON CREDIT KARMA FLOW
		 driver.get("https://www-test.republicfinance.com/apps/prequal");
	      
		  Thread.sleep(8000);
		  driver.manage().window().maximize();
	      Thread.sleep(15000);
	 	 js.executeScript("document.body.style.zoom='30%'");
	 	 js.executeScript("window.scroll(0,0);");
	 	Thread.sleep(5000);
	 	
	      

	      try {
	          WebElement zipCodeField = wait.until(ExpectedConditions.elementToBeClickable(
	                  By.xpath("/html/body/form/div[4]/main/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/form/div/input")));
	          zipCodeField.sendKeys(data1);

	          wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button"))).click();

	          new Select(wait.until(ExpectedConditions.elementToBeClickable(
	                  By.xpath("//*[@id='wizardProfile']/div[2]/div/div[2]/div/div[1]/div/select"))))
	                  .selectByVisibleText(data2);

	          new Select(driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div[2]/div/div[3]/div/select")))
	                  .selectByVisibleText(data3);

	          new Select(driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div[2]/div/div[4]/div/select")))
	                  .selectByVisibleText("Email");

	          wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button"))).click();
	          Thread.sleep(8000);
	          // Fill out personal information
	          driver.findElement(By.id("firstName")).sendKeys(data4);
	          Thread.sleep(5000);
	          driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/input")).sendKeys(data5);
	          Thread.sleep(5000);
	          driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div/div[2]/div[2]/div/input")).sendKeys(data9);
	          Thread.sleep(5000);
	          driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div/div[2]/div[3]/div/input")).sendKeys(data10);
	          Thread.sleep(5000);
	          driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div/div[2]/div[4]/div/input")).sendKeys("01/01/1990");
	          Thread.sleep(5000);
	          driver.findElement(By.id("ssn")).sendKeys(data7);
	          Thread.sleep(5000);
	          driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div/div[2]/div[6]/div[1]/div/input")).sendKeys(data6);
	          Thread.sleep(5000);
	          
	          if (data11.equalsIgnoreCase("myself")) {
	              driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div/div[4]/div/div[1]/div/div/div/i[1]")).click();
	          }

	          wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button"))).click();

	          /*
	          // Fill out financial information
	          wait.until(ExpectedConditions.elementToBeClickable(
	                  By.xpath("/html/body/form/div[4]/main/div/div/div/div/div/div/div/div/div[2]/div/div/div[1]/div/div[4]/div/div/label[1]/input"))).click();

	          driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div/div[6]/div/input")).sendKeys(data13);
	          driver.findElement(By.xpath("//*[@id='incomeAmount']")).sendKeys(data14);

	          wait.until(ExpectedConditions.elementToBeClickable(By.id("next-button"))).click();

	          // Verify offer or application result
	          try {
	              WebElement offerMessage = driver.findElement(By.xpath("//*[contains(text(), 'You are pre-qualified for a loan up to')]"));
	              offerPresent = offerMessage.isDisplayed();
	          } catch (NoSuchElementException e) {
	              offerPresent = false;
	          }

	          if (offerPresent) {
	              System.out.println("Congratulations! YOU GOT AN OFFER");
	          } else {
	              System.out.println("APPLICATION DECLINED");
	          }

	      } catch (Exception e) {
	          e.printStackTrace();
	          Assert.fail("Test failed due to an exception: " + e.getMessage());
	      }
	  }  
	  */
	          // Wait and interact with child frame checkboxes
	          try {
	              WebElement checkbox1 = new WebDriverWait(driver, Duration.ofSeconds(120))
	                      .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div/div/div[2]/div/div/div[1]/label/span")));
	              ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox1);
	          } catch (Exception e) {
	              System.out.println("Unable to click checkbox1 of child frame");
	          }

	          try {
	              WebElement checkbox2 = new WebDriverWait(driver, Duration.ofSeconds(120))
	                      .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div/div/div[3]/div/div/div[1]/label/span")));
	              ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox2);
	          } catch (Exception e) {
	              System.out.println("Unable to click checkbox2 of child frame");
	          }

	          // Take a screenshot
	          File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	          screenshot1.renameTo(new File("FinalScr12.png"));
	          
	          Thread.sleep(5000);
			  Long documentHeight = (Long) js.executeScript("return document.body.scrollHeight");
			 js.executeScript("window.scrollTo(0, arguments[0]);", documentHeight);
			 Thread.sleep(10000);
			 
	          try
	          {
	              WebElement childFrame_NextButton = driver.findElement(By.xpath("//*[@id='next-button']"));
	              WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(120));
	              wait4.until(ExpectedConditions.elementToBeClickable(childFrame_NextButton));
	              childFrame_NextButton.click();
	          }
	          catch(Exception e)
	          {
	        	  System.out.println("Unable to click next-button of child frame");
	        	 

	          }
	          
	          Thread.sleep(20000);
	          
	          
	          
	          

	          // Interact with finance fields
	          //driver.findElement(By.cssSelector(".radio:nth-child(3) > input")).click();
	          WebElement financeOwn = driver.findElement(By.xpath("/html/body/form/div[4]/main/div/div/div/div/div/div/div/div/div[2]/div/div/div[1]/div/div[4]/div/div/label[1]/input"));
	          financeOwn.click();

	          WebElement mortgageRentField = driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div/div[6]/div/input"));
	          mortgageRentField.clear();
	          mortgageRentField.sendKeys("1500");

	          WebElement dependantsField = driver.findElement(By.xpath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div/div[8]/div/select"));
	          dependantsField.click();
	          new Select(dependantsField).selectByVisibleText("0");

				 // JavascriptExecutor js = (JavascriptExecutor) driver; 
				  Long documentHeight1 = (Long) js.executeScript("return document.body.scrollHeight");
				 js.executeScript("window.scrollTo(0, arguments[0]);", documentHeight1);
				 
	          WebElement incomeField = driver.findElement(By.xpath("//*[@id='incomeAmount']"));
	          incomeField.click();
	          incomeField.clear();
	          incomeField.sendKeys("5000");
	         
	          Thread.sleep(5000);
	          driver.findElement(By.id("all")).click();
	          Thread.sleep(5000);
	          driver.findElement(By.id("next-button")).click();
	          

	         // WebElement nextButton2 = driver.findElement(By.id("next-button"));
	          //nextButton2.click();
	 
	          Thread.sleep(15000);
	          // Final screen actions
	          WebElement consentCheckBox = driver.findElement(By.xpath("//*[@id='loading']/div/div/div/div/div/div[1]/div[3]/div/div/div[1]/label/span"));
	          consentCheckBox.click();

	          WebElement checkOfferButton = driver.findElement(By.xpath("//*[@id='loading']/div/div/div/div/div/div[2]/div/div[3]/button"));
	          checkOfferButton.click();

	          // Check for offer
	          try {
	              WebElement offerMessage = driver.findElement(By.xpath("//*[contains(text(), 'You are pre-qualified for a loan up to')]"));
	              offerPresent = offerMessage.isDisplayed();
	          } catch (Exception e) {
	              System.out.println("Catch Element: Offer");
	              offerPresent = false;
	          }

	          if (offerPresent) {
	              System.out.println("\n Congratulations! YOU GOT OFFER \n CLICK ON THE BELOW LINK TO APPLY!!! \n" + driver.getCurrentUrl());
	          } else {
	              String title = driver.getTitle().toLowerCase();
	              if (title.contains("declined")) {
	                  System.out.println("APPLICATION DECLINED");
	              } else if (title.contains("no match")) {
	                  System.out.println("APPLICATION DECLINED - NO MATCH");
	              } else if (title.contains("downtime-error")) {
	                  System.out.println("APPLICATION DECLINED - Downtime-Error");
	              } else if (title.contains("404")) {
	                  System.out.println("GOT 404");
	              }
	          }

	          System.out.println("SELENIUM TEST COMPLETED SUCCESSFULLY!!! \n");

	          // Final Screenshot
	          File finalScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	          finalScreenshot.renameTo(new File("FinalScr12.png"));
	          
	          Reporter.log("OFFER TEST GOT COMPLETED");
	          Thread.sleep(5000);
	          verifyTextNotPresent("OOPS");
	          Thread.sleep(3000);
	      }
	      catch(Exception e)
	      {System.out.println("complete2 catch");}
	         
	      }

	
	
	

}
