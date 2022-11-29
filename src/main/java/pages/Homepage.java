package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage{
	
	@FindBy(xpath = "//td[contains(text(), 'Manger Id')]")
	private WebElement managerId;
	
	
	public Homepage(WebDriver driver) {
		
		super(driver);
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String getManagerId() {
		
		return elementControl.getText(managerId);
		
	}
	
	

}
