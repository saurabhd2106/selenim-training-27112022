package guru99Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Guru99LoginTests extends BaseTests {

	

	@Test(priority = 1000, groups = {"Sanity"})
	public void loginToApplication() {
		
		extentReports.createTestCase("TC#1 - Login to application with correct credentials");
		
		

		String userId = "mngr458224";

		String password = "rUhydug";

		loginPage.loginToApplication(userId, password);
		
		
		String expectedTitle = "Guru99 Bank Manager HomePage";
		
		String actualTitle = cmnDriver.getTitle().trim();
		
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		
		
		String expectedManagerid = String.format("Manger Id : %s", userId);
		
		String actualManagerId = homepage.getManagerId();
		
		AssertJUnit.assertEquals(actualManagerId, expectedManagerid, "Actual manager id on the screen is either not available or not matching");

		extentReports.addLogs("info", "Login successful with following credentials, username - " + userId + " and password - "+ password);
		
	}
	
	
	@Test(priority = 0, enabled = false)
	public void loginToApplicationWithSoftAssertion() {

		String userId = "mngr458224";

		String password = "rUhydug";

		loginPage.loginToApplication(userId, password);
		
		String expectedTitle = "Guru99 Bank Manager HomePage";
		
		String actualTitle = cmnDriver.getTitle().trim();
		
		
		SoftAssert sAssert = new SoftAssert();
		
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		
		
		String expectedManagerid = String.format("Manger Id : %s", userId);
		
		String actualManagerId = homepage.getManagerId();
		
		AssertJUnit.assertEquals(actualManagerId, expectedManagerid, "Actual manager id on the screen is either not available or not matching");

	
		sAssert.assertAll();
	}

	

	
}
