package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class LoginPage extends BasePage{

	@FindBy(name = "uid")
	private WebElement userIdTextbox;

	@FindBy(name = "password")
	private WebElement passwordTextbox;

	@FindBy(name = "btnLogin")
	private WebElement signInButton;
	
	
	@FindBy(xpath = "//input")
	private List<WebElement> allInputElements;
	
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		super(driver);

		PageFactory.initElements(driver, this);
		
		this.driver = driver;

	}

	public void loginToApplication(String userId, String password) {
		
		
		WaitUtils.waitTillElementVisible(driver, userIdTextbox, 20);
		
		elementControl.typeText(userIdTextbox, userId);
		
		elementControl.typeText(passwordTextbox, password);
		
		elementControl.clickElement(signInButton);


	}

}
