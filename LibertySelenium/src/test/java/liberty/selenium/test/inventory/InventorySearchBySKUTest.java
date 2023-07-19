package liberty.selenium.test.inventory;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import liberty.selenium.test.common.ExplicitWait;

public class InventorySearchBySKUTest {
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

//		2:After login the application go to Inventory->
		// 2.3: Search By SKU enter value and click on search button, make sure that
		// corresponding value gets displayed.
		// 2.4: Search By SKU enter value and clear it, ensure that values are
		// removed(That field must be empty).
		//
		// click on Inventory link
	//	Thread.sleep(10000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Inventory']"))).click();
		WebElement link_Inventory = ExplicitWait.waitForElementPresence(driver, By.xpath("//span[normalize-space()='Inventory']"), 5);
		link_Inventory.click();
		//Thread.sleep(4000);

		// click on setting Icon and update the values..
		//driver.findElement(By.xpath("//span[@class='p-button-icon p-c pi pi-cog']")).click();
		ExplicitWait.waitForElementPresence(driver, By.xpath("//span[@class='p-button-icon p-c pi pi-cog']"), 1).click();
		//Thread.sleep(2000);

		WebElement coElement = driver
				.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[1]"));
		coElement.click();
//		By locator=By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[1]");
//		WebElement coEl = ExplicitWait.waitForElementPresence(driver, locator, 1);
//		coEl.click();
		//driver.findElement(By.xpath("//li[normalize-space()='00001']")).click();
		//Thread.sleep(3000);
	
		//WebElement divElement = driver.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[2]"));
//		divElement.click();
		ExplicitWait.waitForElementPresence(driver, By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[2]"), 1).click();
		
		
		driver.findElement(By.xpath("//li[text()='WC1']")).click();

		//Thread.sleep(3000);
		WebElement whseElement = driver.findElement(By.xpath("(//button[@type='button'])[7]"));
		whseElement.click();
		driver.findElement(By.xpath("//li[text()='WC1']")).click();

		driver.findElement(By.xpath("//span[@class='p-inputswitch-slider']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='APPLY']")).click();

		// 1:SKU Search
		// this is for search By SKU:
		//Thread.sleep(10000);

//		WebElement element = driver.findElement(By.xpath("//input[@id='sku']"));
		WebElement element = ExplicitWait.waitForElementPresence(driver, By.xpath("//input[@id='sku']"), 5);
		element.sendKeys("SDLCS60");

		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='p-button-label p-c'][normalize-space()='Search'])[2]")).click();

		//Thread.sleep(30000);
		WebElement BRCDelement = driver.findElement(By.xpath("//td[contains(text(),'SDLCS60 C R')]"));
		BRCDelement.click();

		//Thread.sleep(5000);
		String actualData = BRCDelement.getText();
		//Thread.sleep(5000);

		String expectedData = "SDLCS60 C R";
		//Thread.sleep(5000);

		if (actualData.equals(expectedData)) {
			System.out.println("Test case Passed! because it matched with BRCD value after displaying data.....");
		} else {
			System.out.println("Test case failled...");

		}

		//check all data contains SDLCS60
		System.out.println("All Data");
		List<WebElement> SKUs = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));

		String data = null;
		for (WebElement e : SKUs) {
			 data = e.getText();//mandtatory step
			if(data.startsWith("SDLCS60")) {
				System.out.println("Test case passed because all data can starts with SDLCS60=>  "+data);
			}
			else {
				System.out.println("Test case failled because all data can't starts with SDLCS60  "+data);
			}
		}
	

		
		/*
		 * // 2:SKU field clear.. // this is for clear SKU field and verify the input
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
	//	Thread.sleep(10000);
		//driver.quit();
	}
}
