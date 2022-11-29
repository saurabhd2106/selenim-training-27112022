package commonLibs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonDriver {

	private WebDriver driver;

	private int pageloadTimeout;

	private int elementDetectionTimeout;

	public WebDriver getDriver() {
		return driver;
	}

	public CommonDriver(String browserType) throws Exception {

		browserType = browserType.trim();

		pageloadTimeout = 90;

		elementDetectionTimeout = 10;

		if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"/Users/saurabhdhingra/eclipse-workspace/LearningSelenium27Nov/driver/chromedriver");

			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver",
					"/Users/saurabhdhingra/eclipse-workspace/LearningSelenium27Nov/driver/edgedriver");

			driver = new EdgeDriver();

		} else if (browserType.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"/Users/saurabhdhingra/eclipse-workspace/LearningSelenium27Nov/driver/geckodriver");

			driver = new FirefoxDriver();

		} else {
			throw new Exception("Invalid Browser Type");
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

	}

	public void navigateToUrl(String url) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadTimeout));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));

		url = url.trim();

		driver.get(url);

	}

	public String getTitle() {

		return driver.getTitle();

	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void closeCurrentBrowser() {

		driver.close();

	}

	public void closeBrowser() {

		driver.quit();
	}

	public void reloadPage() {
		driver.navigate().refresh();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
}
