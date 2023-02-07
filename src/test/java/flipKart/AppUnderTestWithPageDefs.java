package flipKart;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pagesDefs.PageLocators;
import resources.base;

public class AppUnderTestWithPageDefs extends base {

	@Test
	public void AppUnderTestDemo() throws IOException, InterruptedException {
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageLocators page = new PageLocators(driver);
		page.ClickOnSearchForProduct();
		page.EnterSearchText("Mobiles");
		page.pressSearchBtn();
		page.pressResultItem();
		page.pressAddtoCartBtn();
		page.pressMyCartBtn();
		page.DisplayCartddetails();

		Boolean DisplayedSummary = page.DisplayCartddetails();
		Assert.assertTrue(DisplayedSummary);

	}

	@AfterTest
	public void ServiceClosure() {

		service.stop();
		driver.quit();
	}

}
