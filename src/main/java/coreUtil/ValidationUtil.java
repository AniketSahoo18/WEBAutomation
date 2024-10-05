package coreUtil;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import listeners.TestListener;

public class ValidationUtil extends TestListener {

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

			validation(false, "NO Condition is Matching in Validation Check!!");
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

				TestListener.test.log(Status.PASS, steps + message);
			}

			else {

				TestListener.test.log(Status.FAIL, steps + message);

				softAssert.assertEquals(validationStatus, true, steps + message);
			}

		}

		catch (Exception e) {

			Assert.assertTrue(false);
		}
	}

	public static void validationInfo(String steps) {

		try {

			TestListener.test.log(Status.INFO, steps);
		}

		catch (Exception e) {

			Assert.assertTrue(false);
		}
	}

	public static void validation(boolean validationStatus, String steps) {

		try {

			if (validationStatus) {

				Assert.assertEquals(validationStatus, true, steps);

				TestListener.test.log(Status.PASS, steps);
			}

			else {

				TestListener.test.log(Status.FAIL, steps);

				Assert.assertEquals(validationStatus, true, steps);
			}

		}

		catch (Exception e) {

			Assert.assertTrue(false);
		}
	}
}
