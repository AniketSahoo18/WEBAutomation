package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import coreUtil.ExtentReportUtil;

public class TestListener implements ITestListener {

	protected static ExtentTest test;

	ExtentReports extentReports = ExtentReportUtil.getReport();

	public void onTestStart(ITestResult result) {

		test = extentReports.createTest(result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {

		extentReports.flush();
	}
}
