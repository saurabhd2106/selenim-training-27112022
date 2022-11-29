package commonLibs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {

	public void clickElement(WebElement element) {

		element.click();

	}

	public void typeText(WebElement element, String textToType) {

		element.sendKeys(textToType);

	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public String getText(WebElement element) {

		return element.getText();

	}

	public void selectValueFromDropdownViaText(WebElement element, String text) {

		Select select = new Select(element);

		select.selectByVisibleText(text);

	}

	public void selectValueFromDropdownViaIndex(WebElement element, int index) {

		Select select = new Select(element);

		select.selectByIndex(index);

	}

	public void selectValueFromDropdownViaValue(WebElement element, String text) {

		Select select = new Select(element);

		select.selectByValue(text);

	}
	
	

}
