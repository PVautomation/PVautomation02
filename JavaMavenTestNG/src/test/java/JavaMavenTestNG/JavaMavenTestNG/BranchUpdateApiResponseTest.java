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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchUpdateApiResponseTest extends ParentClass {

	
	@DataProvider(name = "excelData1")
	  public Object[][] getExcelData() throws IOException {
	      List<Object[]> data = new ArrayList<Object[]>();
	      FileInputStream fis = null;
	      Workbook workbook = null;

	      try {
	          // Load the Excel file
	          fis = new FileInputStream(new File("Data1.xlsx"));
	          workbook = new XSSFWorkbook(fis); // Use XSSFWorkbook for .xlsx files

	          // Access the first sheet
	          org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(7);

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

	
	
	
	   @Test(dataProvider = "excelData1", description = "Owner: pv_test")
	    public void branchUpdateVerifyApiResponseTest(String data1) throws Exception {

	        System.out.println(" Executing Branch Update API Response Verification...");

	        try {
	            driver.get("https://www-test.republicfinance.com/apps/prequal");
	            driver.manage().window().maximize();
	            Thread.sleep(5000);

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	            // Enter Zip Code
	            WebElement zipCodeField = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("/html/body/form/div[4]/main/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/form/div/input")));
	            zipCodeField.sendKeys(data1);

	            Thread.sleep(10000);

	            // JavaScript Snippet with Dynamic Data Injection
	           // JavascriptExecutor js = (JavascriptExecutor) driver;

	            String script = "(function(apiEndpoint) {\n"
	                    + "    // Intercept XMLHttpRequest\n"
	                    + "    let open = XMLHttpRequest.prototype.open;\n"
	                    + "    XMLHttpRequest.prototype.open = function() {\n"
	                    + "        this.addEventListener('load', function() {\n"
	                    + "            console.log('📡 API Request (XHR): ', this.responseURL);\n"
	                    + "            if (this.responseURL.includes(apiEndpoint)) {\n"
	                    + "                console.log(' API Matched (XHR): ', this.responseURL);\n"
	                    + "                console.log(' Response (XHR):', this.responseText);\n"
	                    + "                window.apiResponse = this.responseText;\n"
	                    + "                if (this.responseText.includes('\"branch number\" : \"104\"')) {\n"
	                    + "                    window.stringFound = true;\n"
	                    + "                } else {\n"
	                    + "                    window.stringFound = false;\n"
	                    + "                }\n"
	                    + "            }\n"
	                    + "        });\n"
	                    + "        open.apply(this, arguments);\n"
	                    + "    };\n"
	                    + "\n"
	                    + "    // Intercept fetch()\n"
	                    + "    let originalFetch = window.fetch;\n"
	                    + "    window.fetch = function() {\n"
	                    + "        return originalFetch.apply(this, arguments).then(response => {\n"
	                    + "            let clonedResponse = response.clone();\n"
	                    + "            clonedResponse.text().then(text => {\n"
	                    + "                console.log('📡 API Request (fetch): ', response.url);\n"
	                    + "                if (response.url.includes(apiEndpoint)) {\n"
	                    + "                    console.log('API Matched (fetch): ', response.url);\n"
	                    + "                    console.log(' Response (fetch):', text);\n"
	                    + "                    window.apiResponse = text;\n"
	                    + "                    if (text.includes('\"branch number\" : \"104\"')) {\n"
	                    + "                        window.stringFound = true;\n"
	                    + "                    } else {\n"
	                    + "                        window.stringFound = false;\n"
	                    + "                    }\n"
	                    + "                }\n"
	                    + "            });\n"
	                    + "            return response;\n"
	                    + "        });\n"
	                    + "    };\n"
	                    + "})(arguments[0]);";
	            
	            // Pass `data1` dynamically to JavaScript
	            String apiEndpoint = "https://www-test.republicfinance.com/qualify/api/branch/zipcode/" + data1;
	            js.executeScript(script, apiEndpoint);

	            Thread.sleep(10000); 
	            // Retrieve results from JavaScript global variables
	            String apiResponse = (String) js.executeScript("return window.apiResponse;");
	            Boolean stringFound = (Boolean) js.executeScript("return window.stringFound;");

	            // Debugging Console Logs
	            System.out.println(" JavaScript Global Variable [apiResponse]: " + apiResponse);
	            System.out.println(" JavaScript Global Variable [stringFound]: " + stringFound);

	            if (apiResponse != null) {
	                System.out.println(" Captured API Response: " + apiResponse);
	            } else {
	                System.out.println(" API Response not captured. Ensure the endpoint is called.");
	            }

	            if (Boolean.TRUE.equals(stringFound)) {
	                System.out.println("The string \"branch number\" : \"104\" was found in the API response!");
	            } else {
	                System.out.println(" The string \"branch number\" : \"104\" was NOT found in the API response.");
	            }

	        } catch (Exception e) {
	            System.err.println("Exception caught: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }


}
