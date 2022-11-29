package guru99Tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import commonLibs.CommonDriver;
import commonLibs.ScreenshotControl;
import utils.DateTimeUtils;
import utils.ExtentReportUtils;
import pages.Homepage;
import pages.LoginPage;

public class BaseTests {

	CommonDriver cmnDriver;

	WebDriver driver;

	LoginPage loginPage;

	Homepage homepage;

	ExtentReportUtils extentReports;

	String reportFilename;

	String currentWorkingDirectory;

	String executionStartTime;

	ScreenshotControl screenshotControl;

	@BeforeClass(alwaysRun = true)
	public void preSetup() {

		currentWorkingDirectory = System.getProperty("user.dir");

		executionStartTime = DateTimeUtils.getCurrentDateAndTime();

		reportFilename = String.format("%s/reports/%s/testReport.html", currentWorkingDirectory, executionStartTime);

		extentReports = new ExtentReportUtils(reportFilename);

	}

	@AfterClass(alwaysRun = true)
	public void postCleanup() {

		extentReports.closeReport();

	}

	/*
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {

		openBrowserAndNavigateToBaseUrl();

		initializeAllPages();

	}
	
	*/
	
	@Parameters("browserType")
	@BeforeMethod(alwaysRun = true)
	public void setup(String browserType) throws Exception {

		browserType = browserType.trim();
		
		
		openBrowserAndNavigateToBaseUrl(browserType);

		initializeAllPages();

	}

	@AfterMethod(alwaysRun = true)
	public void cleanup(ITestResult testResult) throws Exception {
		
		String testcaseName = testResult.getName();

		if (testResult.getStatus() == ITestResult.SUCCESS) {

			extentReports.addLogs("pass", "All test steps passed ");

		} else if (testResult.getStatus() == ITestResult.FAILURE) {

			

			String currentTime = DateTimeUtils.getCurrentDateAndTime();

			String screenshotFilename = String.format("%s/screenshots/%s/%s/%s.jpeg", currentWorkingDirectory,
					executionStartTime, currentTime, testcaseName);

			screenshotControl.captureAndSaveScreenshot(screenshotFilename);
			
			extentReports.attachScreenshotToReport(screenshotFilename);

			extentReports.addLogs("fail", "One or more test step failed");

		} else {

			extentReports.addLogs("skip", "Test steps skipped");

		}

		closeBrowser();

	}

	private void closeBrowser() {

		driver.quit();

	}

	private void openBrowserAndNavigateToBaseUrl(String browserType) throws Exception {
		cmnDriver = new CommonDriver(browserType);

		cmnDriver.setPageloadTimeout(100);

		cmnDriver.setElementDetectionTimeout(20);

		driver = cmnDriver.getDriver();

		cmnDriver.navigateToUrl("http://demo.guru99.com/v4");

	}

	private void initializeAllPages() {
		loginPage = new LoginPage(driver);

		homepage = new Homepage(driver);

		screenshotControl = new ScreenshotControl(driver);

	}

}
