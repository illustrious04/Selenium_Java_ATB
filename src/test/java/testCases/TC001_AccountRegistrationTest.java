package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_account_registration() throws InterruptedException {
		logger.info("*****Starting Test case TC001_AccountRegistrationTest ");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			RegistrationPage regPage = new RegistrationPage(driver);
			regPage.setFirstName(RandomString().toUpperCase());
			regPage.setLastName(RandomString().toUpperCase());
			regPage.setEmail(RandomString() + "@gmail.com");
			regPage.setPassword(RandomString() + "@" + RandomNumber(4));
			Thread.sleep(2000);
			regPage.setPrivacyPolicy();
			regPage.clickContinue();
			String confMessage = regPage.getConfirmationMessage();
			if (confMessage.equals("Your Account Has Been Create!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed.");
				Assert.assertTrue(false);
			}
			// Assert.assertEquals(confMessage, "Your Account Has Been Created!");
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("*****Finished Test case TC001_AccountRegistrationTest ");
	}

}
