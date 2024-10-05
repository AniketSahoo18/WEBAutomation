package webpages;

import org.openqa.selenium.WebDriver;
import testbase.WebPageFactory;
import utils.TestUtil;

public class LoginPage extends TestUtil {

	WebPageFactory wf;

	public LoginPage(WebDriver driver) {

		wf = new WebPageFactory(driver);

	}

	public HomePage loginApplication(String email, String password, WebDriver driver) {

		try {

			sendKeys(wf.getUserEmail(), email);
			sendKeys(wf.getUserPassword(), password);
			click(wf.getSubmit());

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}
		return new HomePage(driver);
	}

}
