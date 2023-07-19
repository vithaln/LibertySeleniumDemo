package liberty.selenium.test.inventory.receiving;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReceivingSearchByStatusTest {

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
		WebElement receivingElement = driver.findElement(By.xpath("//span[normalize-space()='Receiving']"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
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
//				coElement.click();			
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("//li[text()='00001']")).click();
//				Thread.sleep(3000);
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
