package testbase;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import coreUtil.ReadPropertyFile;
import utils.TestUtil;

public class TestBase {

	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)

	protected void setUp() {

		try {

			if (Objects.isNull(DriverManager.getDriver())) {

				driver = BrowserFactory.createBrowserInstance(ReadPropertyFile.getValue("browser"),
						Integer.parseInt(ReadPropertyFile.getValue("driverStartupWait")));

			}

			TestUtil.getUrl(ReadPropertyFile.getValue("url"), driver);
			TestUtil.getPageLoadWait(Integer.parseInt(ReadPropertyFile.getValue("pageLoadWait")), driver);
			TestUtil.getExplicitWait(Integer.parseInt(ReadPropertyFile.getValue("driverExplicitWait")), driver);

		}

		catch (Exception e) {

			System.out.println("Fail Cause: " + e.getMessage());

		}
	}

	@AfterMethod(alwaysRun = true)

	protected void tearDown() {

		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
