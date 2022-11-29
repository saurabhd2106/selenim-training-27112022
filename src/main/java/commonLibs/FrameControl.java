package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameControl {

	private WebDriver driver;

	public FrameControl(WebDriver driver) {

		this.driver = driver;

	}

	public void switcToFrame(String frameId) {

		driver.switchTo().frame(frameId);

	}

	public void switcToFrame(WebElement element) {

		driver.switchTo().frame(element);

	}
	
	public void switcToFrame(int index) {

		driver.switchTo().frame(index);

	}
	
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	

}
