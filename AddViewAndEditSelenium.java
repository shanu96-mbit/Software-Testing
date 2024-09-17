import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.jupiter.api.*;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;



import base.Base;

/* In this test we have created automation scripts when the Entry types are family,friend and Other 
 * @Test 1 to 16 are focus on entry type Family, @Test 17 to 23 are focus on Friend and @Test 24 to 30 are focus on Other 
 * */

/*PreInstructions before running the test - Change the webdrive path in Base.java file*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddViewAndEditSelenium extends Base {

		// @Test 1 to 16  are written while selecting Family from entry type drop down.
		//Test Case 1 : URL Loaded Successfully
		@Test
		@Order(1)
		void testLoading_TC1(){
			
			initialize();
			
			String expected_title = driver.getTitle();
			assertEquals("Address Book",expected_title);
			takesnapshot("testLoading_TC1");	
			
			driver.quit();
		}

		
		//Test Case 2 : Add data without adding either fistName,Last Name or Bussines Name
		@Test
		@Order(2)
		void addInvalid_TC2_submitWithoutMadatoryFieldNames(){
			
			initialize();
			
			WebElement addNewEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
			addNewEntry.click();
			
			WebElement entryType = driver.findElement(By.name("addr_type"));
			Select entryTypedropdown = new Select(entryType);
			entryTypedropdown.selectByVisibleText("Family");
			
			WebElement firstName = driver.findElement(By.xpath("//*[@id=\"addr_first_name\"]"));
			firstName.sendKeys("");
			
			WebElement lastName = driver.findElement(By.xpath("//*[@id=\"addr_last_name\"]"));
			lastName.sendKeys("");
			
			WebElement businessName = driver.findElement(By.xpath("//*[@id=\"addr_business\"]"));
			businessName.sendKeys("");
			
			WebElement addressLine1 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_1\"]"));
			addressLine1.sendKeys("88");
			
			WebElement addressLine2 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_2\"]"));
			addressLine2.sendKeys("Edgevally");
			
			WebElement addressLine3 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_3\"]"));
			addressLine3.sendKeys("Adelaid");
			
			WebElement city = driver.findElement(By.xpath("//*[@id=\"addr_city\"]"));
			city.sendKeys("London");
			
			WebElement province = driver.findElement(By.xpath("//*[@id=\"addr_region\"]"));
			province.sendKeys("Ontario");
			
			WebElement country = driver.findElement(By.xpath("//*[@id=\"addr_country\"]"));
			country.sendKeys("Canada");
			
			WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"addr_post_code\"]"));
			postalCode.sendKeys("NC5 ODS");
			
			WebElement email1 = driver.findElement(By.xpath("//*[@id=\"addr_email_1\"]"));
			email1.sendKeys("shana1@gmail.com");
			
			WebElement email2 = driver.findElement(By.xpath("//*[@id=\"addr_email_2\"]"));
			email2.sendKeys("shana2@gmail.com");
			
			WebElement email3 = driver.findElement(By.xpath("//*[@id=\"addr_email_3\"]"));
			email3.sendKeys("shana3@gmail.com");
			
			WebElement phone_1_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_1_type\"]"));
			Select phone_1_typedropdown = new Select(phone_1_type);
			phone_1_typedropdown.selectByVisibleText("Home");
			
			WebElement phone_1_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_1\"]"));
			phone_1_number.sendKeys("1234567890");
			
			WebElement phone_2_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_2_type\"]"));
			Select phone_2_typedropdown = new Select(phone_2_type);
			phone_2_typedropdown.selectByVisibleText("Work");
			
			WebElement phone_2_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_2\"]"));
			phone_2_number.sendKeys("0987654321");
			
			WebElement phone_3_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_3_type\"]"));
			Select phone_3_typedropdown = new Select(phone_3_type);
			phone_3_typedropdown.selectByVisibleText("Mobile");
			
			WebElement phone_3_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_3\"]"));
			phone_3_number.sendKeys("34567823456");
			
			WebElement webSite1 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_1\"]"));
			webSite1.sendKeys("www.google.com");
			
			WebElement webSite2 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_2\"]"));
			webSite2.sendKeys("www.yahoo.com");
			
			WebElement webSite3 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_3\"]"));
			webSite3.sendKeys("www.lfx.com");
			
			WebElement saveAddress = driver.findElement(By.xpath("//*[@id=\"submit_button\"]"));
			saveAddress.click();
			
			WebElement expectedResult = driver.findElement(By.xpath("/html/body/p"));
			expectedResult.getText();
			assertEquals("An person's name or business name must be specified.",expectedResult.getText());
			
			takesnapshot("addInvalid_TC2");
			
			driver.quit();
		}
		
		//Test Case 3 : Add only fistName,Last Name and Bussines Name and Save without adding other mandatory fields
		@Test
		@Order(3)
		void addInvalid_TC3_submitWithOnlyWithNameDetails(){
			
			initialize();
			
			WebElement addNewEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
			addNewEntry.click();
			
			WebElement entryType = driver.findElement(By.name("addr_type"));
			Select entryTypedropdown = new Select(entryType);
			entryTypedropdown.selectByVisibleText("Family");
			
			WebElement firstName = driver.findElement(By.xpath("//*[@id=\"addr_first_name\"]"));
			firstName.sendKeys("Shana");
			
			WebElement lastName = driver.findElement(By.xpath("//*[@id=\"addr_last_name\"]"));
			lastName.sendKeys("Moha");
			
			WebElement businessName = driver.findElement(By.xpath("//*[@id=\"addr_business\"]"));
			businessName.sendKeys("LDX");
			
			WebElement addressLine1 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_1\"]"));
			addressLine1.sendKeys("");
			
			WebElement addressLine2 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_2\"]"));
			addressLine2.sendKeys("");
			
			WebElement addressLine3 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_3\"]"));
			addressLine3.sendKeys("");
			
			WebElement city = driver.findElement(By.xpath("//*[@id=\"addr_city\"]"));
			city.sendKeys("");
			
			WebElement province = driver.findElement(By.xpath("//*[@id=\"addr_region\"]"));
			province.sendKeys("");
			
			WebElement country = driver.findElement(By.xpath("//*[@id=\"addr_country\"]"));
			country.sendKeys("");
			
			WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"addr_post_code\"]"));
			postalCode.sendKeys("");
			
			WebElement email1 = driver.findElement(By.xpath("//*[@id=\"addr_email_1\"]"));
			email1.sendKeys("");
			
			WebElement email2 = driver.findElement(By.xpath("//*[@id=\"addr_email_2\"]"));
			email2.sendKeys("");
			
			WebElement email3 = driver.findElement(By.xpath("//*[@id=\"addr_email_3\"]"));
			email3.sendKeys("");
			
			WebElement phone_1_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_1_type\"]"));
			Select phone_1_typedropdown = new Select(phone_1_type);
			phone_1_typedropdown.selectByVisibleText("Home");
			
			WebElement phone_1_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_1\"]"));
			phone_1_number.sendKeys("");
			
			WebElement phone_2_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_2_type\"]"));
			Select phone_2_typedropdown = new Select(phone_2_type);
			phone_2_typedropdown.selectByVisibleText("Work");
			
			WebElement phone_2_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_2\"]"));
			phone_2_number.sendKeys("");
			
			WebElement phone_3_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_3_type\"]"));
			Select phone_3_typedropdown = new Select(phone_3_type);
			phone_3_typedropdown.selectByVisibleText("Mobile");
			
			WebElement phone_3_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_3\"]"));
			phone_3_number.sendKeys("");
			
			WebElement webSite1 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_1\"]"));
			webSite1.sendKeys("");
			
			WebElement webSite2 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_2\"]"));
			webSite2.sendKeys("");
			
			WebElement webSite3 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_3\"]"));
			webSite3.sendKeys("");
			
			WebElement saveAddress = driver.findElement(By.xpath("//*[@id=\"submit_button\"]"));
			saveAddress.click();
			
			WebElement expectedResult = driver.findElement(By.xpath("/html/body/p"));
			expectedResult.getText();
			assertEquals("At least one of the following must be entered: street/mailing address, email address, phone number or web site url.",expectedResult.getText());
			
			takesnapshot("addInvalid_TC3");
			
			driver.quit();
			
		}
		
				//Test Case 4 : Submit an Empty Form
				@Test
				@Order(4)
				void addInvalid_TC4_submitEmptyForm(){
					
					initialize();
					
					WebElement addNewEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					addNewEntry.click();
					
					WebElement entryType = driver.findElement(By.name("addr_type"));
					Select entryTypedropdown = new Select(entryType);
					entryTypedropdown.selectByVisibleText("Family");
					
					WebElement firstName = driver.findElement(By.xpath("//*[@id=\"addr_first_name\"]"));
					firstName.sendKeys("");
					
					WebElement lastName = driver.findElement(By.xpath("//*[@id=\"addr_last_name\"]"));
					lastName.sendKeys("");
					
					WebElement businessName = driver.findElement(By.xpath("//*[@id=\"addr_business\"]"));
					businessName.sendKeys("");
					
					WebElement addressLine1 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_1\"]"));
					addressLine1.sendKeys("");
					
					WebElement addressLine2 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_2\"]"));
					addressLine2.sendKeys("");
					
					WebElement addressLine3 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_3\"]"));
					addressLine3.sendKeys("");
					
					WebElement city = driver.findElement(By.xpath("//*[@id=\"addr_city\"]"));
					city.sendKeys("");
					
					WebElement province = driver.findElement(By.xpath("//*[@id=\"addr_region\"]"));
					province.sendKeys("");
					
					WebElement country = driver.findElement(By.xpath("//*[@id=\"addr_country\"]"));
					country.sendKeys("");
					
					WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"addr_post_code\"]"));
					postalCode.sendKeys("");
					
					WebElement email1 = driver.findElement(By.xpath("//*[@id=\"addr_email_1\"]"));
					email1.sendKeys("");
					
					WebElement email2 = driver.findElement(By.xpath("//*[@id=\"addr_email_2\"]"));
					email2.sendKeys("");
					
					WebElement email3 = driver.findElement(By.xpath("//*[@id=\"addr_email_3\"]"));
					email3.sendKeys("");
					
					WebElement phone_1_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_1_type\"]"));
					Select phone_1_typedropdown = new Select(phone_1_type);
					phone_1_typedropdown.selectByVisibleText("Home");
					
					WebElement phone_1_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_1\"]"));
					phone_1_number.sendKeys("");
					
					WebElement phone_2_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_2_type\"]"));
					Select phone_2_typedropdown = new Select(phone_2_type);
					phone_2_typedropdown.selectByVisibleText("Work");
					
					WebElement phone_2_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_2\"]"));
					phone_2_number.sendKeys("");
					
					WebElement phone_3_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_3_type\"]"));
					Select phone_3_typedropdown = new Select(phone_3_type);
					phone_3_typedropdown.selectByVisibleText("Mobile");
					
					WebElement phone_3_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_3\"]"));
					phone_3_number.sendKeys("");
					
					WebElement webSite1 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_1\"]"));
					webSite1.sendKeys("");
					
					WebElement webSite2 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_2\"]"));
					webSite2.sendKeys("");
					
					WebElement webSite3 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_3\"]"));
					webSite3.sendKeys("");
					
					WebElement saveAddress = driver.findElement(By.xpath("//*[@id=\"submit_button\"]"));
					saveAddress.click();
					
					WebElement expectedText1 = driver.findElement(By.xpath("/html/body/p"));
					expectedText1.getText();
					assertEquals("An person's name or business name must be specified.\nAt least one of the following must be entered: street/mailing address, email address, phone number or web site url.",expectedText1.getText());
					//System.out.println(expectedText1.getText());					
					
					takesnapshot("addInvalid_TC4");
					
					
					driver.quit();
					
					
				}
				
				//Test Case 5 : Verify the functionality of clear form
				@Test
				@Order(5)
				void clearForm_TC5(){
					
					initialize();
					
					WebElement addNewEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					addNewEntry.click();
					
					WebElement entryType = driver.findElement(By.name("addr_type"));
					Select entryTypedropdown = new Select(entryType);
					entryTypedropdown.selectByVisibleText("Family");
					
					WebElement firstName = driver.findElement(By.xpath("//*[@id=\"addr_first_name\"]"));
					firstName.sendKeys("Shana");
					
					WebElement lastName = driver.findElement(By.xpath("//*[@id=\"addr_last_name\"]"));
					lastName.sendKeys("Moha");
					
					WebElement businessName = driver.findElement(By.xpath("//*[@id=\"addr_business\"]"));
					businessName.sendKeys("LXB");
					
					WebElement addressLine1 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_1\"]"));
					addressLine1.sendKeys("88");
					
					WebElement addressLine2 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_2\"]"));
					addressLine2.sendKeys("Edgevally");
					
					WebElement addressLine3 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_3\"]"));
					addressLine3.sendKeys("Adelaid");
					
					WebElement city = driver.findElement(By.xpath("//*[@id=\"addr_city\"]"));
					city.sendKeys("London");
					
					WebElement province = driver.findElement(By.xpath("//*[@id=\"addr_region\"]"));
					province.sendKeys("Ontario");
					
					WebElement country = driver.findElement(By.xpath("//*[@id=\"addr_country\"]"));
					country.sendKeys("Canada");
					
					WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"addr_post_code\"]"));
					postalCode.sendKeys("NC5 ODS");
					
					WebElement email1 = driver.findElement(By.xpath("//*[@id=\"addr_email_1\"]"));
					email1.sendKeys("shana1@gmail.com");
					
					WebElement email2 = driver.findElement(By.xpath("//*[@id=\"addr_email_2\"]"));
					email2.sendKeys("shana2@gmail.com");
					
					WebElement email3 = driver.findElement(By.xpath("//*[@id=\"addr_email_3\"]"));
					email3.sendKeys("shana3@gmail.com");
					
					WebElement phone_1_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_1_type\"]"));
					Select phone_1_typedropdown = new Select(phone_1_type);
					phone_1_typedropdown.selectByVisibleText("Home");
					
					WebElement phone_1_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_1\"]"));
					phone_1_number.sendKeys("1234567890");
					
					WebElement phone_2_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_2_type\"]"));
					Select phone_2_typedropdown = new Select(phone_2_type);
					phone_2_typedropdown.selectByVisibleText("Work");
					
					WebElement phone_2_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_2\"]"));
					phone_2_number.sendKeys("0987654321");
					
					WebElement phone_3_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_3_type\"]"));
					Select phone_3_typedropdown = new Select(phone_3_type);
					phone_3_typedropdown.selectByVisibleText("Mobile");
					
					WebElement phone_3_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_3\"]"));
					phone_3_number.sendKeys("34567823456");
					
					WebElement webSite1 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_1\"]"));
					webSite1.sendKeys("www.google.com");
					
					WebElement webSite2 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_2\"]"));
					webSite2.sendKeys("www.yahoo.com");
					
					WebElement webSite3 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_3\"]"));
					webSite3.sendKeys("www.lfx.com");
					
					WebElement clearForm = driver.findElement(By.xpath("//*[@id=\"reset_button\"]"));
					clearForm.click();
					
					//Verify whether the form cleared successfully.
					assertEquals("",firstName.getAttribute("value"));
					assertEquals("",lastName.getAttribute("value"));
					assertEquals("",businessName.getAttribute("value"));
					assertEquals("",addressLine1.getAttribute("value"));
					assertEquals("",addressLine2.getAttribute("value"));
					assertEquals("",addressLine3.getAttribute("value"));
					assertEquals("",city.getAttribute("value"));
					assertEquals("",province.getAttribute("value"));
					assertEquals("",country.getAttribute("value"));
					assertEquals("",postalCode.getAttribute("value"));
					assertEquals("",email1.getAttribute("value"));
					assertEquals("",email2.getAttribute("value"));
					assertEquals("",email3.getAttribute("value"));
					assertEquals("",phone_1_number.getAttribute("value"));
					assertEquals("",phone_2_number.getAttribute("value"));
					assertEquals("",phone_3_number.getAttribute("value"));
					assertEquals("",webSite1.getAttribute("value"));
					assertEquals("",webSite2.getAttribute("value"));
					assertEquals("",webSite3.getAttribute("value"));
					
					takesnapshot("clearForm_TC5");
					
					driver.quit();
					
				}
				
				
				
				//Test Case 6 : Verify the Return functionality in Add New Entry View
				@Test
				@Order(6)
				void returnInAdd_TC6(){
					
					initialize();
					
					WebElement addNewEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					addNewEntry.click();
					
					WebElement verifyreturn = driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[3]/a"));
					verifyreturn.click();
					
					String expected_title = driver.getTitle();
					assertEquals("Address Book",expected_title);
					takesnapshot("ReturnInAdd_TC6");
					
					driver.quit();
				}
				
				//Test Case 7 : Add a record successfully and verify the success message
				@Test
				@Order(7)
				void addSuccessfully_TC7(){
					
					initialize();
					
					WebElement addNewEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					addNewEntry.click();
					
					WebElement entryType = driver.findElement(By.name("addr_type"));
					Select entryTypedropdown = new Select(entryType);
					entryTypedropdown.selectByVisibleText("Family");
					
					WebElement firstName = driver.findElement(By.xpath("//*[@id=\"addr_first_name\"]"));
					firstName.sendKeys("Shehana");
					
					WebElement lastName = driver.findElement(By.xpath("//*[@id=\"addr_last_name\"]"));
					lastName.sendKeys("Mohamed");
					
					WebElement businessName = driver.findElement(By.xpath("//*[@id=\"addr_business\"]"));
					businessName.sendKeys("LSDF");
					
					WebElement addressLine1 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_1\"]"));
					addressLine1.sendKeys("88");
					
					WebElement addressLine2 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_2\"]"));
					addressLine2.sendKeys("Edgevally");
					
					WebElement addressLine3 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_3\"]"));
					addressLine3.sendKeys("Adelaid");
					
					WebElement city = driver.findElement(By.xpath("//*[@id=\"addr_city\"]"));
					city.sendKeys("London");
					
					WebElement province = driver.findElement(By.xpath("//*[@id=\"addr_region\"]"));
					province.sendKeys("Ontario");
					
					WebElement country = driver.findElement(By.xpath("//*[@id=\"addr_country\"]"));
					country.sendKeys("Canada");
					
					WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"addr_post_code\"]"));
					postalCode.sendKeys("NC5 ODS");
					
					WebElement email1 = driver.findElement(By.xpath("//*[@id=\"addr_email_1\"]"));
					email1.sendKeys("shana1@gmail.com");
					
					WebElement email2 = driver.findElement(By.xpath("//*[@id=\"addr_email_2\"]"));
					email2.sendKeys("shana2@gmail.com");
					
					WebElement email3 = driver.findElement(By.xpath("//*[@id=\"addr_email_3\"]"));
					email3.sendKeys("shana3@gmail.com");
					
					WebElement phone_1_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_1_type\"]"));
					Select phone_1_typedropdown = new Select(phone_1_type);
					phone_1_typedropdown.selectByVisibleText("Home");
					
					WebElement phone_1_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_1\"]"));
					phone_1_number.sendKeys("1234567890");
					
					WebElement phone_2_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_2_type\"]"));
					Select phone_2_typedropdown = new Select(phone_2_type);
					phone_2_typedropdown.selectByVisibleText("Work");
					
					WebElement phone_2_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_2\"]"));
					phone_2_number.sendKeys("0987654321");
					
					WebElement phone_3_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_3_type\"]"));
					Select phone_3_typedropdown = new Select(phone_3_type);
					phone_3_typedropdown.selectByVisibleText("Mobile");
					
					WebElement phone_3_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_3\"]"));
					phone_3_number.sendKeys("34567823456");
					
					WebElement webSite1 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_1\"]"));
					webSite1.sendKeys("www.google.com");
					
					WebElement webSite2 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_2\"]"));
					webSite2.sendKeys("www.yahoo.com");
					
					WebElement webSite3 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_3\"]"));
					webSite3.sendKeys("www.lfx.com");
					
					WebElement saveAddress = driver.findElement(By.xpath("//*[@id=\"submit_button\"]"));
					saveAddress.click();
					
					takesnapshot("addSuccessfully_TC7_SS1");
					
					WebElement expectedResult = driver.findElement(By.xpath("/html/body/form/div/h2"));
					expectedResult.getText();
					assertEquals("The new address book entry was added successfully",expectedResult.getText());
					
					WebElement continueB = driver.findElement(By.cssSelector("body > form > div > input[type=submit]"));
					continueB.click();
					
					takesnapshot("addSuccessfully_TC7_SS2");
					String expected_title = driver.getTitle();
					assertEquals("Address Book",expected_title);
					
					driver.quit();
				}
				
				//Test Case 8 : Add a record successfully and verify from View functionality
				@Test
				@Order(8)
				void addAndView_TC8(){
					
					initialize();
					
					//Adding a record
					WebElement addNewEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					addNewEntry.click();
					
					WebElement entryType = driver.findElement(By.name("addr_type"));
					Select entryTypedropdown = new Select(entryType);
					entryTypedropdown.selectByVisibleText("Family");
					
					WebElement firstName = driver.findElement(By.xpath("//*[@id=\"addr_first_name\"]"));
					firstName.sendKeys("Verify_ViewFirstName");
					
					WebElement lastName = driver.findElement(By.xpath("//*[@id=\"addr_last_name\"]"));
					lastName.sendKeys("");
					
					WebElement businessName = driver.findElement(By.xpath("//*[@id=\"addr_business\"]"));
					businessName.sendKeys("");
					
					WebElement addressLine1 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_1\"]"));
					addressLine1.sendKeys("88");
					
					WebElement addressLine2 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_2\"]"));
					addressLine2.sendKeys("Edgevally");
					
					WebElement addressLine3 = driver.findElement(By.xpath("//*[@id=\"addr_addr_line_3\"]"));
					addressLine3.sendKeys("Adelaid");
					
					WebElement city = driver.findElement(By.xpath("//*[@id=\"addr_city\"]"));
					city.sendKeys("London");
					
					WebElement province = driver.findElement(By.xpath("//*[@id=\"addr_region\"]"));
					province.sendKeys("Ontario");
					
					WebElement country = driver.findElement(By.xpath("//*[@id=\"addr_country\"]"));
					country.sendKeys("Canada");
					
					WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"addr_post_code\"]"));
					postalCode.sendKeys("NC5 ODS");
					
					WebElement email1 = driver.findElement(By.xpath("//*[@id=\"addr_email_1\"]"));
					email1.sendKeys("shana1@gmail.com");
					
					WebElement email2 = driver.findElement(By.xpath("//*[@id=\"addr_email_2\"]"));
					email2.sendKeys("shana2@gmail.com");
					
					WebElement email3 = driver.findElement(By.xpath("//*[@id=\"addr_email_3\"]"));
					email3.sendKeys("shana3@gmail.com");
					
					WebElement phone_1_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_1_type\"]"));
					Select phone_1_typedropdown = new Select(phone_1_type);
					phone_1_typedropdown.selectByVisibleText("Home");
					
					WebElement phone_1_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_1\"]"));
					phone_1_number.sendKeys("1234567890");
					
					WebElement phone_2_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_2_type\"]"));
					Select phone_2_typedropdown = new Select(phone_2_type);
					phone_2_typedropdown.selectByVisibleText("Work");
					
					WebElement phone_2_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_2\"]"));
					phone_2_number.sendKeys("0987654321");
					
					WebElement phone_3_type = driver.findElement(By.xpath("//*[@id=\"addr_phone_3_type\"]"));
					Select phone_3_typedropdown = new Select(phone_3_type);
					phone_3_typedropdown.selectByVisibleText("Mobile");
					
					WebElement phone_3_number = driver.findElement(By.xpath("//*[@id=\"addr_phone_3\"]"));
					phone_3_number.sendKeys("34567823456");
					
					WebElement webSite1 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_1\"]"));
					webSite1.sendKeys("www.google.com");
					
					WebElement webSite2 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_2\"]"));
					webSite2.sendKeys("www.yahoo.com");
					
					WebElement webSite3 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_3\"]"));
					webSite3.sendKeys("www.lfx.com");
					
					WebElement saveAddress = driver.findElement(By.xpath("//*[@id=\"submit_button\"]"));
					saveAddress.click();
					
					takesnapshot("addSuccessfully_TC8_SS1");
					
					WebElement expectedResult = driver.findElement(By.xpath("/html/body/form/div/h2"));
					expectedResult.getText();
					assertEquals("The new address book entry was added successfully",expectedResult.getText());
					
					WebElement continueB = driver.findElement(By.cssSelector("body > form > div > input[type=submit]"));
					continueB.click();
					takesnapshot("addSuccessfully_TC8_SS2");
					
					
					 //Verifying whether the record added is available from view end
					 
					  WebElement viewAllEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					  viewAllEntry.click();
					  
					   WebElement viewTableValue = driver.findElement(By.xpath("/html/body/table"));
					  
					   // Define the expected value
				        String expectedValue = "Verify_ViewFirstName";
				        boolean found = false;

				        // Iterate through each row of the table
				        for (WebElement row : viewTableValue.findElements(By.tagName("tr"))) {
				            for (WebElement cell : row.findElements(By.tagName("td"))) {
				                if (cell.getText().equals(expectedValue)) {
				                    found = true;
				                    break;
				                }
				            }
				            // Break the outer loop if the expected value is found in any cell
				            if (found) {
				                break;
				            }
				        }

				        // Check if the expected value was found
				        if (found) {
				            System.out.println("Expected value found in the  view table.");
				        } else {
				            System.out.println("Expected value not found in the  view table.");
				        }
					
				        takesnapshot("addSuccessfully_TC8_SS3");
					
					
					driver.quit();
				}
				
				//Test Case 9 : Verify view functionality
				@Test
				@Order(9)
				void verifyView_TC9(){
					
					initialize();
				
					try {

					WebElement viewAllEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					viewAllEntry.click();
					
					WebElement testData = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]"));
					testData.getText();
					
					WebElement viewB = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]/form[1]/input[2]"));
					viewB.click();
					
					WebElement verifydata = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]"));
					verifydata.getText();
					assertEquals(testData.getText(),verifydata.getText());
					
					} catch (StaleElementReferenceException e) {
			           
			            System.out.println("StaleElementReferenceException occurred. Retrying...");
			        }
						
				    takesnapshot("addSuccessfully_TC9_SS1");
					
					
					driver.quit();
						
				}
				//Test Case 10 : Verify Edit Navigation functionality
				@Test
				@Order(10)
				void verifyEditNavigation_TC10(){
					
					initialize();
					
					WebElement viewAllEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					viewAllEntry.click();
					
					WebElement editB = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]/form[2]/input[3]"));
					editB.click();
					
					WebElement expectedResult = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[1]/td[1]/label"));
					expectedResult.getText();
					assertEquals("Entry Type:",expectedResult.getText());
					takesnapshot("addSuccessfully_TC10_SS1");
					
					driver.quit();
					
				}
				
				//Test Case 11 : Verify Edit functionality
				@Test
				@Order(11)
				void verifyEdit_TC11(){
					
					initialize();
					
					WebElement viewAllEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					viewAllEntry.click();
					
					WebElement editB = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]/form[2]/input[3]"));
					editB.click();
					
					WebElement firstName = driver.findElement(By.xpath("//*[@id=\"addr_first_name\"]"));
					firstName.sendKeys("Verify_EditFirstName");
					
					WebElement webSite3 = driver.findElement(By.xpath("//*[@id=\"addr_web_url_3\"]"));
					webSite3.sendKeys("www.lfx.com");
					
					WebElement saveAddress = driver.findElement(By.xpath("//*[@id=\"submit_button\"]"));
					saveAddress.click();
					
					takesnapshot("verifyEdit_TC11_SS1");
					
					WebElement expectedResult = driver.findElement(By.xpath("/html/body/form/div/h2"));
					expectedResult.getText();
					assertEquals("The address book entry was updated successfully",expectedResult.getText());
					
					WebElement continueB = driver.findElement(By.cssSelector("body > form > div > input[type=submit]"));
					continueB.click();
					
					 //Verifying whether the record updated is available from edit end
					  WebElement viewAllEntry1 = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					  viewAllEntry1.click();
					 			  
					   WebElement viewTableValue = driver.findElement(By.xpath("/html/body/table"));
					  
					   // Define the expected value
				        String expectedValue = "Verify_EditFirstName";
				        boolean found = false;

				        // Iterate through each row of the table
				        for (WebElement row : viewTableValue.findElements(By.tagName("tr"))) {
				            for (WebElement cell : row.findElements(By.tagName("td"))) {
				                if (cell.getText().equals(expectedValue)) {
				                    found = true;
				                    break;
				                }
				            }
				            // Break the outer loop if the expected value is found in any cell
				            if (found) {
				                break;
				            }
				        }
				        // Check if the expected value was found
				        if (found) {
				            System.out.println("Expected value found in the  view table.");
				        } else {
				            System.out.println("Expected value not found in the  view table.");
				        }
					
				        takesnapshot("verifyEdit_TC11_SS2");
					
					driver.quit();
					
					
				}
				
				//Test Case 12 : Verify view Navigation functionality
				@Test
				@Order(12)
				void verifyViewNavigation_TC12(){
					
					initialize();
					
					WebElement viewAllEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					viewAllEntry.click();
					
					WebElement viewB = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]/form[1]/input[2]"));
					viewB.click();
					
					WebElement expectedResult = driver.findElement(By.xpath("/html/body/div[1]/h2"));
					expectedResult.getText();
					assertEquals("Address Book Entry Details",expectedResult.getText());
					takesnapshot("verifyViewNavigation_TC12_SS1");
					
					driver.quit();
					
				}
				
				
				//Test Case 13 : Verify viewAllEntry return functionality
				@Test
				@Order(13)
				void viewAllEntryReturn_TC13(){
					
					initialize();
					
					WebElement viewAllEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					viewAllEntry.click();
					
					WebElement viewAllEntryReturn = driver.findElement(By.cssSelector("body > div:nth-child(5) > a"));
					viewAllEntryReturn.click();
					
					String expected_title = driver.getTitle();
					assertEquals("Address Book",expected_title);
					takesnapshot("viewAllEntryReturn_TC13_SS1");
					
					driver.quit();
					
				}
				
				//Test Case 14 : Verify view panel return functionality
				@Test
				@Order(14)
				void viewReturn_TC14(){
					
					initialize();
					
					WebElement viewAllEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					viewAllEntry.click();
					
					WebElement viewB = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]/form[1]/input[2]"));
					viewB.click();
					
					WebElement viewReturn = driver.findElement(By.cssSelector("body > div:nth-child(4) > a"));
					viewReturn.click();
					
					WebElement expected = driver.findElement(By.xpath("/html/body/div[1]/h1"));
					String value = expected.getText();
					assertEquals("Address Book - All Entries",value);
					takesnapshot("viewAllEntryReturn_TC14_SS1");
					
					driver.quit();
					
				}
				
				//Test Case 15 : Verify clear form functionality without adding all the fields.
				@Test
				@Order(15)
				void clearFormWithoutAll_TC15(){
					
					initialize();
					
					WebElement addNewEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					addNewEntry.click();
					
					WebElement entryType = driver.findElement(By.name("addr_type"));
					Select entryTypedropdown = new Select(entryType);
					entryTypedropdown.selectByVisibleText("Family");
					
					WebElement firstName = driver.findElement(By.xpath("//*[@id=\"addr_first_name\"]"));
					firstName.sendKeys("Shehana");
					
					WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"addr_post_code\"]"));
					postalCode.sendKeys("NC5 ODS");
					
					WebElement clearForm = driver.findElement(By.xpath("//*[@id=\"reset_button\"]"));
					clearForm.click();
					
					//Verify whether the fields are cleared.
					assertEquals("",firstName.getAttribute("value"));
					assertEquals("",postalCode.getAttribute("value"));		
					takesnapshot("clearFormWithoutAll_TC15");
					
					driver.quit();
					
				}
				
				//Test Case 16 : Verify clear form functionality in Edit.
				@Test
				@Order(16)
				void clearFormEdit_TC16(){
					
					initialize();
					
					WebElement viewAllEntry = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					viewAllEntry.click();
					
					WebElement editB = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]/form[2]/input[3]"));
					editB.click();
					
					WebElement clearForm = driver.findElement(By.xpath("//*[@id=\"reset_button\"]"));
					clearForm.click();
					
					
					WebElement firstName = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[2]/td[2]/input"));
					String value = firstName.getAttribute("value");
					
					
					String expectedValue = "";
					
					if (value.equals(expectedValue)) {
			            // If the values match, test passes
			            System.out.println("Input field value matches the expected value: " + expectedValue);
			        } else {
			            // If the values do not match, test fails
			            System.out.println("Test is Failed - Input field value does not match the expected value.");
			            takesnapshot("clearFormEdit_TC16");
						driver.quit();
			        }
					//Verify whether the form cleared successfully.
					assertEquals(expectedValue,value);
							
					takesnapshot("clearFormEdit_TC16");
					
					driver.quit();
					
				}	
				
				// @Test 17 and 23  are written while selecting Friend from entry type dropdown and based on Add and Edit.
				@Test
				@Order(17)
				void addNewEntity()
				{
					initialize();
					WebElement add = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					add.click();
					
					WebElement addr_type = driver.findElement(By.name("addr_type"));
					Select EntryType = new Select(addr_type);
					EntryType.selectByVisibleText("Friend");
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.sendKeys("Maryam");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.sendKeys("Zardosht");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.sendKeys("ABC CO");
					
					WebElement addL1 = driver.findElement(By.name("addr_addr_line_1"));
					addL1.sendKeys("Addr1");
					
					WebElement addL2 = driver.findElement(By.name("addr_addr_line_2"));
					addL2.sendKeys("Addr2");
					
					WebElement addL3 = driver.findElement(By.name("addr_addr_line_3"));
					addL3.sendKeys("Addr3");
					
					WebElement city = driver.findElement(By.name("addr_city"));
					city.sendKeys("London");
					
					WebElement province = driver.findElement(By.name("addr_region"));
					province.sendKeys("ON");
					
					WebElement country = driver.findElement(By.name("addr_country"));
					country.sendKeys("Canada");
					
					WebElement postalC = driver.findElement(By.name("addr_post_code"));
					postalC.sendKeys("N6G 5P2");
					
					WebElement email1 = driver.findElement(By.name("addr_email_1"));
					email1.sendKeys("m_zardosht@fanshaweonline.ca");
					
					WebElement email2 = driver.findElement(By.name("addr_email_2"));
					email2.sendKeys("m_zardosht1@fanshaweonline.ca");
					
					WebElement email3 = driver.findElement(By.name("addr_email_3"));
					email3.sendKeys("m_zardosht2@fanshaweonline.ca");
					
					WebElement phoneType1 = driver.findElement(By.name("addr_phone_1_type"));
					Select PhoneType1 = new Select(phoneType1);
					PhoneType1.selectByVisibleText("Home");
					
					WebElement phoneNum1 = driver.findElement(By.name("addr_phone_1"));
					phoneNum1.sendKeys("11223344");
					
					WebElement phoneType2 = driver.findElement(By.name("addr_phone_2_type"));
					Select PhoneType2 = new Select(phoneType2);
					PhoneType2.selectByVisibleText("Work");
					
					WebElement phoneNum2 = driver.findElement(By.name("addr_phone_2"));
					phoneNum2.sendKeys("22334455");
					
					WebElement phoneType3 = driver.findElement(By.name("addr_phone_3_type"));
					Select PhoneType3 = new Select(phoneType3);
					PhoneType3.selectByVisibleText("Mobile");
					
					WebElement phoneNum3 = driver.findElement(By.name("addr_phone_3"));
					phoneNum3.sendKeys("33445566");
					
					WebElement website1 = driver.findElement(By.name("addr_web_url_1"));
					website1.sendKeys("www.zardosht1.com");
					
					WebElement website2 = driver.findElement(By.name("addr_web_url_2"));
					website2.sendKeys("www.zardosht2.com");
					
					WebElement website3 = driver.findElement(By.name("addr_web_url_3"));
					website3.sendKeys("www.zardosht3.com");
						
					WebElement save = driver.findElement(By.name("submit_button"));
					save.click();
					
					WebElement update = driver.findElement(By.xpath("/html/body/form/div/h2"));
					update.getText();
					System.out.println(update.getText());
					
					assertEquals("The new address book entry was added successfully",update.getText());
					
					WebElement contin = driver.findElement(By.xpath("/html/body/form/div/input"));
					contin.click();
					
					takesnapshot("addNewEntity_TC17");
					
					driver.quit();
					
				}
				
				@Test
				@Order(18)
				void addInfoWithoutNames()
				{
					initialize();
					WebElement add = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					add.click();
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.sendKeys("");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.sendKeys("");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.sendKeys("");
					
					WebElement addL1 = driver.findElement(By.name("addr_addr_line_1"));
					addL1.sendKeys("8484 alpha st.");
					
					
					WebElement save = driver.findElement(By.name("submit_button"));
					save.click();
					
					WebElement update = driver.findElement(By.xpath("/html/body/p"));
					update.getText();
					System.out.println(update.getText());
					
					assertEquals("An person's name or business name must be specified.",update.getText());
					
					takesnapshot("addInfoWithoutNames_TC18");
					
					driver.quit();
				}
				
				@Test
				@Order(19)
				void addNameWithoutInfo()
				{
					initialize();
					WebElement add = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					add.click();
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.sendKeys("BBB");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.sendKeys("CCC");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.sendKeys("XX CO");
					
					WebElement save = driver.findElement(By.name("submit_button"));
					save.click();
					
					WebElement update = driver.findElement(By.xpath("/html/body/p"));
					update.getText();
					System.out.println(update.getText());
					
					assertEquals("At least one of the following must be entered: street/mailing address, email address, phone number or web site url.",update.getText());
					
					takesnapshot("addNameWithoutInfo_TC19");
					
					driver.quit();
				}
				@Test
				@Order(20)
				void addNewEntityThenClear()
				{
					initialize();
					WebElement add = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					add.click();
					
					WebElement addr_type = driver.findElement(By.name("addr_type"));
					Select EntryType = new Select(addr_type);
					EntryType.selectByVisibleText("Other");
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.sendKeys("BBB");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.sendKeys("CCC");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.sendKeys("XX CO");
					
					WebElement addL1 = driver.findElement(By.name("addr_addr_line_1"));
					addL1.sendKeys("Addr1");
					
					WebElement addL2 = driver.findElement(By.name("addr_addr_line_2"));
					addL2.sendKeys("Addr2");
					
					WebElement addL3 = driver.findElement(By.name("addr_addr_line_3"));
					addL3.sendKeys("Addr3");
					
					WebElement city = driver.findElement(By.name("addr_city"));
					city.sendKeys("London");
					
					WebElement province = driver.findElement(By.name("addr_region"));
					province.sendKeys("ON");
					
					WebElement country = driver.findElement(By.name("addr_country"));
					country.sendKeys("Canada");
					
					WebElement postalC = driver.findElement(By.name("addr_post_code"));
					postalC.sendKeys("N6H 0K8");
					
					WebElement email1 = driver.findElement(By.name("addr_email_1"));
					email1.sendKeys("bb@cc.com");
					
					WebElement email2 = driver.findElement(By.name("addr_email_2"));
					email2.sendKeys("aa@bb.com");
					
					WebElement email3 = driver.findElement(By.name("addr_email_3"));
					email3.sendKeys("dd@cc.com");
					
					WebElement phoneType1 = driver.findElement(By.name("addr_phone_1_type"));
					Select PhoneType1 = new Select(phoneType1);
					PhoneType1.selectByVisibleText("Home");
					
					WebElement phoneNum1 = driver.findElement(By.name("addr_phone_1"));
					phoneNum1.sendKeys("11223344");
					
					WebElement phoneType2 = driver.findElement(By.name("addr_phone_2_type"));
					Select PhoneType2 = new Select(phoneType2);
					PhoneType2.selectByVisibleText("Work");
					
					WebElement phoneNum2 = driver.findElement(By.name("addr_phone_2"));
					phoneNum2.sendKeys("22334455");
					
					WebElement phoneType3 = driver.findElement(By.name("addr_phone_3_type"));
					Select PhoneType3 = new Select(phoneType3);
					PhoneType3.selectByVisibleText("Mobile");
					
					WebElement phoneNum3 = driver.findElement(By.name("addr_phone_3"));
					phoneNum3.sendKeys("33445566");
					
					WebElement website1 = driver.findElement(By.name("addr_web_url_1"));
					website1.sendKeys("www.aaa.com");
					
					WebElement website2 = driver.findElement(By.name("addr_web_url_2"));
					website2.sendKeys("www.bbb.com");
					
					WebElement website3 = driver.findElement(By.name("addr_web_url_3"));
					website3.sendKeys("www.ccc.com");
					
					WebElement clear = driver.findElement(By.name("reset_button"));
					clear.click();
						
					String textFieldValue = firstName.getAttribute("value");
					
					assertEquals("",textFieldValue);
					
					takesnapshot("addNewEntityThenClear_TC20");
					
					driver.quit();
					
				}
				
				@Test
				@Order(21)
				void editInfoWithoutNames()
				{
					initialize();
					
					WebElement listAll = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					listAll.click();
					
					WebElement edit = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[4]/form[2]/input[3]"));
					edit.click();
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.clear();
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.clear();
			
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.clear();
					
					WebElement save = driver.findElement(By.name("submit_button"));
					save.click();
					
					WebElement update = driver.findElement(By.xpath("/html/body/p"));
					update.getText();
					System.out.println(update.getText());
					
					assertEquals("An person's name or business name must be specified.",update.getText());
					
					takesnapshot("editInfoWithoutNames_TC21");
					
					driver.quit();
				}
				
				@Test
				@Order(22)
				void deleteInfo()
				{
					initialize();
					
					WebElement listAll = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					listAll.click();
					
					WebElement edit = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[4]/form[2]/input[3]"));
					edit.click();
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.clear();
					firstName.sendKeys("tes1");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.clear();
					lastName.sendKeys("test");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.clear();
					bsnsName.sendKeys("test CO");
					
					WebElement addL1 = driver.findElement(By.name("addr_addr_line_1"));
					addL1.clear();
			
					
					WebElement addL2 = driver.findElement(By.name("addr_addr_line_2"));
					addL2.clear();
			
					
					WebElement addL3 = driver.findElement(By.name("addr_addr_line_3"));
					addL3.clear();
					
					
					WebElement city = driver.findElement(By.name("addr_city"));
					city.clear();
					
					
					WebElement province = driver.findElement(By.name("addr_region"));
					province.clear();
					
					
					WebElement country = driver.findElement(By.name("addr_country"));
					country.clear();
					
					
					WebElement postalC = driver.findElement(By.name("addr_post_code"));
					postalC.clear();
					
					
					WebElement email1 = driver.findElement(By.name("addr_email_1"));
					email1.clear();
					
					
					WebElement email2 = driver.findElement(By.name("addr_email_2"));
					email2.clear();
					
					
					WebElement email3 = driver.findElement(By.name("addr_email_3"));
					email3.clear();
					
					
					WebElement phoneType1 = driver.findElement(By.name("addr_phone_1_type"));
					Select PhoneType1 = new Select(phoneType1);
					
					
					WebElement phoneNum1 = driver.findElement(By.name("addr_phone_1"));
					phoneNum1.clear();
					
					
					WebElement phoneType2 = driver.findElement(By.name("addr_phone_2_type"));
					Select PhoneType2 = new Select(phoneType2);
					
					
					WebElement phoneNum2 = driver.findElement(By.name("addr_phone_2"));
					phoneNum2.clear();
					
					
					WebElement phoneType3 = driver.findElement(By.name("addr_phone_3_type"));
					Select PhoneType3 = new Select(phoneType3);
					
					
					WebElement phoneNum3 = driver.findElement(By.name("addr_phone_3"));
					phoneNum3.clear();
					
					
					WebElement website1 = driver.findElement(By.name("addr_web_url_1"));
					website1.clear();
					
					
					WebElement website2 = driver.findElement(By.name("addr_web_url_2"));
					website2.clear();
					
					
					WebElement website3 = driver.findElement(By.name("addr_web_url_3"));
					website3.clear();
					
			
					
					WebElement save = driver.findElement(By.name("submit_button"));
					save.click();
					
					WebElement update = driver.findElement(By.xpath("/html/body/p"));
					update.getText();
					System.out.println(update.getText());
					
					assertEquals("At least one of the following must be entered: street/mailing address, email address, phone number or web site url.",update.getText());
					takesnapshot("deleteInfo_TC22");
					
					driver.quit();
				}
				
				
				@Test
				@Order(23)
				void EditThenClear()
				{
					initialize();
					
					WebElement listAll = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					listAll.click();
					
					WebElement edit = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[4]/form[2]/input[3]"));
					edit.click();
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.clear();
					firstName.sendKeys("tes1");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.clear();
					lastName.sendKeys("test");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.clear();
					bsnsName.sendKeys("test CO");
					
					WebElement addL1 = driver.findElement(By.name("addr_addr_line_1"));
					addL1.clear();
					addL1.sendKeys("test");
					
					WebElement addL2 = driver.findElement(By.name("addr_addr_line_2"));
					addL2.clear();
					addL2.sendKeys("test");
					
					WebElement addL3 = driver.findElement(By.name("addr_addr_line_3"));
					addL3.clear();
					addL3.sendKeys("test");
					
					WebElement city = driver.findElement(By.name("addr_city"));
					city.clear();
					city.sendKeys("test");
					
					WebElement province = driver.findElement(By.name("addr_region"));
					province.clear();
					province.sendKeys("test");
					
					WebElement country = driver.findElement(By.name("addr_country"));
					country.clear();
					country.sendKeys("test");
					
					WebElement postalC = driver.findElement(By.name("addr_post_code"));
					postalC.clear();
					postalC.sendKeys("test 0K8");
					
					WebElement email1 = driver.findElement(By.name("addr_email_1"));
					email1.clear();
					email1.sendKeys("test.com");
					
					WebElement email2 = driver.findElement(By.name("addr_email_2"));
					email2.clear();
					email2.sendKeys("test.com");
					
					WebElement email3 = driver.findElement(By.name("addr_email_3"));
					email3.clear();
					email3.sendKeys("test.com");
					
					WebElement phoneType1 = driver.findElement(By.name("addr_phone_1_type"));
					Select PhoneType1 = new Select(phoneType1);
					PhoneType1.selectByVisibleText("Home");
					
					WebElement phoneNum1 = driver.findElement(By.name("addr_phone_1"));
					phoneNum1.clear();
					phoneNum1.sendKeys("test");
					
					WebElement phoneType2 = driver.findElement(By.name("addr_phone_2_type"));
					Select PhoneType2 = new Select(phoneType2);
					PhoneType2.selectByVisibleText("Work");
					
					WebElement phoneNum2 = driver.findElement(By.name("addr_phone_2"));
					phoneNum2.clear();
					phoneNum2.sendKeys("test");
					
					WebElement phoneType3 = driver.findElement(By.name("addr_phone_3_type"));
					Select PhoneType3 = new Select(phoneType3);
					PhoneType3.selectByVisibleText("Mobile");
					
					WebElement phoneNum3 = driver.findElement(By.name("addr_phone_3"));
					phoneNum3.clear();
					phoneNum3.sendKeys("test");
					
					WebElement website1 = driver.findElement(By.name("addr_web_url_1"));
					website1.clear();
					website1.sendKeys("www.test1.com");
					
					WebElement website2 = driver.findElement(By.name("addr_web_url_2"));
					website2.clear();
					website2.sendKeys("www.test2.com");
					
					WebElement website3 = driver.findElement(By.name("addr_web_url_3"));
					website3.clear();
					website3.sendKeys("test3.com");
					
					WebElement clear = driver.findElement(By.name("reset_button"));
					clear.click();
					
					String textFieldValue = firstName.getAttribute("value");
					takesnapshot("EditThenClear_TC23");
					
					assertEquals("",textFieldValue);
					driver.quit();

				}
				
				// @Test 24 and 29  are written while selecting Other from entry type dropdown and based on Add and Edit.
				
				@Test
				@Order(24)
				void editInfoWithoutNamesOther()
				{
					initialize();
					
					WebElement listAll = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					listAll.click();
					
					WebElement edit = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[4]/form[2]/input[3]"));
					edit.click();
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.clear();
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.clear();
			
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.clear();
					
					WebElement save = driver.findElement(By.name("submit_button"));
					save.click();
					
					WebElement update = driver.findElement(By.xpath("/html/body/p"));
					update.getText();
					System.out.println(update.getText());
					
					assertEquals("An person's name or business name must be specified.",update.getText());
					
					takesnapshot("editInfoWithoutNamesOther_TC25");
					
					driver.quit();

				}
				
				@Test
				@Order(25)
				void deleteInfoOther()
				{
					initialize();
					
					WebElement listAll = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					listAll.click();
					
					WebElement edit = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[4]/form[2]/input[3]"));
					edit.click();
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.clear();
					firstName.sendKeys("tes1");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.clear();
					lastName.sendKeys("test");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.clear();
					bsnsName.sendKeys("test CO");
					
					WebElement addL1 = driver.findElement(By.name("addr_addr_line_1"));
					addL1.clear();
			
					
					WebElement addL2 = driver.findElement(By.name("addr_addr_line_2"));
					addL2.clear();
			
					
					WebElement addL3 = driver.findElement(By.name("addr_addr_line_3"));
					addL3.clear();
					
					
					WebElement city = driver.findElement(By.name("addr_city"));
					city.clear();
					
					
					WebElement province = driver.findElement(By.name("addr_region"));
					province.clear();
					
					
					WebElement country = driver.findElement(By.name("addr_country"));
					country.clear();
					
					
					WebElement postalC = driver.findElement(By.name("addr_post_code"));
					postalC.clear();
					
					
					WebElement email1 = driver.findElement(By.name("addr_email_1"));
					email1.clear();
					
					
					WebElement email2 = driver.findElement(By.name("addr_email_2"));
					email2.clear();
					
					
					WebElement email3 = driver.findElement(By.name("addr_email_3"));
					email3.clear();
					
					
					WebElement phoneType1 = driver.findElement(By.name("addr_phone_1_type"));
					Select PhoneType1 = new Select(phoneType1);
					
					
					WebElement phoneNum1 = driver.findElement(By.name("addr_phone_1"));
					phoneNum1.clear();
					
					
					WebElement phoneType2 = driver.findElement(By.name("addr_phone_2_type"));
					Select PhoneType2 = new Select(phoneType2);
					
					
					WebElement phoneNum2 = driver.findElement(By.name("addr_phone_2"));
					phoneNum2.clear();
					
					
					WebElement phoneType3 = driver.findElement(By.name("addr_phone_3_type"));
					Select PhoneType3 = new Select(phoneType3);
					
					
					WebElement phoneNum3 = driver.findElement(By.name("addr_phone_3"));
					phoneNum3.clear();
					
					
					WebElement website1 = driver.findElement(By.name("addr_web_url_1"));
					website1.clear();
					
					
					WebElement website2 = driver.findElement(By.name("addr_web_url_2"));
					website2.clear();
					
					
					WebElement website3 = driver.findElement(By.name("addr_web_url_3"));
					website3.clear();
					
			
					
					WebElement save = driver.findElement(By.name("submit_button"));
					save.click();
					
					WebElement update = driver.findElement(By.xpath("/html/body/p"));
					update.getText();
					System.out.println(update.getText());
					
					assertEquals("At least one of the following must be entered: street/mailing address, email address, phone number or web site url.",update.getText());
					
					takesnapshot("deleteInfoOther_TC26");
					
					driver.quit();

				}
				
				
				@Test
				@Order(26)
				void EditThenClearOther()
				{
					initialize();
					
					WebElement listAll = driver.findElement(By.xpath("/html/body/doctype/ul/li[1]/a"));
					listAll.click();
					
					WebElement edit = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[4]/form[2]/input[3]"));
					edit.click();
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.clear();
					firstName.sendKeys("tes1");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.clear();
					lastName.sendKeys("test");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.clear();
					bsnsName.sendKeys("test CO");
					
					WebElement addL1 = driver.findElement(By.name("addr_addr_line_1"));
					addL1.clear();
					addL1.sendKeys("test");
					
					WebElement addL2 = driver.findElement(By.name("addr_addr_line_2"));
					addL2.clear();
					addL2.sendKeys("test");
					
					WebElement addL3 = driver.findElement(By.name("addr_addr_line_3"));
					addL3.clear();
					addL3.sendKeys("test");
					
					WebElement city = driver.findElement(By.name("addr_city"));
					city.clear();
					city.sendKeys("test");
					
					WebElement province = driver.findElement(By.name("addr_region"));
					province.clear();
					province.sendKeys("test");
					
					WebElement country = driver.findElement(By.name("addr_country"));
					country.clear();
					country.sendKeys("test");
					
					WebElement postalC = driver.findElement(By.name("addr_post_code"));
					postalC.clear();
					postalC.sendKeys("test 0K8");
					
					WebElement email1 = driver.findElement(By.name("addr_email_1"));
					email1.clear();
					email1.sendKeys("test.com");
					
					WebElement email2 = driver.findElement(By.name("addr_email_2"));
					email2.clear();
					email2.sendKeys("test.com");
					
					WebElement email3 = driver.findElement(By.name("addr_email_3"));
					email3.clear();
					email3.sendKeys("test.com");
					
					WebElement phoneType1 = driver.findElement(By.name("addr_phone_1_type"));
					Select PhoneType1 = new Select(phoneType1);
					PhoneType1.selectByVisibleText("Home");
					
					WebElement phoneNum1 = driver.findElement(By.name("addr_phone_1"));
					phoneNum1.clear();
					phoneNum1.sendKeys("test");
					
					WebElement phoneType2 = driver.findElement(By.name("addr_phone_2_type"));
					Select PhoneType2 = new Select(phoneType2);
					PhoneType2.selectByVisibleText("Work");
					
					WebElement phoneNum2 = driver.findElement(By.name("addr_phone_2"));
					phoneNum2.clear();
					phoneNum2.sendKeys("test");
					
					WebElement phoneType3 = driver.findElement(By.name("addr_phone_3_type"));
					Select PhoneType3 = new Select(phoneType3);
					PhoneType3.selectByVisibleText("Mobile");
					
					WebElement phoneNum3 = driver.findElement(By.name("addr_phone_3"));
					phoneNum3.clear();
					phoneNum3.sendKeys("test");
					
					WebElement website1 = driver.findElement(By.name("addr_web_url_1"));
					website1.clear();
					website1.sendKeys("www.test1.com");
					
					WebElement website2 = driver.findElement(By.name("addr_web_url_2"));
					website2.clear();
					website2.sendKeys("www.test2.com");
					
					WebElement website3 = driver.findElement(By.name("addr_web_url_3"));
					website3.clear();
					website3.sendKeys("test3.com");
					
					WebElement clear = driver.findElement(By.name("reset_button"));
					clear.click();
					
					String textFieldValue = firstName.getAttribute("value");
					takesnapshot("EditThenClearOther_TC27");
					
					assertEquals("",textFieldValue);
						
					driver.quit();

				}
				
				@Test
				@Order(27)
				void addNewEntityOther()
				{
					initialize();
					WebElement add = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					add.click();
					
					WebElement addr_type = driver.findElement(By.name("addr_type"));
					Select EntryType = new Select(addr_type);
					EntryType.selectByVisibleText("Other");
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.sendKeys("BBB");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.sendKeys("CCC");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.sendKeys("XX CO");
					
					WebElement addL1 = driver.findElement(By.name("addr_addr_line_1"));
					addL1.sendKeys("Addr1");
					
					WebElement addL2 = driver.findElement(By.name("addr_addr_line_2"));
					addL2.sendKeys("Addr2");
					
					WebElement addL3 = driver.findElement(By.name("addr_addr_line_3"));
					addL3.sendKeys("Addr3");
					
					WebElement city = driver.findElement(By.name("addr_city"));
					city.sendKeys("London");
					
					WebElement province = driver.findElement(By.name("addr_region"));
					province.sendKeys("ON");
					
					WebElement country = driver.findElement(By.name("addr_country"));
					country.sendKeys("Canada");
					
					WebElement postalC = driver.findElement(By.name("addr_post_code"));
					postalC.sendKeys("N6H 0K8");
					
					WebElement email1 = driver.findElement(By.name("addr_email_1"));
					email1.sendKeys("bb@cc.com");
					
					WebElement email2 = driver.findElement(By.name("addr_email_2"));
					email2.sendKeys("aa@bb.com");
					
					WebElement email3 = driver.findElement(By.name("addr_email_3"));
					email3.sendKeys("dd@cc.com");
					
					WebElement phoneType1 = driver.findElement(By.name("addr_phone_1_type"));
					Select PhoneType1 = new Select(phoneType1);
					PhoneType1.selectByVisibleText("Home");
					
					WebElement phoneNum1 = driver.findElement(By.name("addr_phone_1"));
					phoneNum1.sendKeys("11223344");
					
					WebElement phoneType2 = driver.findElement(By.name("addr_phone_2_type"));
					Select PhoneType2 = new Select(phoneType2);
					PhoneType2.selectByVisibleText("Work");
					
					WebElement phoneNum2 = driver.findElement(By.name("addr_phone_2"));
					phoneNum2.sendKeys("22334455");
					
					WebElement phoneType3 = driver.findElement(By.name("addr_phone_3_type"));
					Select PhoneType3 = new Select(phoneType3);
					PhoneType3.selectByVisibleText("Mobile");
					
					WebElement phoneNum3 = driver.findElement(By.name("addr_phone_3"));
					phoneNum3.sendKeys("33445566");
					
					WebElement website1 = driver.findElement(By.name("addr_web_url_1"));
					website1.sendKeys("www.aaa.com");
					
					WebElement website2 = driver.findElement(By.name("addr_web_url_2"));
					website2.sendKeys("www.bbb.com");
					
					WebElement website3 = driver.findElement(By.name("addr_web_url_3"));
					website3.sendKeys("www.ccc.com");
					
					WebElement save = driver.findElement(By.name("submit_button"));
					save.click();
					
					WebElement update = driver.findElement(By.xpath("/html/body/form/div/h2"));
					update.getText();
					System.out.println(update.getText());
					
					assertEquals("The new address book entry was added successfully",update.getText());
					
					WebElement contin = driver.findElement(By.xpath("/html/body/form/div/input"));
					contin.click();
					
					takesnapshot("addNewEntityOther_TC27");	
					driver.quit();

					
				}
				
				@Test
				@Order(28)
				void addInfoWithoutNamesOther()
				{
					initialize();
					WebElement add = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					add.click();
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.sendKeys("");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.sendKeys("");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.sendKeys("");
					
					WebElement addL1 = driver.findElement(By.name("addr_addr_line_1"));
					addL1.sendKeys("8484 alpha st.");
					
					
					WebElement save = driver.findElement(By.name("submit_button"));
					save.click();
					
					WebElement update = driver.findElement(By.xpath("/html/body/p"));
					update.getText();
					System.out.println(update.getText());
					
					assertEquals("An person's name or business name must be specified.",update.getText());
					takesnapshot("addInfoWithoutNamesOther_TC28");
					
					driver.quit();
				}
				
				@Test
				@Order(29)
				void addNameWithoutInfoOther()
				{
					initialize();
					WebElement add = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					add.click();
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.sendKeys("BBB");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.sendKeys("CCC");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.sendKeys("XX CO");
					
					WebElement save = driver.findElement(By.name("submit_button"));
					save.click();
					
					WebElement update = driver.findElement(By.xpath("/html/body/p"));
					update.getText();
					System.out.println(update.getText());
					
					assertEquals("At least one of the following must be entered: street/mailing address, email address, phone number or web site url.",update.getText());
					takesnapshot("addNameWithoutInfoOther_TC29");
					
					driver.quit();
				}
				@Test
				@Order(30)
				void addNewEntityThenClearOther()
				{
					initialize();
					WebElement add = driver.findElement(By.xpath("/html/body/doctype/ul/li[2]/a"));
					add.click();
					
					WebElement addr_type = driver.findElement(By.name("addr_type"));
					Select EntryType = new Select(addr_type);
					EntryType.selectByVisibleText("Other");
					
					WebElement firstName = driver.findElement(By.name("addr_first_name"));
					firstName.sendKeys("BBB");
					
					WebElement lastName = driver.findElement(By.name("addr_last_name"));
					lastName.sendKeys("CCC");
					
					WebElement bsnsName = driver.findElement(By.name("addr_business"));
					bsnsName.sendKeys("XX CO");
					
					WebElement addL1 = driver.findElement(By.name("addr_addr_line_1"));
					addL1.sendKeys("Addr1");
					
					WebElement addL2 = driver.findElement(By.name("addr_addr_line_2"));
					addL2.sendKeys("Addr2");
					
					WebElement addL3 = driver.findElement(By.name("addr_addr_line_3"));
					addL3.sendKeys("Addr3");
					
					WebElement city = driver.findElement(By.name("addr_city"));
					city.sendKeys("London");
					
					WebElement province = driver.findElement(By.name("addr_region"));
					province.sendKeys("ON");
					
					WebElement country = driver.findElement(By.name("addr_country"));
					country.sendKeys("Canada");
					
					WebElement postalC = driver.findElement(By.name("addr_post_code"));
					postalC.sendKeys("N6H 0K8");
					
					WebElement email1 = driver.findElement(By.name("addr_email_1"));
					email1.sendKeys("bb@cc.com");
					
					WebElement email2 = driver.findElement(By.name("addr_email_2"));
					email2.sendKeys("aa@bb.com");
					
					WebElement email3 = driver.findElement(By.name("addr_email_3"));
					email3.sendKeys("dd@cc.com");
					
					WebElement phoneType1 = driver.findElement(By.name("addr_phone_1_type"));
					Select PhoneType1 = new Select(phoneType1);
					PhoneType1.selectByVisibleText("Home");
					
					WebElement phoneNum1 = driver.findElement(By.name("addr_phone_1"));
					phoneNum1.sendKeys("11223344");
					
					WebElement phoneType2 = driver.findElement(By.name("addr_phone_2_type"));
					Select PhoneType2 = new Select(phoneType2);
					PhoneType2.selectByVisibleText("Work");
					
					WebElement phoneNum2 = driver.findElement(By.name("addr_phone_2"));
					phoneNum2.sendKeys("22334455");
					
					WebElement phoneType3 = driver.findElement(By.name("addr_phone_3_type"));
					Select PhoneType3 = new Select(phoneType3);
					PhoneType3.selectByVisibleText("Mobile");
					
					WebElement phoneNum3 = driver.findElement(By.name("addr_phone_3"));
					phoneNum3.sendKeys("33445566");
					
					WebElement website1 = driver.findElement(By.name("addr_web_url_1"));
					website1.sendKeys("www.aaa.com");
					
					WebElement website2 = driver.findElement(By.name("addr_web_url_2"));
					website2.sendKeys("www.bbb.com");
					
					WebElement website3 = driver.findElement(By.name("addr_web_url_3"));
					website3.sendKeys("www.ccc.com");
					
					WebElement clear = driver.findElement(By.name("reset_button"));
					clear.click();
						
					String textFieldValue = firstName.getAttribute("value");
					
					assertEquals("",textFieldValue);
					takesnapshot("addNewEntityThenClearOther_TC30");
					
					driver.quit();
					
				}
				
}