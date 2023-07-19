package liberty.selenium.test.inventory.shipments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShipmentsSearchByDateTest {
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.elementToBeClickable(shipmentsElement)).click();

//			

		// click on setting Icon and update the values..

		Thread.sleep(10000);
		WebElement settingIcon = driver.findElement(By.xpath("//span[@class='p-button-icon p-c pi pi-cog']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(settingIcon)).click();

		Thread.sleep(5000);

		WebElement coElement = driver
				.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/button[1]/span[1]"));
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
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[@class='p-button p-component'])[3]")).click();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,80)", "");
		Thread.sleep(8000);

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
		String actualDate = driver.findElement(By.xpath("//table//tbody//tr[1]//td[text()='2023-07-05']")).getText();
		String expectedDate = "2023-07-05";
	
		//condition 1
		if(actualDate.contains(expectedDate)) {
			System.out.println("Test case passed!");
		}
		else {
			System.out.println("Test case failled!");

		}
		//condition 2
		if (actualDate.equals(expectedDate)) {
			System.out.println("TestCase is Passed Because request delivery date is matched with expected..");
		} else {
			System.out.println("TestCase is failled Because request delivery date is matched with expected..");
		}
		
		//condition 3
		List<WebElement> allRequestDates = driver.findElements(By.xpath("//table//tr//td[7]"));

		for (WebElement webElement : allRequestDates) {
			String rqDate = webElement.getText();
			if(rqDate.contains(expectedDate)) {
				System.out.println(rqDate);
				break;
			}
			else {
			System.out.println("rqDate not found!");
			}
		}
		
		/*
		 * // This is for clear date fields // click on calender for from date
		 * WebElement fromDate = driver .findElement(By.
		 * xpath("//span[@id='fromDate']//span[@class='p-button-icon p-c pi pi-calendar']"
		 * )); fromDate.click(); Thread.sleep(2000); // choose month WebElement
		 * chooseMonth =
		 * driver.findElement(By.xpath("//select[@class='p-datepicker-month']")); Select
		 * dropDwnMonth = new Select(chooseMonth);
		 * dropDwnMonth.selectByVisibleText("July"); Thread.sleep(2000); WebElement
		 * chooseYear =
		 * driver.findElement(By.xpath("//select[@class='p-datepicker-year']")); Select
		 * dropDwnYear = new Select(chooseYear);
		 * dropDwnYear.selectByVisibleText("2023"); Thread.sleep(2000); // select day
		 * String frdate = "5"; driver.findElement(By.xpath(
		 * "//td[not(contains(@class,'p-highlight'))]/span[text()='" + frdate +
		 * "']")).click();
		 * 
		 * // click on toDate String toDate = "20"; WebElement toDates =
		 * driver.findElement(By.xpath("//span[@id='toDate']//input[@type='text']"));
		 * toDates.click(); Thread.sleep(2000); // choose month WebElement chooseMth =
		 * driver.findElement(By.xpath("//select[@class='p-datepicker-month']")); Select
		 * dropDwnMth = new Select(chooseMth); dropDwnMth.selectByVisibleText("July");
		 * Thread.sleep(2000); WebElement chooseYr =
		 * driver.findElement(By.xpath("//select[@class='p-datepicker-year']")); Select
		 * dropDwnYr = new Select(chooseYr); dropDwnYr.selectByVisibleText("2023");
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * "//td[not(contains(@class,'p-highlight'))]/span[text()='" + toDate +
		 * "']")).click(); Thread.sleep(2000);
		 * 
		 * js.executeScript("window.scrollBy(0,80)", ""); //clear the dates
		 * driver.findElement(By.
		 * xpath("//span[@class='p-button-icon p-c pi pi-times-circle p-button-icon-left']"
		 * )) .click();
		 * 
		 * WebElement fromDates =
		 * driver.findElement(By.xpath("//span[@id='fromDate']//input[@type='text']"));
		 * WebElement toDatess =
		 * driver.findElement(By.xpath("//span[@id='toDate']//input[@type='text']")); //
		 * Check whether input field is blank for fromDate String fromDateField =
		 * fromDates.getAttribute("value"); // Check whether input field is blank for
		 * fromDate String toDateField = toDatess.getAttribute("value"); if
		 * (fromDateField.isBlank() && toDateField.isBlank()) {
		 * System.out.println("FromDate and toDate Input field is empty"); } else {
		 * System.out.println("FromDate and toDate Input field is not empty.."); }
		 */
	}

}
