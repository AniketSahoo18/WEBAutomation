package webpages;

import org.openqa.selenium.By;
import enums.WaitStrategy;
import utils.TestUtil;

public class LoginPage extends TestUtil {

	private final By txtBoxEmail = By.id("userEmail");
	private final By txtBoxPassword = By.id("userPassword");
	private final By btnLogin = By.id("login");

	public HomePage loginApplication(String email, String password) {

		try {

			sendKeys(txtBoxEmail, email, WaitStrategy.PRESENCE);
			sendKeys(txtBoxPassword, password, WaitStrategy.PRESENCE);
			click(btnLogin, WaitStrategy.CLICKABLE);

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}
		return new HomePage();
	}

}
