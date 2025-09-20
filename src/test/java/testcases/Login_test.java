/*package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Home_page;
import pageobjects.Login_page;
import pageobjects.Myaccount_page;
import testbase.Base_class;

public class Login_test extends Base_class
{
	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void test_Login()
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{				
			Home_page hp=new Home_page(driver);
			
			hp.clickMyAccount();
						
			hp.clicklogin();
			
			Login_page lp=new Login_page(driver);
			
			lp.setEmail(p.getProperty("email")); // valid email, get it from properties file
			
			lp.setPassword(p.getProperty("password")); // valid password, get it from properties file
			
			lp.clickContinue();
			
			Myaccount_page macc=new Myaccount_page(driver);
			
			boolean targetPage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetPage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");
		
	}
	
	
}*/





package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Home_page;
import pageobjects.Login_page;
import pageobjects.Myaccount_page;
import testbase.Base_class;

public class Login_test extends Base_class{

		@Test
		public void verify_login()
		{
			logger.info("**** Starting TC_002_LoginTest  ****");
			logger.debug("capturing application debug logs....");
			try
			{
			//Home page
			Home_page hp=new Home_page(driver);
			hp.clickMyAccount();
			logger.info("clicked on myaccount link on the home page..");
			hp.clicklogin(); //Login link under MyAccount
			logger.info("clicked on login link under myaccount..");
			
			//Login page
			Login_page lp=new Login_page(driver);
			logger.info("Entering valid email and password..");
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickContinue(); //Login button
			logger.info("clicked on ligin button..");
			
			//My Account Page
			Myaccount_page macc=new Myaccount_page(driver);
					
			boolean targetPage=macc.isMyAccountPageExists();
			
			Assert.assertEquals(targetPage, true,"Login failed");
			}
			catch(Exception e)
			{
				Assert.fail();
			}
			
			logger.info("**** Finished TC_002_LoginTest  ****");
		}
}



