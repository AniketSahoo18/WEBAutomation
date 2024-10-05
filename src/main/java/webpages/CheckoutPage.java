package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testbase.WebPageFactory;
import utils.TestUtil;

public class CheckoutPage extends WebPageFactory {

	public CheckoutPage(WebDriver driver) {

		super(driver);

	}

	public ConfirmationPage submitOrder(WebDriver driver) {

		countryField.sendKeys("India");

		TestUtil.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		country.click();
		placeOrder.click();

		return new ConfirmationPage(driver);
	}

}
