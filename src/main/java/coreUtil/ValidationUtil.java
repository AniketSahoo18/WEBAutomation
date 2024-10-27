package coreUtil;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import reports.ExtentLogger;

public class ValidationUtil {

	public static void validationCheck(String softorHardAssert, String expectedResult, String actualResult,
			String steps) {

		String message = null;

		if (softorHardAssert.equalsIgnoreCase("hard")) {

			message = "<br/>Expected Value : " + expectedResult + "<br/>Actual Value : " + actualResult;

			validationHardAssert(actualResult.equals(expectedResult), steps, message);
		}

		else if (softorHardAssert.equalsIgnoreCase("soft")) {

			message = "<br/>Expected Value : " + expectedResult + "<br/>Actual Value : " + actualResult;

			validationSoftAssert(actualResult.equals(expectedResult), steps, message);
		}

		else {

			Assert.assertTrue(false, "NO Condition is Matching in Validation Check!!");
		}

	}

	public static void validationHardAssert(boolean validationStatus, String steps, String message) {

		try {

			if (validationStatus) {

				Assert.assertEquals(validationStatus, true, steps + message);
			}

			else {

				Assert.assertEquals(validationStatus, true, steps + message);
			}

		}

		catch (Exception e) {

			Assert.assertTrue(false);
		}
	}

	public static void validationSoftAssert(boolean validationStatus, String steps, String message) {

		try {

			SoftAssert softAssert = new SoftAssert();

			if (validationStatus) {

				softAssert.assertEquals(validationStatus, true, steps + message);

				// ScreenshotNeeded - true, Otherwise false
				if (PropertyUtil.getValue("executionMode").equalsIgnoreCase("GUI")) {

					ExtentLogger.pass(steps, message, true);

				} else {

					ExtentLogger.pass(steps, message);
				}
			}

			else {

				// ScreenshotNeeded - true, Otherwise false
				if (PropertyUtil.getValue("executionMode").equalsIgnoreCase("GUI")) {

					ExtentLogger.fail(steps, message, true);

				} else {

					ExtentLogger.fail(steps, message);
				}

				softAssert.assertEquals(validationStatus, true, steps + message);
			}

		}

		catch (Exception e) {

			Assert.assertTrue(false);
		}
	}

	public static void stepInfo(String steps) {

		try {

			// ScreenshotNeeded - true, Otherwise false
			if (PropertyUtil.getValue("executionMode").equalsIgnoreCase("GUI")) {

				ExtentLogger.info(steps, true);

			} else {

				ExtentLogger.info(steps);
			}
		}

		catch (Exception e) {

			Assert.assertTrue(false);
		}
	}

}
