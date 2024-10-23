package learningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LaunchGmail {
	WebDriver driver;
	
	@Test
	public void setup() {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.gmail.com");

		}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
	


