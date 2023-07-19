package liberty.selenium.test.home;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import liberty.selenium.test.common.ExplicitWait;

public class ChangePageSizeTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		// launch chrome browser
		WebDriver driver = new ChromeDriver();
		// maximize the window..
		driver.manage().window().maximize();
		
		
		//implicit wait->static/global wait for all elements.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// open liberty application url.
		driver.get("https://liberty-portal-react-test.kus.logistics.corp/");
		// locate the element and click on login with SSO.
		
		//Explicit wait->element specific
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='p-button-label p-c']")));
		ele.click();
		
		//driver.findElement(By.xpath("//span[@class='p-button-label p-c']")).click();
		// locate element and enter username
		driver.findElement(By.id("loginForm:username")).sendKeys("nivargiv");
		// locate the element and password
		driver.findElement(By.id("loginForm:password")).sendKeys("Speedster@7757888888");
		// locate the element and click on login button
		driver.findElement(By.id("loginForm:loginButton")).click();
		Thread.sleep(30000);
		JavascriptExecutor sc=(JavascriptExecutor)driver;
		sc.executeScript("window.scrollBy(0,350)"," ");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@class='p-dropdown-trigger-icon p-clickable pi pi-chevron-down'])[11]")).click();
	
		//Thread.sleep(4000);
		//driver.findElement(By.xpath("//li[@aria-label='50']")).click();
		By eleLocator=By.xpath("//li[@aria-label='50']");
		WebElement element = ExplicitWait.waitForElementPresence(driver, eleLocator, 10);
		element.click();
		
		
		
		Thread.sleep(5000);
		//to scroll down the web page at the bottom of the page
		sc.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		//declaration
		Wait<WebDriver> waits = new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(5))
		  .ignoring(NoSuchElementException.class);

		WebElement home = waits.until(drive -> {
		  return drive.findElement(By.xpath("//span[text()='Home']"));
		});
		home.click();
		  
	}

	
}
