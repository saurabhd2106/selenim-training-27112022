package commonLibs;

import org.openqa.selenium.WebDriver;

public class AlertControls {

	private WebDriver driver;

	public AlertControls(WebDriver driver) {

		this.driver = driver;

	}

	public void acceptAlert() {

		driver.switchTo().alert().accept();

	}

	public void dismissAlert() {

		driver.switchTo().alert().dismiss();
	}

	public String getMessageFromAlert() {

		return driver.switchTo().alert().getText();

	}

}
