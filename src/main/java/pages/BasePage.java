package pages;

import org.openqa.selenium.WebDriver;

import commonLibs.ElementControl;
import commonLibs.FrameControl;
import commonLibs.MouseAction;
import commonLibs.WindowControls;

public class BasePage {
	
	public ElementControl elementControl;
	
	public MouseAction mouseAction;
	
	public FrameControl frameControl;
	
	public WindowControls windowControl;
	
	public BasePage(WebDriver driver) {
		
		elementControl = new ElementControl();
		
		mouseAction = new MouseAction(driver);
		
		frameControl = new FrameControl(driver);
		
		windowControl = new WindowControls(driver);
	}

}
