package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testbase.WebPageFactory;
import utils.TestUtil;

public class HomePage extends WebPageFactory {

	public HomePage(WebDriver driver) {

		super(driver);

	}

	public CartPage addProductToCart(String productName, WebDriver driver) {

		try {

			TestUtil.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

			WebElement prod = products.stream()
					.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
					.findFirst().orElse(null);

			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

			TestUtil.explicitWait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

			// ng-animating
			TestUtil.explicitWait.until(ExpectedConditions.invisibilityOf(ngAnimation));

			// Click Cart
			cart.click();

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}

		return new CartPage(driver);
	}
}
