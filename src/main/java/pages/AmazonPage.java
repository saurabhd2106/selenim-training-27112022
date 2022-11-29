package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage extends BasePage {

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;

	@FindBy(id = "searchDropdownBox")
	private WebElement searchDropdown;

	private WebElement nthProduct;

	@FindBy(xpath = "//div[@data-component-type='s-search-result']")
	private List<WebElement> allProducts;

	private WebDriver driver;

	public AmazonPage(WebDriver driver) {
		
		super(driver);

		PageFactory.initElements(driver, this);

	}

	public void seachProduct(String item, String category) {

		elementControl.typeText(searchBox, item);

		elementControl.selectValueFromDropdownViaText(searchDropdown, category);

		elementControl.clickElement(searchButton);
	}

	public String getNthProduct(int productNumber) {

		String productXpath = String.format("//div[@data-component-type=\"s-search-result\" and @data-index=%d]",
				productNumber);

		nthProduct = driver.findElement(By.xpath(productXpath));

		return elementControl.getText(nthProduct);

	}

	public String getNthProduct2(int productNumber) {

		return elementControl.getText(allProducts.get(productNumber));

	}

	public void getAllProducts() {

		for (WebElement product : allProducts) {

			System.out.println(elementControl.getText(product));

			System.out.println("--------------------------------------------------");

		}

	}

	public void getAllProductsAndScroll() {

		for (WebElement product : allProducts) {
			
			mouseAction.moveToElement(product);

			System.out.println(elementControl.getText(product));

			System.out.println("--------------------------------------------------");

		}

	}

}
