package JavaMavenTestNG.JavaMavenTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoanCalculatorTestClass extends ParentClass  {
	
	
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
	          org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(6);

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
	  public void loanCalculatorTest(String data1, String data2, String data3, String data4) throws InterruptedException, IOException {
		

	    driver.get("https://www-test.republicfinance.com/monthly-payment-calculator");
	    Thread.sleep(4000);
		 js.executeScript("document.body.style.zoom='30%'");
		 js.executeScript("window.scroll(0,0);"); 
	    driver.findElement(By.id("field-5")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("field-5")).clear();
	    Thread.sleep(2000);
	    driver.findElement(By.id("field-5")).sendKeys(data1);
	    Thread.sleep(8000);
	    driver.findElement(By.xpath("//select[@id='field-5']")).click();
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.xpath("//select[@id='field-5']"))).selectByVisibleText(data2);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div/div/form/div/div/div[3]/div/select")).click();
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div/div/form/div/div/div[3]/div/select"))).selectByVisibleText(data3);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div/div/form/div/div/div[4]/div/select")).click();
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div/div/form/div/div/div[4]/div/select"))).selectByVisibleText(data4);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(4000);
	   // driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div[2]/div/div/p[3]")).click();
	    //Warning: assertTextPresent may require manual changes
	   // Thread.sleep(15000);
	    //assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*xpath=//div\\[@id='root'\\]/div/div/div/div/div/div\\[2\\]/div/div/p\\[3\\][\\s\\S]*$"));
	   // Thread.sleep(3000);
	    verifyTextPresent("This will not affect your credit score");
	    		//"$159");
	    System.out.println("complete1");
	    //Assert.assertEquals(true, true, "Assertion Success: Expected value matched the actual value.");
	    Reporter.log("LOAN CALCULATOR TEST GOT COMPLETED<br>");
	  
	
	}

}
