package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindow extends BasePage{
	
	@FindBy(linkText = "Click Here")
	private WebElement clickHerelink;
	
	private WebDriver driver;
	
	
	public MultipleWindow(WebDriver driver) {
		
		super(driver);
		
		PageFactory.initElements(driver, this);
		
		this.driver = driver;
		
	}
	
	public void switchToAnotherTab() {
		
		
		elementControl.clickElement(clickHerelink);
		
		windowControl.switchToChildWindow();
		
		System.out.println(driver.getTitle()); 
		
		driver.close();
		
		//This will switch back to parent tab
		windowControl.switchToNthChildWindow(0);
		
		System.out.println(driver.getTitle()); 
	}

}
