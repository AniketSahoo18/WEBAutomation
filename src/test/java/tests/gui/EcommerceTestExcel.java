package tests.gui;

import java.util.Map;
import org.testng.annotations.Test;
import testbase.TestBase;
import utils.DataProvidersUI;
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

	@Test(dataProvider = "testData_Fashion", dataProviderClass = DataProvidersUI.class, enabled = true)
	public void ecommerceFashion_Test(Map<String, String> mapData) {

		try {
			LoginPage loginPage = new LoginPage();
			homePage = loginPage.loginApplication(mapData.get("User Name"), mapData.get("Password"));
			cartPage = homePage.addProductToCart(mapData.get("Product"));
			checkoutPage = cartPage.placeOrder(mapData.get("Product"));
			confPage = checkoutPage.submitOrder();
			confPage.getConfirmationMssg();

		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test(dataProvider = "testData_Electronics", dataProviderClass = DataProvidersUI.class, enabled = false)
	public void ecommerceElectronics_Test(Map<String, String> mapData) {

		try {

			LoginPage loginPage = new LoginPage();
			homePage = loginPage.loginApplication(mapData.get("User Name"), mapData.get("Password"));
			cartPage = homePage.addProductToCart(mapData.get("Product"));
			checkoutPage = cartPage.placeOrder(mapData.get("Product"));
			confPage = checkoutPage.submitOrder();
			confPage.getConfirmationMssg();

		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

}
