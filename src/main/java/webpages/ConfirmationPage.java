package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testbase.WebPageFactory;
import utils.TestUtil;

public class ConfirmationPage extends WebPageFactory {

	String confirmMessage;

	public ConfirmationPage(WebDriver driver) {

		super(driver);

	}

	public String getConfirmationMssg() {

		try {

			TestUtil.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));

			confirmMessage = confirmation.getText();

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

		return confirmMessage;
	}
}
