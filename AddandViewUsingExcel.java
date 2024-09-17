import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

import base.Base;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import static org.junit.Assert.assertEquals;

/* In this test we have created automation scripts when the Entry type is Business and 
 * In order to optimize our code we have used a technique
 * where we will be getting data from an external excel.
 * @Test 1 had Add funtionality 20 test cases and @Test 2 has view functionality 1 test case
 * */

/*PreInstructions before running the test - Change the webdrive path (Line 43) and excel path (Line 64) in the file according to your path.*/

class AddandViewUsingExcel extends Base{
	static WebDriver driver;

	@BeforeAll
	static void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\SimpleForm\\\\Drivers\\\\chromedriver.exe");
		Logger.getLogger("").setLevel(Level.OFF);
		
		driver = new ChromeDriver();
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		driver.manage().window().maximize();

	} 
	public static void takesnapshot(String name) {
		 if (driver != null) {
	         // Capture screenshot
	         File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	         try {
	             // Save the screenshot
	             FileUtils.copyFile(screenshotFile, new File(".//Screenshots//" + name + ".png"));
	             System.out.println("Screenshot captured successfully.");
	         } catch (IOException e) {
	             System.out.println("Failed to capture screenshot: " + e.getMessage());
	         }
	     } else {
	         System.out.println("Driver is null. Cannot capture screenshot.");
	     }
	}
	
	
	@Test
	@Order(1)
	void testAdd() throws IOException, InterruptedException
	{
		String URL = "http://localhost/addressbook/index.php";
		driver.get(URL);
		String title = driver.getTitle();
		takesnapshot("testAdd_1");

		System.out.println("The Title of my page is: " + title);
		System.out.println("The current URL is: " + driver.getCurrentUrl());
		String filePath = "C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\AddressBookProject\\\\Data\\\\DataSource.xlsx";

		FileInputStream inputStream = new FileInputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		System.out.println(rowCount);
		int flag = 0;
		String testType;
		String expectedErrorMessage;
		String testStatus;
		String testFailureReason = "NA";
		String tcId;
		String tcName;
		String entryType;
		String firstName;
		String lastName;
		String businessName;
		String addressLine1;
		String addressLine2;
		String addressLine3;
		String city;
		String province;
		String postalCode;
		String Country;
		String email1;
		String email2;
		String email3;
		String phone1Type;
		String phone1No;
		String phone2Type;
		String phone2No;
		String phone3Type;
		String phone3No;
		String website1;
		String website2;
		String website3;
		

		for(int i=1;i<=rowCount;i++)
		{
			driver.get("http://localhost/addressbook/index.php");
			
			tcId = sheet.getRow(i).getCell(0).getStringCellValue();

			driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a")).click();
			entryType = sheet.getRow(i).getCell(5).getStringCellValue();
			By entryMenu = By.xpath("//*[@id=\"addr_type\"]");
			WebElement entryTypeSelector = driver.findElement(entryMenu);
			Select selectSort = new Select(entryTypeSelector);
			selectSort.selectByVisibleText(entryType);
			takesnapshot("testAdd_2");
			if(sheet.getRow(i).getCell(6) == null)
			{
				firstName = "";
			}
			else
			{
				firstName = sheet.getRow(i).getCell(6).getStringCellValue();

			}
			driver.findElement(By.xpath("//*[@id=\"addr_first_name\"]")).sendKeys(firstName);
			
			Thread.sleep(1000);
			
			if(sheet.getRow(i).getCell(7) == null)
			{
				lastName = "";
			}
			else
			{
				lastName = sheet.getRow(i).getCell(7).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_last_name\"]")).sendKeys(lastName);
			
			if(sheet.getRow(i).getCell(8) == null)
			{
				businessName = "";
			}
			else
			{
				businessName = sheet.getRow(i).getCell(8).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_business\"]")).sendKeys(businessName);
			
