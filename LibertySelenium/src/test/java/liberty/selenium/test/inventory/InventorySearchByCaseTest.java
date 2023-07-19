package liberty.selenium.test.inventory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import liberty.selenium.test.common.ExplicitWait;

public class InventorySearchByCaseTest {
public static void main(String[] args) throws InterruptedException {
	
	// launch chrome browser
	WebDriver driver = new ChromeDriver();
	// maximize the window..
	driver.manage().window().maximize();

	//Implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	// open liberty application url.
	driver.get("https://liberty-portal-react-test.kus.logistics.corp/");

	// locate the element and click on login with SSO.
	driver.findElement(By.xpath("//span[@class='p-button-label p-c']")).click();
	
	// locate element and enter username
	driver.findElement(By.id("loginForm:username")).sendKeys("nivargiv");
	
	// locate the element and password
	driver.findElement(By.id("loginForm:password")).sendKeys("Speedster@7757888888");
	
	// locate the element and click on login button
	driver.findElement(By.id("loginForm:loginButton")).click();

//	2:After login the application go to Inventory->
//    2.1: Search By Case enter value and make sure that related value is displayed.
//   2.2 Search By Case enter value and clear it, ensure that values are removed.

	
	// click on Inventory link
	//Thread.sleep(30000);

	By linkInventory=By.xpath("//span[normalize-space()='Inventory']");
	WebElement lkInventory = ExplicitWait.waitForElementPresence(driver, linkInventory, 2);
	lkInventory.click();
	//Thread.sleep(4000);

	// click on setting Icon and update the values..
	By iconBtn =By.xpath("//span[@class='p-button-icon p-c pi pi-cog']");
	WebElement settingIcon = ExplicitWait.waitForElementPresence(driver, iconBtn, 5);
	settingIcon.click();
	
//	Thread.sleep(2000);

	By coElement =By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[1]");
	WebElement coClick = ExplicitWait.waitForElementPresence(driver, coElement, 5);
	coClick.click();
	
	//driver.findElement(By.xpath("//li[text()='00001']")).click();
	//Thread.sleep(3000);

	By divElement =By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[2]");
	WebElement divClick = ExplicitWait.waitForElementPresence(driver, divElement, 5);
	divClick.click();
	
	driver.findElement(By.xpath("//li[text()='WC1']")).click();

//	Thread.sleep(3000);
	By whseElement = By.xpath("(//button[@type='button'])[7]");
	WebElement whseClick = ExplicitWait.waitForElementPresence(driver, whseElement, 5);
	whseClick.click();
	
	driver.findElement(By.xpath("//li[text()='WC1']")).click();

	driver.findElement(By.xpath("//span[@class='p-inputswitch-slider']")).click();
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//span[normalize-space()='APPLY']")).click();
	
	
	  //this is for search By Case:
	  driver.findElement(By.xpath("//input[@id='caseNo']")).sendKeys("1973123");
	 // Thread.sleep(2000);
	  driver.findElement(By.xpath("(//span[@class='p-button-label p-c'][normalize-space()='Search'])[1]")
	  ).click(); 
	//  Thread.sleep(5000);

	  WebElement element = driver.findElement(By.xpath("//a[contains(text(),'#1973123')]"));
	  String actualData = element.getText();
	  String expectedData="#1973123 00";
	  
	  if(actualData.equals(expectedData))
	  {
		  System.out.println("Test case Passed...");
	  }	  
	  else {
		  System.out.println("Test case failled...");

	  }
	  //PRINT Headers
	  List<WebElement> headers = driver.findElements(By.xpath("//table//thead//th"));
	  System.out.println("All headers");
	  for(WebElement e:headers) {
		  String header = e.getText();
		  System.out.print(header+"\t");
	  }	
	  //PRINT DATA
	  List<WebElement> datas = driver.findElements(By.xpath("//table//tbody/tr//td"));
//	  System.out.println("All Data");
	  System.out.println();
	  for(WebElement e:datas) {
		  String data = e.getText();
		  System.out.print(data+"\t");
	  }
	  /*
	  // this is for clear and verify the input field is empty...

		  Thread.sleep(10000);
		
		  WebElement searchField =driver.findElement(By.xpath("//input[@id='caseNo']"));
		  searchField.sendKeys("1401235"); 
		  Thread.sleep(2000); 
		  driver.findElement(By.xpath("(//span[@class='p-button-label p-c'][normalize-space()='Clear'])[1]"))
		  .click();
		  
		  
		  // Check whether input field is blank 
		  String textInsideInputBox =searchField.getAttribute("value"); 
		  if(textInsideInputBox.isEmpty()) {
		  System.out.println("Search By Case Input field is empty"); 
		  } 
		  else {
		  System.out.println("Search By Case Input field is not empty.."); 
		  }
		  */
		  
		  
}
}
