package testbase;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageFactory {

	public WebPageFactory(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// LoginPage...................................

	@FindBy(id = "userEmail")
	protected WebElement userEmail;

	@FindBy(id = "userPassword")
	protected WebElement userPassword;

	@FindBy(id = "login")
	protected WebElement submit;

	// HomePage....................................

	@FindBy(css = ".mb-3")
	protected List<WebElement> products;

	@FindBy(css = ".ng-animating")
	protected WebElement ngAnimation;

	@FindBy(css = "[routerlink*='cart']")
	protected WebElement cart;

	// CartPage....................................

	@FindBy(css = ".cartSection h3")
	protected List<WebElement> cartProducts;

	@FindBy(css = ".totalRow button")
	protected WebElement checkout;

	// CheckoutPage.................................

	@FindBy(css = "[placeholder='Select Country']")
	protected WebElement countryField;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	protected WebElement country;

	@FindBy(css = ".action__submit")
	protected WebElement placeOrder;

	// ConfirmationPage.............................

	@FindBy(css = ".hero-primary")
	protected WebElement confirmation;

	// Getters and
	// Setters................................................................

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public List<WebElement> getProducts() {
		return products;
	}

	public WebElement getNgAnimation() {
		return ngAnimation;
	}

	public WebElement getCart() {
		return cart;
	}

	public List<WebElement> getCartProducts() {
		return cartProducts;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getCountryField() {
		return countryField;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getPlaceOrder() {
		return placeOrder;
	}

	public WebElement getConfirmation() {
		return confirmation;
	}

}
