package liberty.selenium.tests;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReceivingSearchTest {

	static WebDriverWait wait;
	
	@Test
	public void serachByPo() throws InterruptedException {
		// launch chrome browser
				WebDriver driver = new ChromeDriver();
				// maximize the window..
				driver.manage().window().maximize();
				//Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				// open liberty application url.
				driver.get("https://liberty-portal-react-test.kus.logistics.corp/");
				System.out.println("Current URL Before Login: " + driver.getCurrentUrl());
				System.out.println("Current Title Before Login: " + driver.getTitle());
				// locate the element and click on login with SSO.
				driver.findElement(By.xpath("//span[@class='p-button-label p-c']")).click();
				// locate element and enter username
				driver.findElement(By.id("loginForm:username")).sendKeys("nivargiv");
				// locate the element and password
				driver.findElement(By.id("loginForm:password")).sendKeys("Speedster@7757888888");
				// locate the element and click on login button
				driver.findElement(By.id("loginForm:loginButton")).click();
				System.out.println("Current URL After login: " + driver.getCurrentUrl());
				System.out.println("Current Title After login: " + driver.getTitle());

				Thread.sleep(15000);
				WebElement receivingElement = driver.findElement(By.xpath("//span[normalize-space()='Receiving']"));
				wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.elementToBeClickable(receivingElement)).click();

//					

				// click on setting Icon and update the values..

				Thread.sleep(10000);
				WebElement settingIcon = driver.findElement(By.xpath("//button[@class='p-button p-component p-button-icon-only']"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.elementToBeClickable(settingIcon)).click();

				Thread.sleep(5000);

				WebElement coElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[1]"));
//						coElement.click();			
//						Thread.sleep(3000);
//						driver.findElement(By.xpath("//li[text()='00001']")).click();
//						Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", coElement);

				Thread.sleep(2000);
				WebElement divElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[2]"));
				divElement.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[text()='WC1']")).click();

				Thread.sleep(3000);
				WebElement whseElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[3]"));
				whseElement.click();
				driver.findElement(By.xpath("//li[text()='WC1']")).click();

				driver.findElement(By.xpath("//span[@class='p-inputswitch-slider']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@class='p-button p-component'])[3]")).click();
				Thread.sleep(4000);
				js.executeScript("window.scrollBy(0,80)", "");
				Thread.sleep(2000);
				
				
				//click on Po field
				
				driver.findElement(By.xpath("(//input[@id='po'])[1]")).sendKeys("50267");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@class='p-button p-component'])[1]")).click();

				//Scrolldown the page
				//JavascriptExecutor js=(JavascriptExecutor)driver;

				js.executeScript("window.scrollBy(0,350)", "");
		        
				
				//verify displyed data
				Thread.sleep(5000);
//				WebElement dispData = driver.findElement(By.xpath("//td[normalize-space()='LIBERTY HARDWARE MFG CORP']"));
//				String actualData = dispData.getText();
		//
