package webpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import coreUtil.ValidationUtil;
import enums.WaitStrategy;
import testbase.DriverManager;
import utils.TestUtil;

public class CartPage extends TestUtil {

	private final By txtCartProducts = By.cssSelector(".cartSection h3");
	private final By btnCheckout = By.cssSelector(".totalRow button");

	public CheckoutPage placeOrder(String productName) {

		try {

			ValidationUtil.stepInfo("Navigated to Cart Page");

			// Checking product is added in Cart

			Boolean match = DriverManager.getDriver().findElements(txtCartProducts).stream()
					.anyMatch(cartProduct -> cartProduct.getText().equals(productName));

			Assert.assertTrue(match);

			// Checkout

			click(btnCheckout, WaitStrategy.CLICKABLE);

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

		return new CheckoutPage();
	}
}
