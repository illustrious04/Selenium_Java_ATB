package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	public String firstName = RandomString().toUpperCase();
	public String lastName = RandomString().toUpperCase();
	public String email = (RandomString() + "@gmail.com");
	@Test
	public void verify_account_registration() throws InterruptedException {
		logger.info("*****Starting Test case TC001_AccountRegistrationTest ");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			RegistrationPage regPage = new RegistrationPage(driver);
			regPage.setFirstName(firstName);
			logger.info("Generated FirstName: " + firstName);
			regPage.setLastName(lastName);
			logger.info("Generated LastName:" + lastName);
//			regPage.setFirstName(RandomString().toUpperCase());;
//			regPage.setLastName(RandomString().toUpperCase());
			// regPage.setEmail(RandomString() + "@gmail.com");
			regPage.setEmail(email);
			logger.info("Generated Email: " + email);
			regPage.setPassword(RandomString() + "@" + RandomNumber(4));
			Thread.sleep(2000);
			regPage.setPrivacyPolicy();
			regPage.clickContinue();
			String confMessage = regPage.getConfirmationMessage();
			if (confMessage.equals("Your Account Has Been Created!")) {
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
