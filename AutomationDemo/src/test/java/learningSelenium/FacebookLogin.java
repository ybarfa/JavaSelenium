package learningSelenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FacebookLogin {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void login() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
		username.sendKeys("qwerty@gmail.com");
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("123455667788");
		
		WebElement login_button = driver.findElement(By.xpath("//button[@name='login']"));
		login_button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='https://static.xx.fbcdn.net/rsrc.php/v3/y2/r/O287_AcFyg4.png']")));
		WebElement message = driver.findElement(By.xpath("//div[contains(text(),'The email address you entered')]"));
		String error_message = message.getText();
		System.out.println(error_message);
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
