package webpages;

import org.openqa.selenium.By;
import enums.WaitStrategy;
import utils.TestUtil;

public class CheckoutPage extends TestUtil {
	
	private final By txtCountryField = By.cssSelector("[placeholder='Select Country']");
	private final By searchCountryField = By.cssSelector(".ta-item:nth-of-type(2)");
	private final By btnPlaceOrder = By.cssSelector(".action__submit");
	
	public ConfirmationPage submitOrder() {
		
		sendKeys(txtCountryField, "India", WaitStrategy.PRESENCE);

//		TestUtil.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
//		WaitFactory.performExplicitWait(0, driver, );

		click(searchCountryField, WaitStrategy.CLICKABLE);
		click(btnPlaceOrder, WaitStrategy.CLICKABLE);


		return new ConfirmationPage();
	}

}
