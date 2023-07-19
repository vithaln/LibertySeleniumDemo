package liberty.selenium.test.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibertyLoginTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		// launch chrome browser
		WebDriver driver = new ChromeDriver();
		// maximize the window..
		driver.manage().window().maximize();

		//implicit wait
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
		System.out.println("Current URL Just After login: " + driver.getCurrentUrl());
		System.out.println("Current Title After login: " + driver.getTitle());
		System.out.println();
		System.out.println("============Verifting Current URL===============");
		String exPectedURL="https://liberty-portal-react-test.kus.logistics.corp/home";
		Thread.sleep(30000);
		String actualURL=driver.getCurrentUrl();
		if(actualURL.equals(exPectedURL)) {
			System.out.println("Test case passed because it matches actual current URL with Expected URL.");
		}
		else{
			System.out.println("Test case Failled because it does not matches actual current URL with Expected URL.");
	
		}
	}

	
}
