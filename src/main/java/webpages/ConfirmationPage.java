package webpages;

import org.openqa.selenium.By;
import enums.WaitStrategy;
import utils.TestUtil;

public class ConfirmationPage extends TestUtil {

	private final By txtConfirmationMssg = By.cssSelector(".hero-primary");

	String confirmationMessage;

	public String getConfirmationMssg() {

		try {

			confirmationMessage = getText(txtConfirmationMssg, WaitStrategy.VISIBLE);

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

		return confirmationMessage;
	}
}
