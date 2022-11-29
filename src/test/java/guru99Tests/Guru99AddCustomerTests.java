package guru99Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Guru99AddCustomerTests extends BaseTests{
	
	
	@Test
	public void addCustomer() {

		// Login

		String userId = "mngr458224";

		String password = "rUhydug";

		driver.findElement(By.name("uid")).sendKeys(userId);

		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("btnLogin")).click();

		// Add customer

		driver.findElement(By.linkText("New Customer")).click();

		driver.findElement(By.name("name")).sendKeys("Prerna");

		driver.findElement(By.xpath("//input[@value='f']")).click();

		driver.findElement(By.id("dob")).sendKeys("06-06-1989");

		driver.findElement(By.name("addr")).sendKeys("Bangalore");

		driver.findElement(By.name("city")).sendKeys("Bangalore");

		driver.findElement(By.name("state")).sendKeys("Karnatka");
		driver.findElement(By.name("pinno")).sendKeys("234132");
		driver.findElement(By.name("telephoneno")).sendKeys("432542");

		String emailId = String.format("sdgsh-%s@dsj.com", System.currentTimeMillis());

		System.out.println(emailId);

		driver.findElement(By.name("emailid")).sendKeys(emailId);
		driver.findElement(By.name("password")).sendKeys("fdadf");
		driver.findElement(By.name("sub")).click();

		// Get the cutomer Id

		String customerId = driver
				.findElement(By.xpath("//table[@id='customer']//td[text()='Customer ID']//following-sibling::td"))
				.getText();

		System.out.println(customerId);

		// Add Account

		driver.findElement(By.linkText("New Account")).click();

		driver.findElement(By.name("cusid")).sendKeys(customerId);

		WebElement accountTypeDropdown = driver.findElement(By.name("selaccount"));

		Select select = new Select(accountTypeDropdown);

		select.selectByVisibleText("Current");

		driver.findElement(By.name("inideposit")).sendKeys("3432");

		driver.findElement(By.name("button2")).click();

	}

}
