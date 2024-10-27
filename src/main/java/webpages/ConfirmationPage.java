package webpages;

import org.openqa.selenium.By;
import coreUtil.ValidationUtil;
import enums.WaitStrategy;
import utils.TestUtil;

public class ConfirmationPage extends TestUtil {

	private final By txtConfirmationMssg = By.cssSelector(".hero-primary");

	String confirmationMessage;

	public void getConfirmationMssg() {

		try {

			confirmationMessage = getText(txtConfirmationMssg, WaitStrategy.VISIBLE);

			ValidationUtil.validationCheck("soft", "THANKYOU FOR THE ORDER.", confirmationMessage,
					"Product Confirmation");

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

	}
}
