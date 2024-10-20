package guiTests;

import org.testng.annotations.Test;

import coreUtil.ValidationUtil;
import testbase.TestBase;
import utils.DataProviders;
import java.util.Map;
import org.testng.Assert;
import webpages.CartPage;
import webpages.CheckoutPage;
import webpages.ConfirmationPage;
import webpages.HomePage;
import webpages.LoginPage;

public final class EcommerceTestExcel extends TestBase {

	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	ConfirmationPage confPage;

	private EcommerceTestExcel() {

	}

	@Test(dataProvider = "testData_Fashion", dataProviderClass = DataProviders.class, enabled = true)
	public void ecommerceFashion_Test(Map<String, String> mapData) {

		try {
			LoginPage loginPage = new LoginPage();
			homePage = loginPage.loginApplication(mapData.get("User Name"), mapData.get("Password"));
			cartPage = homePage.addProductToCart(mapData.get("Product"));
			checkoutPage = cartPage.placeOrder(mapData.get("Product"));
			confPage = checkoutPage.submitOrder();
			String confirmMessage = confPage.getConfirmationMssg();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

			ValidationUtil.validationCheck("soft", "THANKYOU FOR THE ORDER.", confirmMessage,
					"Validation : Product Confirmation");

		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test(dataProvider = "testData_Electronics", dataProviderClass = DataProviders.class, enabled = false)
	public void ecommerceElectronics_Test(Map<String, String> mapData) {

		try {

			LoginPage loginPage = new LoginPage();
			homePage = loginPage.loginApplication(mapData.get("User Name"), mapData.get("Password"));
			cartPage = homePage.addProductToCart(mapData.get("Product"));
			checkoutPage = cartPage.placeOrder(mapData.get("Product"));
			confPage = checkoutPage.submitOrder();
			String confirmMessage = confPage.getConfirmationMssg();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

}