// FOR ADDRESS 1
			if(sheet.getRow(i).getCell(9) == null)
			{
				addressLine1 = "";
			}
			else
			{
				addressLine1 = sheet.getRow(i).getCell(9).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_addr_line_1\"]")).sendKeys(addressLine1);
			
			//addressLine1 = sheet.getRow(i).getCell(9).getStringCellValue();
			//driver.findElement(By.xpath("//*[@id=\"addr_addr_line_1\"]")).sendKeys(addressLine1);
			
			// FOR ADDRESS 2
			if(sheet.getRow(i).getCell(10) == null)
			{
				addressLine2 = "";
			}
			else
			{
				addressLine2 = sheet.getRow(i).getCell(10).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_addr_line_2\"]")).sendKeys(addressLine2);

			//addressLine2 = sheet.getRow(i).getCell(10).getStringCellValue();
			//driver.findElement(By.xpath("//*[@id=\"addr_addr_line_2\"]")).sendKeys(addressLine2);
			
			//FOR ADDRESS 3
			
			if(sheet.getRow(i).getCell(11) == null)
			{
				addressLine3 = "";
			}
			else
			{
				addressLine3 = sheet.getRow(i).getCell(11).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_addr_line_3\"]")).sendKeys(addressLine3);

			//addressLine3 = sheet.getRow(i).getCell(11).getStringCellValue();
			//driver.findElement(By.xpath("//*[@id=\"addr_addr_line_3\"]")).sendKeys(addressLine3);
			
			
			// FOR CITY
			if(sheet.getRow(i).getCell(12) == null)
			{
				city = "";
			}
			else
			{
				city = sheet.getRow(i).getCell(12).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_city\"]")).sendKeys(city);
			
			//city = sheet.getRow(i).getCell(12).getStringCellValue();
			//driver.findElement(By.xpath("//*[@id=\"addr_city\"]")).sendKeys(city);
			
			//FOR PROVINCE
			if(sheet.getRow(i).getCell(13) == null)
			{
				province = "";
			}
			else
			{
				province = sheet.getRow(i).getCell(13).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_region\"]")).sendKeys(province);
			
			//province = sheet.getRow(i).getCell(13).getStringCellValue();
			//driver.findElement(By.xpath("//*[@id=\"addr_region\"]")).sendKeys(province);
			
			//For COUNTRY
			if(sheet.getRow(i).getCell(30) == null)
			{
				Country = "";
			}
			else
			{
				Country = sheet.getRow(i).getCell(30).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_country\"]")).sendKeys(Country);
			
			//FOR POSTAL CODE
			if(sheet.getRow(i).getCell(14) == null)
			{
				postalCode = "";
			}
			else
			{
				postalCode = sheet.getRow(i).getCell(14).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_post_code\"]")).sendKeys(postalCode);
			
			//postalCode = sheet.getRow(i).getCell(14).getStringCellValue();
			//driver.findElement(By.xpath("//*[@id=\"addr_post_code\"]")).sendKeys(postalCode);

			//FOR EMAIL1
			if(sheet.getRow(i).getCell(15) == null)
			{
				email1 = "";
			}
			else
			{
				email1 = sheet.getRow(i).getCell(15).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_email_1\"]")).sendKeys(email1);
			//email1 = sheet.getRow(i).getCell(15).getStringCellValue();
			//driver.findElement(By.xpath("//*[@id=\"addr_email_1\"]")).sendKeys(email1);

			//FOR EMAIL2
			if(sheet.getRow(i).getCell(16) == null)
			{
				email2 = "";
			}
			else
			{
				email2 = sheet.getRow(i).getCell(16).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_email_2\"]")).sendKeys(email2);
			
			//email2 = sheet.getRow(i).getCell(16).getStringCellValue();
			//driver.findElement(By.xpath("//*[@id=\"addr_email_2\"]")).sendKeys(email2);
			
			//FOR EMAIL3
			if(sheet.getRow(i).getCell(17) == null)
			{
				email3 = "";
			}
			else
			{
				email3 = sheet.getRow(i).getCell(17).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_email_3\"]")).sendKeys(email3);
			
			//email3 = sheet.getRow(i).getCell(17).getStringCellValue();
			//driver.findElement(By.xpath("//*[@id=\"addr_email_3\"]")).sendKeys(email3);
			
			//For PHONE TYPE 1
			phone1Type = sheet.getRow(i).getCell(18).getStringCellValue();
			By phoneMenu = By.xpath("//*[@id=\"addr_phone_1_type\"]");
			WebElement phoneType1 = driver.findElement(phoneMenu);
			Select phoneSort = new Select(phoneType1);
			phoneSort.selectByVisibleText(phone1Type);
			
			//FOR PHONE NO. 1
			if(sheet.getRow(i).getCell(19) == null)
			{
				phone1No = "";
			}
			else
			{
				phone1No = sheet.getRow(i).getCell(19).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_phone_1\"]")).sendKeys(phone1No);
			
			//FOR PHONE TYPE 2
			phone2Type = sheet.getRow(i).getCell(20).getStringCellValue();
			By phoneMenu2 = By.xpath("//*[@id=\"addr_phone_2_type\"]");
			WebElement phoneType2 = driver.findElement(phoneMenu2);
			Select phoneSort2 = new Select(phoneType2);
			phoneSort2.selectByVisibleText(phone2Type);
			
			//FOR PHONE NO. 2
			if(sheet.getRow(i).getCell(21) == null)
			{
				phone2No = "";
			}
			else
			{
				phone2No = sheet.getRow(i).getCell(21).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_phone_2\"]")).sendKeys(phone2No);
			
			//FOR PHONE TYPE 3
			phone3Type = sheet.getRow(i).getCell(22).getStringCellValue();
			By phoneMenu3 = By.xpath("//*[@id=\"addr_phone_3_type\"]");
			WebElement phoneType3 = driver.findElement(phoneMenu3);
			Select phoneSort3 = new Select(phoneType3);
			phoneSort3.selectByVisibleText(phone3Type);
			
			//FOR PHONE NO 3
			if(sheet.getRow(i).getCell(23) == null)
			{
				phone3No = "";
			}
			else
			{
				phone3No = sheet.getRow(i).getCell(23).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_phone_3\"]")).sendKeys(phone3No);
			
			//For Website 1
			if(sheet.getRow(i).getCell(24) == null)
			{
				website1 = "";
			}
			else
			{
				website1 = sheet.getRow(i).getCell(24).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_web_url_1\"]")).sendKeys(website1);
			
			//FOR WEBSITE 2
			if(sheet.getRow(i).getCell(25) == null)
			{
				website2 = "";
			}
			else
			{
				website2 = sheet.getRow(i).getCell(25).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_web_url_2\"]")).sendKeys(website2);
			
			//FOR WEBSITE 3
			if(sheet.getRow(i).getCell(26) == null)
			{
				website3 = "";
			}
			else
			{
				website3 = sheet.getRow(i).getCell(26).getStringCellValue();
			}
			driver.findElement(By.xpath("//*[@id=\"addr_web_url_3\"]")).sendKeys(website3);
			
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"submit_button\"]")).click();
			takesnapshot("testAdd_3");
			testType = sheet.getRow(i).getCell(3).getStringCellValue();
			if(testType.equals("Positive"))
			{
				try
				{
					WebElement message = driver.findElement(By.xpath("/html/body/form/div/h2"));

					//System.out.println(message.getText());
					Assert.assertTrue(message.isDisplayed());
					//assertEquals("The new address book entry was added successfully",message.getText());	
			        System.out.println("Test Case Passed for test case id - "+tcId);
			        flag =1;
			        Thread.sleep(1000);
			        
					driver.findElement(By.xpath("/html/body/form/div/input")).click();

				}
				catch(Exception errorReason)
				{
				flag = 0;
				testFailureReason = errorReason.getMessage();
				System.out.println("Test Case Failed for test case id- "+tcId);

				}
				catch(AssertionError errorReason)
				{
				flag = 0;

				testFailureReason = errorReason.getMessage();
				}

			}
			else
			{
				try
				{
					WebElement actualErrorMessage = driver.findElement(By.tagName("p"));
					takesnapshot("testAdd_4");
					//System.out.println(actualErrorMessage.getText());
					//System.out.println("Test Case Failed for test case id - "+tcId);
					
					expectedErrorMessage = sheet.getRow(i).getCell(27).getStringCellValue();
					
					Assert.assertEquals(expectedErrorMessage, actualErrorMessage.getText());
					System.out.println("Test Case Passed for test case id - "+tcId);
					flag=1;
					}
					catch(Exception errorReason)
					{
						/*flag = 0;

						testFailureReason = errorReason.getMessage();*/
						
						flag = 0;
						testFailureReason = errorReason.getMessage();
						System.out.println("Test Case Failed for test case id - "+tcId);
					}
					catch(AssertionError errorReason)
					{
						flag = 0;

						testFailureReason = errorReason.getMessage();
					}
				

			}
			Cell statusCell = sheet.getRow(i).createCell(28);
			Cell rca = sheet.getRow(i).createCell(29);

			//if(failureReason.equals("NA"))

			if(flag==1)
			{
			statusCell.setCellValue("Passed");
			rca.setCellValue(testFailureReason);
			}
			else
			{
			statusCell.setCellValue("Failed");
			rca.setCellValue(testFailureReason);
			} 

			FileOutputStream outputStream = new FileOutputStream(filePath);
			workbook.write(outputStream);
			

		}			
	}
	
	@Test
	@Order(2)
	void testView() throws IOException, InterruptedException{
		String URL = "http://localhost/addressbook/index.php";
		//driver.get(URL);
		driver.get("http://localhost/addressbook/index.php");
		String title = driver.getTitle();
		System.out.println("The Title of my page is: " + title);
		System.out.println("The current URL is: " + driver.getCurrentUrl());	
		driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]/form[1]/input[2]")).click();
		WebElement text = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[2]"));
		System.out.println(text.getText());
		Assert.assertTrue(text.isDisplayed());
		takesnapshot("testView_1");
		driver.close();
				
	}
	
}
