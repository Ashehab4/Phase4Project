package pagesDefs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageLocators {
	public PageLocators(AndroidDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	AndroidDriver<MobileElement>driver;
	public void flipkartPageLocator(AndroidDriver<MobileElement>driver) {
		this.driver = driver;
	}
     
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Search for products']")
	private WebElement SearchForProduct;
	
    @AndroidFindBy(xpath="//android.widget.EditText[@text='Search for Products, Brands and More']")
	private WebElement SearchItemBox;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='mobiles']")
	private WebElement SearchBtn;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Infinix HOT 20 Play (Fantasy Purple, 64 GB)']")
	private WebElement SearchResultItem;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Add to cart']")
	private WebElement AddToCartBtn;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='My Cart']")
	private WebElement MyCartBtn;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Go to cart']")
	private WebElement DisplayCartddetails;
    

    public  void  ClickOnSearchForProduct()
	{
		
    	SearchForProduct.click();
	}
    
	public  void  pressSearchBtn()
	{
		
		SearchBtn.click();
	}
	
	public  void  pressResultItem()
	{
		
		SearchResultItem.click();
	}
	
	public  void  pressAddtoCartBtn()
	{
		
		AddToCartBtn.click();
	}
	
	public  void  pressMyCartBtn()
	{
		
		MyCartBtn.click();
	}
	
	public  void  EnterSearchText(String searchText)
	{
		
		SearchItemBox.sendKeys(searchText);
	}
	public Boolean  DisplayCartddetails() {
		return  DisplayCartddetails.isDisplayed();
		
	}


}
	
