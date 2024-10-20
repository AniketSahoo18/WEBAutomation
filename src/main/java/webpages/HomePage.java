package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import enums.WaitStrategy;
import testbase.DriverManager;
import testbase.WaitFactory;
import utils.TestUtil;

public class HomePage extends TestUtil {

	private final By txtProducts = By.cssSelector(".mb-3");
	private final By txtProduct = By.cssSelector("b");
	private final By linkCart = By.cssSelector("[routerlink*='cart']");
	private final By linkProduct = By.cssSelector(".card-body button:last-of-type");
	private final By linkPopUp =By.cssSelector("#toast-container");
	private final By linkAnimation =By.cssSelector(".ng-animating");

	public CartPage addProductToCart(String productName) {

		try {

//			TestUtil.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

			WebElement prod = DriverManager.getDriver().findElements(txtProducts).stream()
					.filter(product -> getText(product, txtProduct).equals(productName)).findFirst().orElse(null);

			click(prod, linkProduct);

//			TestUtil.explicitWait
//					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			
			WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, linkPopUp);

//			 ng-animating
//			TestUtil.explicitWait.until(ExpectedConditions.invisibilityOf(ngAnimation));
			
			WaitFactory.performExplicitWait(WaitStrategy.INVISIBLE, linkAnimation);

			// Click Cart

			click(linkCart, WaitStrategy.CLICKABLE);

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

		return new CartPage();
	}
}
