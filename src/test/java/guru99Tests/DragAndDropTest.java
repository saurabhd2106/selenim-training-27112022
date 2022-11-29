package guru99Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;
import pages.IFrameAndScroll;

public class DragAndDropTest {
	
	CommonDriver cmnDriver;
	
	WebDriver driver;
	
	IFrameAndScroll framePage;
	
	@BeforeMethod
	public void setup() throws Exception {
		
		cmnDriver = new CommonDriver("chrome");
		
		cmnDriver.navigateToUrl("https://jqueryui.com/droppable/");
		
		driver = cmnDriver.getDriver();
		
		framePage = new IFrameAndScroll(driver);
		
	}
	
	@Test
	public void dragAndDropTests() {
		
		framePage.switchToFrameAndDragNDrop();
		
	}

}
