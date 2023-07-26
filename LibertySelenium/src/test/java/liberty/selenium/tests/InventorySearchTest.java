package liberty.selenium.tests;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(Lifecycle.PER_CLASS)
public class InventorySearchTest {

	// Generic method
	public static WebElement waitForElementPresence(WebDriver driver, By locator, int timout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(timout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);

	}

	 WebDriver driver;
	 WebDriverWait wait;

	@BeforeAll
	public void setUp() throws InterruptedException {
		// launch chrome browser
		driver = new ChromeDriver();
		// maximize the window..
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// open liberty portal application url.
		//Test environment
	 //driver.get("https://liberty-portal-react-test.kus.logistics.corp/");
	 //UAT environment
		driver.get("https://liberty-portal-uat.cevalogistics.com/login");
		// locate the element and click on login with SSO.
		driver.findElement(By.xpath("//span[@class='p-button-label p-c']")).click();

		// locate element and enter username
		driver.findElement(By.id("loginForm:username")).sendKeys("nivargiv");

		// locate the element and password
		driver.findElement(By.id("loginForm:password")).sendKeys("Speedster@7757888888");

		// locate the element and click on login button
		driver.findElement(By.id("loginForm:loginButton")).click();
		// click on Inventory link
		Thread.sleep(20000);

		By linkInventory = By.xpath("//span[normalize-space()='Inventory']");
		WebElement lkInventory = waitForElementPresence(driver, linkInventory, 2);
		lkInventory.click();
		// Thread.sleep(4000);

		// click on setting Icon and update the values..
		By iconBtn = By.xpath("//span[@class='p-button-icon p-c pi pi-cog']");
		WebElement settingIcon = waitForElementPresence(driver, iconBtn, 1);
		settingIcon.click();

//				Thread.sleep(2000);

		By coElement = By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[1]");
		WebElement coClick = waitForElementPresence(driver, coElement, 1);
		coClick.click();

		// driver.findElement(By.xpath("//li[text()='00001']")).click();
		// Thread.sleep(3000);

		By divElement = By.xpath("(//span[@class='p-button-icon p-c pi pi-chevron-down'])[2]");
		WebElement divClick = waitForElementPresence(driver, divElement, 1);
		divClick.click();

		driver.findElement(By.xpath("//li[text()='WC1']")).click();

//				Thread.sleep(3000);
		By whseElement = By.xpath("(//button[@type='button'])[7]");
		WebElement whseClick = waitForElementPresence(driver, whseElement, 1);
		whseClick.click();

		driver.findElement(By.xpath("//li[text()='WC1']")).click();

		driver.findElement(By.xpath("//span[@class='p-inputswitch-slider']")).click();
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='APPLY']")).click();

	}

	@AfterAll
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@BeforeEach
	public void beforeEach() throws InterruptedException {
		Thread.sleep(5000);
		By linkInventory = By.xpath("//span[normalize-space()='Inventory']");
		WebElement lkInventory = waitForElementPresence(driver, linkInventory, 2);
		lkInventory.click();
		System.out.println("Refresh the page");

	}

	@Test
	public void searchByCase() throws InterruptedException {

		// this is for search By Case:
		//case-1
		driver.findElement(By.xpath("//input[@id='caseNo']")).sendKeys("1973123");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='p-button-label p-c'][normalize-space()='Search'])[1]")).click();
		// Thread.sleep(5000);

		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'#1973123')]"));
		String actualData = element.getText();
		String expectedData = "#1973123 00";

		if (actualData.equals(expectedData)) {
			System.out.println("Test case Passed, it matches with expected case with actual...");
		} else {
			System.out.println("Test case failled, it does not matches with expected case with actual......");

		}
		//case-2
		String location = driver.findElement(By.xpath("//p[contains(text(),'WC1')]")).getText();
		if(location.equals("WC1 P 210 26 30 1")) {
			System.out.println("Test case passed because it matches with expected location with actual");
		}
		else {
			System.out.println("Test case failled, because it does not matches with expected location with actual");
			}
		
		// PRINT Headers
		List<WebElement> headers = driver.findElements(By.xpath("//table//thead//th"));
		System.out.println("All headers");
		for (WebElement e : headers) {
			String header = e.getText();
			System.out.print(header + "\t");
		}
		// PRINT DATA
		List<WebElement> datas = driver.findElements(By.xpath("//table//tbody/tr//td"));
