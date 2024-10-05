package guiTests;

import org.testng.annotations.Test;
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

	@Test(dataProvider = "testData_Fashion", dataProviderClass = DataProviders.class)
	public void ecommerceFashion_Test(Map<String, String> mapData) {

		try {
			LoginPage loginPage = new LoginPage(driver);
			homePage = loginPage.loginApplication(mapData.get("User Name"), mapData.get("Password"), driver);
			cartPage = homePage.addProductToCart(mapData.get("Product"), driver);
			checkoutPage = cartPage.placeOrder(mapData.get("Product"), driver);
			confPage = checkoutPage.submitOrder(driver);
			String confirmMessage = confPage.getConfirmationMssg();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test(dataProvider = "testData_Electronics", dataProviderClass = DataProviders.class)
	public void ecommerceElectronics_Test(Map<String, String> mapData) {

		try {

			LoginPage loginPage = new LoginPage(driver);
			homePage = loginPage.loginApplication(mapData.get("User Name"), mapData.get("Password"), driver);
			cartPage = homePage.addProductToCart(mapData.get("Product"), driver);
			checkoutPage = cartPage.placeOrder(mapData.get("Product"), driver);
			confPage = checkoutPage.submitOrder(driver);
			String confirmMessage = confPage.getConfirmationMssg();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

}
