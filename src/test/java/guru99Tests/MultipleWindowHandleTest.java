package guru99Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;
import pages.MultipleWindow;

public class MultipleWindowHandleTest {
	
	CommonDriver cmnDriver;
	WebDriver driver;
	
	MultipleWindow multipleTabPage;
	
	@BeforeMethod
	public void setup() throws Exception {
		
		cmnDriver = new CommonDriver("chrome");
		
		driver = cmnDriver.getDriver();
		
		cmnDriver.navigateToUrl("https://test.qatechhub.com/window-handling/");
		
		multipleTabPage = new MultipleWindow(driver);
		
		
	}
	
	@Test
	public void multipeTabTests() {
		
		
		multipleTabPage.switchToAnotherTab();
		
		
	}

}
