package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	 WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}

// This is a reusable component for all the page objects. 
// This is a one time job. 
// Instead of writing PageFactory.initElements in every class we have separated this in this base page