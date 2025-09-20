package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Home_page;
import pageobjects.Login_page;
import pageobjects.Myaccount_page;
import testbase.Base_class;
import utilities.DataProviders;
public class Login_DDT extends Base_class{
	/*Data is valid  - login success - test pass  - logout
	Data is valid -- login failed - test fail

	Data is invalid - login success - test fail  - logout
	Data is invalid -- login failed - test pass
	*/
	    
		@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
		public void verify_login_DDT(String email, String password, String exp)
		{
			logger.info("**** Starting TC_003_LoginDDT *****");
			
			try {
		
			//Home page
				Home_page hp=new Home_page(driver);
				hp.clickMyAccount();
				hp.clicklogin(); //Login link under MyAccount
					
				//Login page
				Login_page lp=new Login_page(driver);
				lp.setEmail(email);
				lp.setPassword(password);
				lp.clickContinue(); //Login button
					
				//My Account Page
				Myaccount_page macc=new Myaccount_page(driver);
				boolean targetPage=macc.isMyAccountPageExists();
				
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
			}
			catch(Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
				
			logger.info("**** Finished TC_003_LoginDDT *****");
		}
		
}