//		  System.out.println("All Data");
		System.out.println();
		for (WebElement e : datas) {
			String data = e.getText();
			System.out.print(data + "\t");
		}

	}

	// 2.2 Search By Case enter value and clear it, ensure that values are removed.
	@Test
	public void clearCaseField() throws InterruptedException {

		// this is for clear and verify the input field is empty...

		Thread.sleep(10000);

		WebElement searchField = driver.findElement(By.xpath("//input[@id='caseNo']"));
		searchField.sendKeys("1401235");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='p-button-label p-c'][normalize-space()='Clear'])[1]")).click();

		// Check whether input field is blank
		String textInsideInputBox = searchField.getAttribute("value");
		if (textInsideInputBox.isEmpty()) {
			System.out.println("Test case passed, Search By Case Input field is empty");
		} else {
			System.out.println("Test case failled, Search By Case Input field is not empty..");
		}

	}

	@Test
	public void searchBySKU() throws InterruptedException {

		// 1:SKU Search
		// this is for search By SKU:
		// Thread.sleep(10000);

//		WebElement element = driver.findElement(By.xpath("//input[@id='sku']"));
		WebElement element = waitForElementPresence(driver, By.xpath("//input[@id='sku']"), 1);
		element.sendKeys("SDLCS60");

		// Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='p-button-label p-c'][normalize-space()='Search'])[2]")).click();

		// Thread.sleep(30000);
		WebElement BRCDelement = driver.findElement(By.xpath("//td[contains(text(),'SDLCS60 C R')]"));
		BRCDelement.click();

		// Thread.sleep(5000);
		String actualData = BRCDelement.getText();
		// Thread.sleep(5000);

		String expectedData = "SDLCS60 C R";
		// Thread.sleep(5000);

		if (actualData.equals(expectedData)) {
			System.out.println("Test case Passed! because it matched with BRCD value after displaying data.....");
		} else {
			System.out.println("Test case failled...");

		}

		// check all data contains SDLCS60
		System.out.println("All Data");
		List<WebElement> SKUs = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));

		String data = null;
		for (WebElement e : SKUs) {
			data = e.getText();// mandtatory step
			if (data.startsWith("SDLCS60")) {
				System.out.println("Test case passed because all data can starts with SDLCS60=>  " + data);
			} else {
				System.out.println("Test case failled because all data can't starts with SDLCS60  " + data);
			}
		}
		// SOME ADDITONAL CONCEPTS TO VERIFYIING THE DATA DISPLAYING...

		System.out.println("Verify the Headers which are displayed in screen.. ");

		List<WebElement> allHeaders = driver.findElements(By.xpath("//table//th"));
		if (allHeaders.size() == 7) {
			System.out.println("The size is verifyied it's 7.");
		} else {
			System.out.println("The siz is verified but it is not mathced at the given condition");
		}

		System.out.println("===============");
		boolean sku = false;
		for (WebElement e : allHeaders) {
			String value = e.getText();
			System.out.println(value);
			if (value.contains("SKU")) {
				sku = true;
				break;

			}
		}
		if (sku == true) {
			System.out.println("Test case is passed..");
		} else {
			System.out.println("Test case is failled..");
		}

	}

	@Test
	public void clearSKUField() throws InterruptedException {

		// 2:SKU field clear..
		// this is for clear SKU field and verify the input field
		// is empty...
//
//		WebElement searchSKUField = driver.findElement(By.xpath("(//input[@id='sku'])[1]"));
//		searchSKUField.sendKeys("SDLCS60");
//		Thread.sleep(2000);

		WebElement searchSkuFd = waitForElementPresence(driver, By.xpath("(//input[@id='sku'])[1]"), 2);
		searchSkuFd.sendKeys("SDLCS60");

		driver.findElement(By.xpath("(//span[@class='p-button-icon p-c pi pi-times-circle p-button-icon-left'])[2]"))
				.click();

		// Thread.sleep(2000);

		// Check whether input field is blank
		String textInsideInputBoxForSku = searchSkuFd.getAttribute("value");
		if (textInsideInputBoxForSku.isEmpty()) {
			System.out.println("Test Case Passed, Search By SKU Input field is empty");
		} else {
			System.out.println("Test case failled beacause Search By SKU Input field is not empty..");
		}

	}

}
