package testBase;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j

public class BaseClass {

	public WebDriver driver;
	public Logger logger;

	@BeforeClass
	public void setup() throws InterruptedException {
		logger = LogManager.getLogger(this.getClass());
		driver = new ChromeDriver();
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo-opencart.com/");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// This Method will generate a random String
	// RandomStringUtils is a 3rd party class to generate random strings.
	public String RandomString() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z')
				.withinRange('A', 'Z').build();
		return generator.generate(5);
	}

	// This Method will generate Random number.
	public String RandomNumber(int length) {
		Random randomNumber = new Random();
		String result = ""; // Start with an empty string
		for (int i = 0; i < length; i++) {
			int digit = randomNumber.nextInt(10); // 0 to 9
			result += digit; // Append the digit to the string
		}
		return result;
	}

}
