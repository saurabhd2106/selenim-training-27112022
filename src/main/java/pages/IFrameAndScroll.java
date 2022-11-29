package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFrameAndScroll extends BasePage {

	@FindBy(id = "draggable")
	public WebElement source;

	@FindBy(id = "droppable")
	public WebElement target;

	@FindBy(className = "demo-frame")
	public WebElement frameElement;

	public IFrameAndScroll(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	public void switchToFrameAndDragNDrop() {

		frameControl.switcToFrame(frameElement);
		
		mouseAction.dragAndDrop(source, target);

	}

}
