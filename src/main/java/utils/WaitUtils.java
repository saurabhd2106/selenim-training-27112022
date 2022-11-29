package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public static void waitTillElementVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitTillElementHasText(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

		wait.until(ExpectedConditions.textToBePresentInElement(element, text));

	}
	
	public static void waitForSeconds(int timeInSeconds) {
		
		try {
			
			Thread.sleep(timeInSeconds * 1000);
			
		} catch (Exception e) {
			System.err.println("Exception occured!!");
		}
	}

}
