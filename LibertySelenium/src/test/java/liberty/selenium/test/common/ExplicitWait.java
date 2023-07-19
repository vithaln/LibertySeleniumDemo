package liberty.selenium.test.common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static WebElement waitForElementPresence(WebDriver driver,By locator,int timout) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(timout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);
		
	}
}
