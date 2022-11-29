package commonLibs;

import org.openqa.selenium.WebDriver;

public class WindowControls {

	private WebDriver driver;

	public WindowControls(WebDriver driver) {

		this.driver = driver;

	}

	public String getWindowHandleFromCurrentWindow() {

		return driver.getWindowHandle();
	}

	public void switchToChildWindow() {

		String windowHandle = driver.getWindowHandles().toArray()[1].toString();

		driver.switchTo().window(windowHandle);

	}

	public void switchToNthChildWindow(int index) {

		String windowHandle = driver.getWindowHandles().toArray()[index].toString();

		driver.switchTo().window(windowHandle);

	}

}
