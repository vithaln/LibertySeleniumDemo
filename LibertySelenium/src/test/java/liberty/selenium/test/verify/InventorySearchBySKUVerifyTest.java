package liberty.selenium.test.verify;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InventorySearchBySKUVerifyTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// launch chrome browser
		WebDriver driver = new ChromeDriver();
		// maximize the window..
		driver.manage().window().maximize();

//		TASK 1
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

//		2:After login the application go to Inventory->
		// 2.3: Search By SKU enter value and click on search button, make sure that
		// corresponding value gets displayed.
		// 2.4: Search By SKU enter value and clear it, ensure that values are
		// removed(That field must be empty).
		//
		// click on Inventory link
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Inventory']"))).click();
		Thread.sleep(4000);

		// click on setting Icon and update the values..
		driver.findElement(By.xpath("//span[@class='p-button-icon p-c pi pi-cog']")).click();
		Thread.sleep(2000);

		WebElement coElement = driver
				.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[1]"));
		coElement.click();
		driver.findElement(By.xpath("//li[text()='00001']")).click();
		Thread.sleep(3000);

		WebElement divElement = driver
				.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[2]"));
		divElement.click();
		driver.findElement(By.xpath("//li[text()='WC1']")).click();

		Thread.sleep(3000);
		WebElement whseElement = driver.findElement(By.xpath("(//button[@type='button'])[7]"));
		whseElement.click();
		driver.findElement(By.xpath("//li[text()='WC1']")).click();

		driver.findElement(By.xpath("//span[@class='p-inputswitch-slider']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='APPLY']")).click();

		// 1:SKU Search
		// this is for search By SKU:
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//input[@id='sku']"));
		element.sendKeys("SDLCS60");

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='p-button-label p-c'][normalize-space()='Search'])[2]")).click();

		Thread.sleep(30000);
		WebElement BRCDelement = driver.findElement(By.xpath("//td[contains(text(),'SDLCS60 C R')]"));
		BRCDelement.click();

		Thread.sleep(5000);
		String actualData = BRCDelement.getText();
		Thread.sleep(5000);

		String expectedData = "SDLCS60 C R";
		Thread.sleep(5000);

		if (actualData.equals(expectedData)) {
			System.out.println("Test case Passed! because it matched with BRCD value after displaying data.....");
		} else {
			System.out.println("Test case failled...");

		}
		
		//SOME ADDITONAL CONCEPTS TO VERIFYIING THE DATA DISPLAYING...
		
		System.out.println("Verify the Headers which are displayed in screen.. ");

		List<WebElement> allHeaders = driver.findElements(By.xpath("//table//th"));
		if(allHeaders.size()==7) {
			System.out.println("The size is verifyied it's 7.");
		}
		else {
			System.out.println("The siz is verified but it is not mathced at the given condition");
		}
	
		System.out.println("===============");
		boolean sku=false;
		for(WebElement e:allHeaders) {
			String value = e.getText();
			System.out.println(value);
			if(value.contains("SKU")) {
				sku=true;
				break;
				
			}
		}
		if(sku==true) {
			System.out.println("Test case is passed..");
		}
		else {
			System.out.println("Test case is failled..");
		}
		
		
		
		/*
		 * // 2:SKU field clear.. 
		 * // this is for clear SKU field and verify the input
		 * field is empty...
		 * 
		 * WebElement searchSKUField =
		 * driver.findElement(By.xpath("(//input[@id='sku'])[1]"));
		 * searchSKUField.sendKeys("SDLCS60"); Thread.sleep(2000);
		 * driver.findElement(By.
		 * xpath("(//span[@class='p-button-icon p-c pi pi-times-circle p-button-icon-left'])[2]"
		 * )).click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * // Check whether input field is blank String textInsideInputBoxForSku
		 * =searchSKUField.getAttribute("value"); if(textInsideInputBoxForSku.isEmpty())
		 * { System.out.println("Search By SKU Input field is empty"); } else {
		 * System.out.println("Search By SKU Input field is not empty.."); }
		 */
		Thread.sleep(10000);
		driver.quit();
	}
}
