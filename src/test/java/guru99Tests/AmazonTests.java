package guru99Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;
import pages.AmazonPage;

public class AmazonTests {
	
	CommonDriver cmnDriver;
	WebDriver driver;
	AmazonPage amazonPage;
	
	
	@BeforeMethod
	public void setup() throws Exception {
		
		cmnDriver = new CommonDriver("chrome");
		
		driver = cmnDriver.getDriver();
		
		cmnDriver.navigateToUrl("https://amazon.in");
		
		amazonPage = new AmazonPage(driver);
		
		
	}
	
	@Test
	public void searchProduct() {
		String product = "Apple Watch";
		
		String category = "Electronics";
		
		amazonPage.seachProduct(product, category);
		
		amazonPage.getAllProductsAndScroll();
	}
	
	

}
