package webpages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testbase.WebPageFactory;

public class CartPage extends WebPageFactory {

	public CartPage(WebDriver driver) {

		super(driver);

	}

	public CheckoutPage placeOrder(String productName, WebDriver driver) {

		try {

			// Checking product is added in Cart

			Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));

			Assert.assertTrue(match);

			// Checkout

			checkout.click();

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

		return new CheckoutPage(driver);
	}
}
