package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtils {

	private ExtentReports extentReports;

	private ExtentSparkReporter sparkReporter;

	private ExtentTest extentTest;

	public ExtentReportUtils(String filename) {

		filename = filename.trim();

		extentReports = new ExtentReports();

		sparkReporter = new ExtentSparkReporter(filename);

		sparkReporter.config().setDocumentTitle("Guru 99 Report");

		extentReports.attachReporter(sparkReporter);

	}

	public void createTestCase(String testcaseName) {

		extentTest = extentReports.createTest(testcaseName);

	}

	public void attachScreenshotToReport(String filename) {
		extentTest.addScreenCaptureFromPath(filename);
	}

	public void addLogs(String status, String logMessage) {

		switch (status) {
		case "warn": {

			extentTest.log(Status.WARNING, logMessage);
			break;
		}
		case "pass": {

			extentTest.log(Status.PASS, logMessage);
			break;

		}

		case "fail": {

			extentTest.log(Status.FAIL, logMessage);
			break;

		}

		case "skip": {

			extentTest.log(Status.SKIP, logMessage);
			break;
		}
		default:
			extentTest.log(Status.INFO, logMessage);
		}

	}

	public void closeReport() {
		extentReports.flush();
	}

}
