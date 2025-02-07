package pageObjects;

// import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtfirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtlastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

// Every Element we need to create an action methods.

	public void setFirstName(String fname) {
		txtfirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtlastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setPrivacyPolicy() {
		// chkPolicy.click();
		Actions act = new Actions(driver);
		act.moveToElement(chkPolicy).click().perform();
	}

	public void clickContinue() {
		btnContinue.click();

	}

// This Method will only return the confirmation text and we will validate the text on the test case.

	public String getConfirmationMessage() {
		try {
			return (msgConfirmation.getText());

		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}

/*
 * Approaches to Perform Click Action on Button 1--> btnContinue.click()
 * 
 * 2--> btnContinue.sendKeys(Keys.RETURN)
 * 
 * 3--> Actions act = new Actions(driver);
 * act.moveToElement(btnContinue).click().perform();
 * 
 * 4--> btnContinue.submit()
 * 
 * 5--> JavascriptExecutor js = (JavascriptExecutor)driver;
 * js.executeScript("arguments[0].click();", btnContinue);
 * 
 *
 */
