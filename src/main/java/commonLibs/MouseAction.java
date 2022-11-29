package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseAction {

	private Actions action;

	public MouseAction(WebDriver driver) {

		action = new Actions(driver);

	}

	public void moveToElement(WebElement element) {

		action.moveToElement(element).build().perform();

	}

	public void dragAndDrop(WebElement source, WebElement Target) {
		
		action.dragAndDrop(source, Target).build().perform();
		
	}

}
