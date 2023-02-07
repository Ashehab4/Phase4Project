package flipKart;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FlipKartTestWithoutPageDefs {
	AndroidDriver<MobileElement> driver;

	@BeforeTest

	public void StartEmulators() throws MalformedURLException {

		DesiredCapabilities Capabilities = new DesiredCapabilities();
		Capabilities.setCapability("deviceName", "emulator-5554");
		Capabilities.setCapability("platformName", "ANDROID");
		Capabilities.setCapability("appPackage", "com.flipkart.android");
		Capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		Capabilities.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
	}

	@Test

	public void FlipKartOrderTest() {

		// Find and Press on Search for Item Box
		WebElement SearchForProduct = driver
				.findElementByXPath("//android.widget.TextView[@text='Search for products']");
		SearchForProduct.click();

		// Enter Search Data
		WebElement EnterSearchText = driver
				.findElementByXPath("//android.widget.EditText[@text='Search for Products, Brands and More']");
		EnterSearchText.sendKeys("Mobiles");

		// Find and Press on Search button
		WebElement pressSearchBtn = driver.findElementByXPath("//android.widget.TextView[@text='mobiles']");
		pressSearchBtn.click();

		// Find and Press on First Result
		WebElement pressResultItem = driver
				.findElementByXPath("//android.widget.TextView[@text='Infinix HOT 20 Play (Fantasy Purple, 64 GB)']");
		pressResultItem.click();

		// Find and Press on Search for Item Box
		WebElement pressAddtoCartBtn = driver.findElementByXPath("//android.widget.TextView[@text='Add to cart']");
		pressAddtoCartBtn.click();

		// Find and Press on Search for Item Box
		WebElement pressMyCartBtn = driver.findElementByXPath("//android.widget.TextView[@text='Go to cart']");
		pressMyCartBtn.click();

		// Find and Press on Search for Item Box
		WebElement DisplayCartddetails = driver.findElementByXPath("//android.widget.TextView[@text='My Cart']");
		Boolean CardDetailsExist = DisplayCartddetails.isDisplayed();
		Assert.assertTrue(CardDetailsExist);

	}

	@AfterTest
	public void CloseApplication() {

		driver.quit();
	}

}
