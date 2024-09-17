import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

import base.Base;

class EditFunctionality extends Base{
	@BeforeAll
	static void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\SimpleForm\\\\Drivers\\\\chromedriver.exe");
		Logger.getLogger("").setLevel(Level.OFF);
		
		driver = new ChromeDriver();
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		driver.manage().window().maximize();
	}
	
	

	@Test
	@Order(11)
	void verifyEdit_TC11() throws IOException{
		
		
		
		//excel path declaration
		String filePath = "C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\AddressBookProject\\\\Data\\\\DataSource2.xlsx";

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
		
		//For loop
		for(int i=1;i<=rowCount;i++)
		{
			initialize();
			//click on edit and view
			WebElement viewAllEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
			viewAllEntry.click();
			
			//click on edit
			WebElement editB = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]/form[2]/input[3]"));
			editB.click();
			
			// Taking Value for Entry Type from excel
			entryType = sheet.getRow(i).getCell(5).getStringCellValue();
			By entryMenu = By.xpath("//*[@id=\"addr_type\"]");
			WebElement entryTypeSelector = driver.findElement(entryMenu);
			Select selectSort = new Select(entryTypeSelector);
			selectSort.selectByVisibleText(entryType);
			
			//updating value for firstname
			WebElement firstNameElement = driver.findElement(By.xpath("//*[@id=\"addr_first_name\"]"));
			String currentFirstName = firstNameElement.getAttribute("value");
			System.out.println("Value of firstNameElement at first without logic: " + currentFirstName);	
			if(sheet.getRow(i).getCell(6) != null) {
			    firstName = sheet.getRow(i).getCell(6).getStringCellValue();
				System.out.println("Value of firstNameElement at first with logic fathimaji in if part: " + firstName);	

			} else 
			{
			    firstName = currentFirstName;
				System.out.println("Value of firstNameElement in else part: " + firstName);	

			}
			
			firstNameElement.clear();
			firstNameElement.sendKeys(firstName);
			currentFirstName = firstName;
			System.out.println(currentFirstName);
			
			
			//UPDATING LASTNAME ON WEBSITE
			WebElement lastNameElement = driver.findElement(By.xpath("//*[@id=\"addr_last_name\"]"));

			// Get the value attribute of the element
			String currentLastName = lastNameElement.getAttribute("value");

			// Print the value
			System.out.println("Value of lastNameElement at first without logic: " + currentLastName);

			// Check if the corresponding cell in Excel is empty
			if (sheet.getRow(i).getCell(7) != null) 
			{
			    // If Excel cell is not empty, update lastName with the value from Excel
			    lastName = sheet.getRow(i).getCell(7).getStringCellValue();
			    System.out.println("Value of lastNameElement at first with logic: " + lastName);
			} 
			else 
			{
			    // If Excel cell is empty, keep the current value of last name
			    lastName = currentLastName;
			    System.out.println("Value of lastNameElement in else part: " + lastName);
			}

			// Clear the current value of last name
			lastNameElement.clear();

			// Send the value to the last name field on the webpage
			lastNameElement.sendKeys(lastName);

			// Update currentLastName with the final value of lastName
			currentLastName = lastName;
			System.out.println(currentLastName);
			
			
			//UPDATING BUSINESS NAME
			WebElement businessNameElement = driver.findElement(By.xpath("//*[@id=\"addr_business\"]"));

			// Get the value attribute of the element
			String currentBusinessName = businessNameElement.getAttribute("value");

			// Check if the corresponding cell in Excel is empty
			if (sheet.getRow(i).getCell(8) != null) {
			    // If Excel cell is not empty, update businessName with the value from Excel
			    businessName = sheet.getRow(i).getCell(8).getStringCellValue();
			    System.out.println("Value of business name in if: " + businessName);

			} else {
			    // If Excel cell is empty, keep the current value of business name
			    businessName = currentBusinessName;
			    System.out.println("Value of business name in else in else part: " + businessName);

			}

			// Clear the current value of business name
			businessNameElement.clear();
			
			// Send the value to the business name field on the webpage
			businessNameElement.sendKeys(businessName);

			// UPDATING ADDRESS LINE 1
			WebElement addressLine1Element = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_1\"]"));

			// Get the current value of address line 1 on the website
			String currentAddressLine1 = addressLine1Element.getAttribute("value");

			// Check if the corresponding cell in Excel is empty
			if (sheet.getRow(i).getCell(9) != null) {
			    // If Excel cell is not empty, update addressLine1 with the value from Excel
			    addressLine1 = sheet.getRow(i).getCell(9).getStringCellValue();
			    System.out.println("Value of address line 1 in if: " + addressLine1);
			} else {
			    // If Excel cell is empty, keep the current value of address line 1
			    addressLine1 = currentAddressLine1;
			    System.out.println("Value of address line 1 in else: " + addressLine1);
			}

			// Clear the current value of address line 1
			addressLine1Element.clear();

			// Send the value to the address line 1 field on the webpage
			addressLine1Element.sendKeys(addressLine1);

			
			//UPDATING ADDRESS ONE 2
			// UPDATING ADDRESS LINE 2
			WebElement addressLine2Element = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_2\"]"));

			// Get the current value of address line 2 on the website
			String currentAddressLine2 = addressLine2Element.getAttribute("value");

			// Check if the corresponding cell in Excel is empty
			if (sheet.getRow(i).getCell(10) != null) {
			    // If Excel cell is not empty, update addressLine2 with the value from Excel
			    addressLine2 = sheet.getRow(i).getCell(10).getStringCellValue();
			    System.out.println("Value of address line 2 in if: " + addressLine2);
			} else {
			    // If Excel cell is empty, keep the current value of address line 2
			    addressLine2 = currentAddressLine2;
			    System.out.println("Value of address line 2 in else: " + addressLine2);
			}

			// Clear the current value of address line 2
			addressLine2Element.clear();

			// Send the value to the address line 2 field on the webpage
			addressLine2Element.sendKeys(addressLine2);
			
			//UPDATING ADDRESS LINE 3
			WebElement addressLine3Element = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_3\"]"));

			// Get the current value of address line 3 on the website
			String currentAddressLine3 = addressLine3Element.getAttribute("value");

			// Check if the corresponding cell in Excel is empty
			if (sheet.getRow(i).getCell(11) != null) {
			    // If Excel cell is not empty, update addressLine3 with the value from Excel
			    addressLine3 = sheet.getRow(i).getCell(11).getStringCellValue();
			    System.out.println("Value of address line 3 in if: " + addressLine3);
			} else {
			    // If Excel cell is empty, keep the current value of address line 3
			    addressLine3 = currentAddressLine3;
			    System.out.println("Value of address line 3 in else: " + addressLine3);
			}

			// Clear the current value of address line 3
			addressLine3Element.clear();

			// Send the value to the address line 3 field on the webpage
			addressLine3Element.sendKeys(addressLine3);


			//UPDATING CITY
			// FOR CITY
			WebElement cityElement = driver.findElement(By.xpath("//*[@id=\"addr_city\"]"));
			// Get the current value of city on the website
			String currentCity = cityElement.getAttribute("value");
			// Check if the corresponding cell in Excel is empty
			if (sheet.getRow(i).getCell(12) != null) {
			    // If Excel cell is not empty, update city with the value from Excel
			    city = sheet.getRow(i).getCell(12).getStringCellValue();
			    System.out.println("Value of city in if: " + city);
			} else {
			    // If Excel cell is empty, keep the current value of city
			    city = currentCity;
			    System.out.println("Value of city in else: " + city);
			}

			// Clear the current value of city
			cityElement.clear();

			// Send the value to the city field on the webpage
			cityElement.sendKeys(city);
			
			
			//UPDATING PROVINCE VALUE
			WebElement provinceElement = driver.findElement(By.xpath("//*[@id=\"addr_region\"]"));

			// Get the current value of province on the website
			String currentProvince = provinceElement.getAttribute("value");

			// Check if the corresponding cell in Excel is empty
			if (sheet.getRow(i).getCell(13) != null && sheet.getRow(i).getCell(13).getCellType() != CellType.BLANK) {
			    // If Excel cell is not empty, update province with the value from Excel
			    province = sheet.getRow(i).getCell(13).getStringCellValue();
			    System.out.println("Value of province in if: " + province);
			} else {
			    // If Excel cell is empty, keep the current value of province
			    province = currentProvince;
			    System.out.println("Value of province in else: " + province);
			}

			// Clear the current value of province
			provinceElement.clear();

			// Send the value to the province field on the webpage
			provinceElement.sendKeys(province);


			// UPDATING COUNTRY VALUE
			WebElement countryElement = driver.findElement(By.xpath("//*[@id=\"addr_country\"]"));

			// Get the current value of country on the website
			String currentCountry = countryElement.getAttribute("value");

			// Check if the corresponding cell in Excel is empty
			if (sheet.getRow(i).getCell(30) != null) {
			    // If Excel cell is not empty, update Country with the value from Excel
			    Country = sheet.getRow(i).getCell(30).getStringCellValue();
			    System.out.println("Value of Country in if: " + Country);
			} else {
			    // If Excel cell is empty, keep the current value of Country
			    Country = currentCountry;
			    System.out.println("Value of Country in else: " + Country);
			}

			// Clear the current value of Country
			countryElement.clear();

			// Send the value to the Country field on the webpage
			countryElement.sendKeys(Country);

			
			//UPDATING POSTAL CODE
			WebElement postalCodeElement = driver.findElement(By.xpath("//*[@id=\"addr_post_code\"]"));

			// Get the current value of postal code on the website
			String currentPostalCode = postalCodeElement.getAttribute("value");

			// Check if the corresponding cell in Excel is empty
			if (sheet.getRow(i).getCell(14) != null) {
			    // If Excel cell is not empty, update postalCode with the value from Excel
			    postalCode = sheet.getRow(i).getCell(14).getStringCellValue();
			    System.out.println("Value of postal code in if: " + postalCode);
			} else {
			    // If Excel cell is empty, keep the current value of postal code
			    postalCode = currentPostalCode;
			    System.out.println("Value of postal code in else: " + postalCode);
			}

			// Clear the current value of postal code
			postalCodeElement.clear();

			// Send the value to the postal code field on the webpage
			postalCodeElement.sendKeys(postalCode);
			
			//UPDATING EMAIL1
			


			
		}
		
	}


}
