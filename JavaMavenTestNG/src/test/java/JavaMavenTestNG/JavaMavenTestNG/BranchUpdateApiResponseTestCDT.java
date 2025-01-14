package JavaMavenTestNG.JavaMavenTestNG;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ResponseReceived;
import org.openqa.selenium.devtools.v85.network.model.RequestId;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import JavaMavenTestNG.JavaMavenTestNG.ParentClass;

public class BranchUpdateApiResponseTestCDT extends ParentClass {

	
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
    public void branchUpdateVerifyApiResponseTestCDT(String data1) throws Exception {
        System.out.println(" Executing Branch Update API Response Verification...");

        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        try {
            // Enable Network Monitoring
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            devTools.addListener(Network.responseReceived(), response -> {
                String responseUrl = response.getResponse().getUrl();
                String endpointUrl = "https://www-test.republicfinance.com/qualify/api/branch/zipcode/" + data1;

                if (responseUrl.contains(endpointUrl)) {
                    System.out.println("API Matched: " + responseUrl);
                    System.out.println(" Status Code: " + response.getResponse().getStatus());
                    System.out.println(" Response Headers: " + response.getResponse().getHeaders().toString());

                    try {
                        RequestId requestId = response.getRequestId();
                        Network.GetResponseBodyResponse responseBody = devTools.send(Network.getResponseBody(requestId));
                        
                        String body = responseBody.getBody();
                        System.out.println(" Response Body: " + body);

                        if (body.contains("\"branch number\" : \"104\"")) {
                            System.out.println("The string \"branch number\" : \"104\" was found in the API response!");
                        } else {
                            System.out.println(" The string \"branch number\" : \"104\" was NOT found in the API response.");
                        }
                    } catch (Exception e) {
                        System.out.println(" Failed to get response body: " + e.getMessage());
                    }
                }
            });

            driver.get("https://www-test.republicfinance.com/apps/prequal");
            driver.manage().window().maximize();
            Thread.sleep(5000);

            // Input Zip Code
            driver.findElement(By.xpath("/html/body/form/div[4]/main/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/form/div/input"))
                  .sendKeys(data1);

            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
