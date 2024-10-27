package reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import coreUtil.PropertyUtil;
import testbase.DriverManager;

public class ExtentLogger {

//	private ExtentLogger() {
//	};

	public static void pass(String steps, String message) {

		ExtentManager.getExtentTest().log(Status.PASS, steps + message);
	}

	public static void fail(String steps, String message) {

		ExtentManager.getExtentTest().log(Status.FAIL, steps + message);
	}

	public static void skip(String steps, String message) {

		ExtentManager.getExtentTest().log(Status.SKIP, steps + message);
	}

	public static void info(String steps) {

		ExtentManager.getExtentTest().log(Status.INFO, steps);
	}

	public static void pass(String steps, String message, boolean isScreenshotNeeded) throws Exception {

		if (PropertyUtil.getValue("passedstepsscreenshots").equalsIgnoreCase("yes") && isScreenshotNeeded) {

			ExtentManager.getExtentTest().log(Status.PASS, steps + message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}

		else {

			pass(steps, message);
		}
	}

	public static void fail(String steps, String message, boolean isScreenshotNeeded) throws Exception {

		if (PropertyUtil.getValue("failedstepsscreenshots").equalsIgnoreCase("yes") && isScreenshotNeeded) {

			ExtentManager.getExtentTest().log(Status.FAIL, steps + message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}

		else {

			fail(steps, message);
		}
	}

	public static void skip(String steps, String message, boolean isScreenshotNeeded) throws Exception {

		if (PropertyUtil.getValue("skippedstepsscreenshots").equalsIgnoreCase("yes") && isScreenshotNeeded) {

			ExtentManager.getExtentTest().log(Status.SKIP, steps + message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}

		else {

			skip(steps, message);
		}
	}

	public static void info(String steps, boolean isScreenshotNeeded) throws Exception {

		if (PropertyUtil.getValue("infostepsscreenshots").equalsIgnoreCase("yes") && isScreenshotNeeded) {

			ExtentManager.getExtentTest().log(Status.INFO, steps,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}

		else {

			info(steps);
		}
	}

	public static String getBase64Image() {

		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
