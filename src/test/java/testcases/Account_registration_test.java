package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Account_registration_page;
import pageobjects.Home_page;
import testbase.Base_class;

public class Account_registration_test extends Base_class
{
	@Test(groups= {"regression","master"}) //Step8 groups added
	public void test_account_Registration() throws InterruptedException
	{		
		logger.info("Strating AccountRegistrationtTest");
		try {
			Home_page hp = new Home_page(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			
			hp.clickRegister();
			logger.info("Clicked on Register ");

			Account_registration_page regpage = new Account_registration_page(driver);
			
			regpage.setFirstName(randomeString().toUpperCase());
			logger.info("Provided First Name ");

			regpage.setLastName(randomeString().toUpperCase());
			logger.info("Provided Last Name ");

			regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the email
			//regpage.setEmail("pavannoltraining@gmail.com");// duplicate email should fail test case
			logger.info("Provided Email ");

			regpage.setTelephone(randomeNumber());
			logger.info("Provided Telephone ");

			regpage.setPassword("test@123");
			logger.info("Provided Password ");

			regpage.setConfirmPassword("test@123");
			logger.info("Provided Confrmed Password ");

			regpage.setPrivacyPolicy();
			logger.info("Set Privacy Policy ");

			regpage.clickContinue();
			logger.info("Clicked on Continue ");

			Thread.sleep(2000);

			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}

		logger.info("Finished AccountRegistrationtTest");
	}
					
}


/*package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Account_registration_page;
import pageobjects.Home_page;
import testbase.Base_class;

public class Account_registration_test extends Base_class {
		
		@Test
		public void verify_account_registration()
		{
			logger.info("***** Starting TC001_AccountRegistrationTest  ****");
			logger.debug("This is a debug log message");
			try
			{
			Home_page hp=new Home_page(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link.. ");
			
			hp.clickRegister();
			logger.info("Clicked on Register Link.. ");
			
			Account_registration_page regpage=new Account_registration_page(driver);
			logger.info("Providing customer details...");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
			regpage.setTelephone(randomeNumber());
			
			String password=randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("Validating expected message..");
			
			String confmsg=regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			
			logger.info("Test passed");
			} 
			catch (Exception e)
			{
				logger.error("Test failed: " + e.getMessage());
				Assert.fail("Test failed: " + e.getMessage());
			} 
			finally 
			{
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
			}
			}		
}*/











