package liberty.selenium.test.inventory.shipments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShipmentsSearchByOrderTest {
	
	static WebDriverWait wait;
	
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
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
		WebElement shipmentsElement = driver.findElement(By.xpath("//span[normalize-space()='Shipments']"));
		wait=new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.elementToBeClickable(shipmentsElement)).click();
		
		
//		
		
		
	// click on setting Icon and update the values..
	
		Thread.sleep(10000);
			WebElement settingIcon = driver.findElement(By.xpath("//span[@class='p-button-icon p-c pi pi-cog']"));
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(settingIcon)).click();
			
			
			
			Thread.sleep(5000);

		WebElement coElement = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/button[1]/span[1]"));
//			coElement.click();			
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//li[text()='00001']")).click();
//			Thread.sleep(3000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", coElement);
			
			Thread.sleep(2000);
			WebElement divElement = driver
					.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[2]"));
			divElement.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[text()='WC1']")).click();

			Thread.sleep(3000);
			WebElement whseElement = driver.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[3]"));
			whseElement.click();
			driver.findElement(By.xpath("//li[text()='WC1']")).click();

			driver.findElement(By.xpath("//span[@class='p-inputswitch-slider']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@class='p-button p-component'])[3]")).click();

			Thread.sleep(4000);
			/*
			driver.findElement(By.xpath("//input[@id='order']")).sendKeys("28915834");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();

			//Scrolldown the page
			//JavascriptExecutor js=(JavascriptExecutor)driver;

			js.executeScript("window.scrollBy(0,350)", "");
	        
			
			//verify displyed data
			WebElement dispData = driver.findElement(By.xpath("//td[normalize-space()='28915834']"));
			String actualData = dispData.getText();
	
			String expectedData="28915834";
			
			if(actualData.equals(expectedData)) {
				System.out.println("TestCase Passed");
			}
			else{
				System.out.println("TestCase Failled");

			}
			*/
			
			
			
			 // this is for clear and verify the input field is empty...

			  Thread.sleep(10000);
			
			  WebElement searchField =driver.findElement(By.xpath("//input[@id='order']"));
			  searchField.sendKeys("28915834"); 
			  Thread.sleep(2000); 
			  js.executeScript("window.scrollBy(0,80)", "");
			  driver.findElement(By.xpath("//span[@class='p-button-icon p-c pi pi-times-circle p-button-icon-left']"))
			  .click();
			  
			  
			  // Check whether input field is blank 
			  String textInsideInputBox =searchField.getAttribute("value"); 
			  if(textInsideInputBox.isEmpty()) {
			  System.out.println("Search By Order Input field is empty"); 
			  } 
			  else {
			  System.out.println("Search By Order Input field is not empty.."); 
			  }
	
	
}
}
