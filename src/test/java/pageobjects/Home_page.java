package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_page extends Base_page{
	
	public Home_page(WebDriver driver)
	{
		super(driver);
	}
		
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement lnkMyaccount;

	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnklogin;



	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}

	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clicklogin() 
	{
		lnklogin.click();
	}

}