//				String expectedData="LIBERTY HARDWARE MFG CORP";
//				
				WebElement dispData = driver.findElement(By.xpath("//a[normalize-space()='50267']"));
				String actualData = dispData.getText();

				String expectedData="50267";
				
				if(actualData.equals(expectedData)) {
					System.out.println("TestCase Passed");
				}
				else{
					System.out.println("TestCase Failled");

				}
				
				
				/*

				 // this is for clear and verify the PO input field is empty...

				  Thread.sleep(10000);
				
				  WebElement searchField =driver.findElement(By.xpath("(//input[@id='po'])[1]"));
				  searchField.sendKeys("28914"); 
				  Thread.sleep(2000); 
				  js.executeScript("window.scrollBy(0,80)", "");
				  driver.findElement(By.xpath("//span[normalize-space()='Clear']"))
				  .click();
				  
				  
				  // Check whether input field is blank 
				  String textInsideInputBox =searchField.getAttribute("value"); 
				  if(textInsideInputBox.isEmpty()) {
				  System.out.println("Search By PO Input field is empty"); 
				  } 
				  else {
				  System.out.println("Search By PO Input field is not empty.."); 
				  }
		*/
				
	}
	
	@Test
	public void searchByDate() throws InterruptedException {
		// launch chrome browser
				WebDriver driver = new ChromeDriver();
				// maximize the window..
				driver.manage().window().maximize();
				//Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				// open liberty application url.
				driver.get("https://liberty-portal-react-test.kus.logistics.corp/");
				System.out.println("Current URL Before Login: " + driver.getCurrentUrl());
				System.out.println("Current Title Before Login: " + driver.getTitle());
				// locate the element and click on login with SSO.
				driver.findElement(By.xpath("//span[@class='p-button-label p-c']")).click();
				// locate element and enter username
				driver.findElement(By.id("loginForm:username")).sendKeys("nivargiv");
				// locate the element and password
				driver.findElement(By.id("loginForm:password")).sendKeys("Speedster@7757888888");
				// locate the element and click on login button
				driver.findElement(By.id("loginForm:loginButton")).click();
				System.out.println("Current URL After login: " + driver.getCurrentUrl());
				System.out.println("Current Title After login: " + driver.getTitle());

				Thread.sleep(15000);
				WebElement receivingElement = driver.findElement(By.xpath("//span[normalize-space()='Receiving']"));
				wait = new WebDriverWait(driver, Duration.ofSeconds(500));
				wait.until(ExpectedConditions.elementToBeClickable(receivingElement)).click();

//					

				// click on setting Icon and update the values..

				Thread.sleep(10000);
				WebElement settingIcon = driver.findElement(By.xpath("//button[@class='p-button p-component p-button-icon-only']"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.elementToBeClickable(settingIcon)).click();

				Thread.sleep(5000);

				WebElement coElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[1]"));
//						coElement.click();			
//						Thread.sleep(3000);
//						driver.findElement(By.xpath("//li[text()='00001']")).click();
//						Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", coElement);

				Thread.sleep(2000);
				WebElement divElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[2]"));
				divElement.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[text()='WC1']")).click();

				Thread.sleep(3000);
				WebElement whseElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[3]"));
				whseElement.click();
				driver.findElement(By.xpath("//li[text()='WC1']")).click();

				driver.findElement(By.xpath("//span[@class='p-inputswitch-slider']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@class='p-button p-component'])[3]")).click();
				Thread.sleep(4000);
				js.executeScript("window.scrollBy(0,80)", "");
				Thread.sleep(2000);
				
				// click on calender for from date
						driver.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-calendar'])[1]")).click();
						Thread.sleep(2000);
						// choose month
						WebElement chooseMonth = driver.findElement(By.xpath("//select[@class='p-datepicker-month']"));
						Select dropDwnMonth = new Select(chooseMonth);
						dropDwnMonth.selectByVisibleText("July");
						Thread.sleep(2000);
						WebElement chooseYear = driver.findElement(By.xpath("//select[@class='p-datepicker-year']"));
						Select dropDwnYear = new Select(chooseYear);
						dropDwnYear.selectByVisibleText("2023");
						Thread.sleep(2000); // select day
						String frdate = "5";
						driver.findElement(By.xpath("//td[not(contains(@class,'p-highlight'))]/span[text()='" + frdate + "']")).click();

						// click on toDate
						String toDate = "20";
						driver.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-calendar'])[2]")).click();
						Thread.sleep(2000); // choose month
						WebElement chooseMth = driver.findElement(By.xpath("//select[@class='p-datepicker-month']"));
						Select dropDwnMth = new Select(chooseMth);
						dropDwnMth.selectByVisibleText("July");
						Thread.sleep(2000);
						WebElement chooseYr = driver.findElement(By.xpath("//select[@class='p-datepicker-year']"));
						Select dropDwnYr = new Select(chooseYr);
						dropDwnYr.selectByVisibleText("2023");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//td[not(contains(@class,'p-highlight'))]/span[text()='" + toDate + "']")).click();

						Thread.sleep(2000);
						driver.findElement(By.xpath("//span[normalize-space()='Search']")).click();

						js.executeScript("window.scrollBy(0,350)", "");

						Thread.sleep(5000);
						String actualVendorName = driver.findElement(By.xpath("//td[normalize-space()='MEGASTAR HARDWARE MFG COMPANY LTD']")).getText();
						String expectedVendorName = "MEGASTAR HARDWARE MFG COMPANY LTD";

						if (actualVendorName.equals(expectedVendorName)) {
							System.out.println("TestCase is Passed Because vendor name is matched with expectedVendor.");
						} else {
							System.out.println("TestCase is failled Because vendor name is not matched with expectedVendor.");
						}
				
						//Print Header
						List<WebElement> headers = driver.findElements(By.xpath("//table//thead//th"));
				
						System.out.println("Headers");
						for (WebElement webElement : headers) {
							String val = webElement.getText();
							System.out.print(val+"\t");
						}
						System.out.println("All Data");
						
						//Print Data
						List<WebElement> data = driver.findElements(By.xpath("//table//tbody//tr//td"));
							for (WebElement webElement : data) {
							String val = webElement.getText();
							System.out.print(val+"\t");
						}
						
				
				/*
				
				// This is for clear date fields 
				// click on calender for from date
						  WebElement fromDate = driver .findElement(By.xpath("//span[@id='fromDate']//span[@class='p-button-icon p-c pi pi-calendar']"));
						  fromDate.click(); 
						  Thread.sleep(2000); 
						  // choose month 
						  WebElement chooseMonth = driver.findElement(By.xpath("//select[@class='p-datepicker-month']")); 
						  Select dropDwnMonth = new Select(chooseMonth);
						  dropDwnMonth.selectByVisibleText("July"); 
						  Thread.sleep(2000); 
						  WebElement chooseYear =driver.findElement(By.xpath("//select[@class='p-datepicker-year']")); Select
						  dropDwnYear = new Select(chooseYear);
						  dropDwnYear.selectByVisibleText("2023"); 
						  Thread.sleep(2000); 
						  // select day
						  String frdate = "5"; driver.findElement(By.xpath(
						  "//td[not(contains(@class,'p-highlight'))]/span[text()='" + frdate + "']")).click();
						  
						  // click on toDate 
						  String toDate = "20";
						  WebElement toDates = driver.findElement(By.xpath("//span[@id='toDate']//input[@type='text']"));
						  toDates.click(); 
						  Thread.sleep(2000); 
						  // choose month 
						  WebElement chooseMth =driver.findElement(By.xpath("//select[@class='p-datepicker-month']")); 
						  Select dropDwnMth = new Select(chooseMth); 
						  dropDwnMth.selectByVisibleText("July");
						  Thread.sleep(2000); 
						  WebElement chooseYr =driver.findElement(By.xpath("//select[@class='p-datepicker-year']")); Select
						  dropDwnYr = new Select(chooseYr); 
						  dropDwnYr.selectByVisibleText("2023");
						  Thread.sleep(2000); driver.findElement(By.xpath("//td[not(contains(@class,'p-highlight'))]/span[text()='" + toDate + "']")).click(); Thread.sleep(2000);
						  
						  js.executeScript("window.scrollBy(0,80)", ""); 
						  //clear the dates
						  driver.findElement(By.xpath("//span[@class='p-button-icon p-c pi pi-times-circle p-button-icon-left']")) .click();
						  
						  WebElement fromDates =driver.findElement(By.xpath("//span[@id='fromDate']//input[@type='text']"));
						  WebElement toDatess =driver.findElement(By.xpath("//span[@id='toDate']//input[@type='text']"));
						  // Check whether input field is blank for fromDate 
						  String fromDateField = fromDates.getAttribute("value"); 
						  // Check whether input field is blank for fromDate 
						  String toDateField = toDatess.getAttribute("value"); 
						  if(fromDateField.isBlank() && toDateField.isBlank()) 
						  {
						  System.out.println("FromDate and toDate Input field is empty"); 
						  } 
							
						  else {
							  System.out.println("FromDate and toDate Input field is not empty..");
							  }
							 */
	}
	
	@Test
	public void searchByShipment() throws InterruptedException {
		// launch chrome browser
				WebDriver driver = new ChromeDriver();
				// maximize the window..
				driver.manage().window().maximize();
				//Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				// open liberty application url.
				driver.get("https://liberty-portal-react-test.kus.logistics.corp/");
				System.out.println("Current URL Before Login: " + driver.getCurrentUrl());
				System.out.println("Current Title Before Login: " + driver.getTitle());
				// locate the element and click on login with SSO.
				driver.findElement(By.xpath("//span[@class='p-button-label p-c']")).click();
				// locate element and enter username
				driver.findElement(By.id("loginForm:username")).sendKeys("nivargiv");
				// locate the element and password
				driver.findElement(By.id("loginForm:password")).sendKeys("Speedster@7757888888");
				// locate the element and click on login button
				driver.findElement(By.id("loginForm:loginButton")).click();
				System.out.println("Current URL After login: " + driver.getCurrentUrl());
				System.out.println("Current Title After login: " + driver.getTitle());

				Thread.sleep(15000);
				WebElement receivingElement = driver.findElement(By.xpath("//span[normalize-space()='Receiving']"));
				wait = new WebDriverWait(driver, Duration.ofSeconds(500));
				wait.until(ExpectedConditions.elementToBeClickable(receivingElement)).click();

//					

				// click on setting Icon and update the values..

				Thread.sleep(10000);
				WebElement settingIcon = driver.findElement(By.xpath("//button[@class='p-button p-component p-button-icon-only']"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.elementToBeClickable(settingIcon)).click();

				Thread.sleep(5000);

				WebElement coElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[1]"));
//						coElement.click();			
//						Thread.sleep(3000);
//						driver.findElement(By.xpath("//li[text()='00001']")).click();
//						Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", coElement);

				Thread.sleep(2000);
				WebElement divElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[2]"));
				divElement.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[text()='WC1']")).click();

				Thread.sleep(3000);
				WebElement whseElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[3]"));
				whseElement.click();
				driver.findElement(By.xpath("//li[text()='WC1']")).click();

				driver.findElement(By.xpath("//span[@class='p-inputswitch-slider']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@class='p-button p-component'])[3]")).click();
				Thread.sleep(4000);
				js.executeScript("window.scrollBy(0,80)", "");
				Thread.sleep(2000);
				
				
		/*		//click on Shipment field
				
				driver.findElement(By.xpath("(//input[@id='po'])[2]")).sendKeys("50267");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@class='p-button p-component'])[1]")).click();

				//Scrolldown the page
				//JavascriptExecutor js=(JavascriptExecutor)driver;

				js.executeScript("window.scrollBy(0,350)", "");
		        
				
				//verify displyed data
				WebElement dispData = driver.findElement(By.xpath("//a[normalize-space()='50267']"));
				String actualData = dispData.getText();

				String expectedData="50267";
				
				if(actualData.equals(expectedData)) {
					System.out.println("TestCase Passed");
				}
				else{
					System.out.println("TestCase Failled");

				}
				
				*/
				

				 // this is for clear and verify the Shipment input field is empty...

				  Thread.sleep(10000);
				
				  WebElement searchField =driver.findElement(By.xpath("(//input[@id='po'])[2]"));
				  searchField.sendKeys("28914"); 
				  Thread.sleep(2000); 
				  js.executeScript("window.scrollBy(0,80)", "");
				  driver.findElement(By.xpath("//span[normalize-space()='Clear']"))
				  .click();
				  
				  
				  // Check whether input field is blank 
				  String textInsideInputBox =searchField.getAttribute("value"); 
				  if(textInsideInputBox.isEmpty()) {
				  System.out.println("Test passed! beacuse Search By Shipment Input field is empty"); 
				  } 
				  else {
				  System.out.println("Test failled! beacuse Search By Shipment Input field is not empty.."); 
				  }

	}
	
	@Test
	public void searchByStatus() throws InterruptedException {
		// launch chrome browser
				WebDriver driver = new ChromeDriver();
				// maximize the window..
				driver.manage().window().maximize();
				//Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				// open liberty application url.
				driver.get("https://liberty-portal-react-test.kus.logistics.corp/");
				System.out.println("Current URL Before Login: " + driver.getCurrentUrl());
				System.out.println("Current Title Before Login: " + driver.getTitle());
				// locate the element and click on login with SSO.
				driver.findElement(By.xpath("//span[@class='p-button-label p-c']")).click();
				// locate element and enter username
				driver.findElement(By.id("loginForm:username")).sendKeys("nivargiv");
				// locate the element and password
				driver.findElement(By.id("loginForm:password")).sendKeys("Speedster@7757888888");
				// locate the element and click on login button
				driver.findElement(By.id("loginForm:loginButton")).click();
				System.out.println("Current URL After login: " + driver.getCurrentUrl());
				System.out.println("Current Title After login: " + driver.getTitle());

				Thread.sleep(15000);
				WebElement receivingElement = driver.findElement(By.xpath("//span[normalize-space()='Receiving']"));
				wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.elementToBeClickable(receivingElement)).click();

//					

				// click on setting Icon and update the values..

				Thread.sleep(10000);
				WebElement settingIcon = driver.findElement(By.xpath("//button[@class='p-button p-component p-button-icon-only']"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.elementToBeClickable(settingIcon)).click();

				Thread.sleep(5000);

				WebElement coElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[1]"));
//						coElement.click();			
//						Thread.sleep(3000);
//						driver.findElement(By.xpath("//li[text()='00001']")).click();
//						Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", coElement);

				Thread.sleep(2000);
				WebElement divElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[2]"));
				divElement.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[text()='WC1']")).click();

				Thread.sleep(3000);
				WebElement whseElement = driver
						.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[3]"));
				whseElement.click();
				driver.findElement(By.xpath("//li[text()='WC1']")).click();

				driver.findElement(By.xpath("//span[@class='p-inputswitch-slider']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@class='p-button p-component'])[3]")).click();
				Thread.sleep(4000);
				js.executeScript("window.scrollBy(0,80)", "");
				Thread.sleep(2000);
				
			
				//click on from status button
						driver.findElement(By.xpath(
								"//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/span[1]"))
								.click();
						//select In-Transit
						driver.findElement(By.xpath("//li[@aria-label='In-Transit']")).click();
						Thread.sleep(2000);
						//click on to Status button
						driver.findElement(By.xpath(
								"//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]"))
								.click();
						//select In Pre-Receive Trailer
						driver.findElement(By.xpath("//li[@aria-label='Pre-Receive Trailer']")).click();
						Thread.sleep(2000);
						//click on search button
						driver.findElement(By.xpath("//span[normalize-space()='Search']")).click();
						Thread.sleep(5000);
						js.executeScript("window.scrollBy(0,550)", "");

						Thread.sleep(5000);
						//locate first first status element and get value
						WebElement status = driver.findElement(By.xpath("(//div[@class='p-grid'])[8]"));
						String actualStatus = status.getText();
						String expectedStatus="In-Transit";
						
						if(actualStatus.equals(expectedStatus))
								{
							System.out.println("Test case passed beacuse actual status is similar with expected status..");
						}
						else{
							System.out.println("Test case failled..beacuse actual status is not similar with expected status..");
						}
						
						//Headers
						System.out.println("HEADERS===>");
						List<WebElement> headers = driver.findElements(By.xpath("//table//thead//th"));
						for (WebElement webElement : headers) {
							String val = webElement.getText();
							System.out.println(val);
							
						}
						System.out.println("DATA===>>");
						//data
						List<WebElement> datas = driver.findElements(By.xpath("//table//tbody//tr//td"));
						for (WebElement webElement : datas) {
							String val = webElement.getText();
							System.out.println(val);
							
						}
						
				/*
				// this is for clear and verify the FromStatus and toStatus dropdown is empty...
				  
				  Thread.sleep(10000);
				  
				  WebElement fromStatus = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]"));
				  fromStatus.click();
					//select Printed
					driver.findElement(By.xpath("//li[@aria-label='In-Transit']")).click();
					Thread.sleep(2000);
					//click on to Status button
					WebElement toStatus = driver.findElement(By.xpath(
							"//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]"));
					toStatus.click();
					//select In Packing
					driver.findElement(By.xpath("//li[@aria-label='Pre-Receive Trailer']")).click();
					Thread.sleep(2000);
					//click on clear button
				  driver.findElement(By.xpath("//span[@class='p-button-icon p-c pi pi-times-circle p-button-icon-left']"
				  )) .click();
				  

				  // Check whether input field is blank 
				  WebElement fromStatusField = driver.findElement(By.xpath("(//div[@class='p-dropdown p-component p-inputwrapper'])[1]"));
					WebElement toStatuss = driver.findElement(By.xpath("(//div[@class='p-dropdown p-component p-inputwrapper'])[2]"));
					// Check whether input field is blank for fromstatus
						boolean fromStatusSelect = fromStatusField.isSelected();
					// Check whether input field is blank for toStatus
						boolean toStatusSelect = toStatuss.isSelected();
					
					
					if(!fromStatusSelect && !toStatusSelect) 
					{
						System.out.println("FromStatus and toStatus dropdown field is empty");
					} else 
					{
						System.out.println("FromStatus and toStatus dropdown field is not empty..");
					}
		*/
				
	}
}
