package ekSamajUnitTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.BaseClass;

public class Login extends BaseClass{
	
	@Test
	public void login() throws InterruptedException{
		driver.get("https://eksamaj.com/login");
		driver.manage().window().maximize();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("yashbarfa09@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Welcome");
		
		WebElement sign_in_button = driver.findElement(By.xpath("//span[contains(text(), 'Sign in')]"));
		sign_in_button.click();
		
		Thread.sleep(3000);
	}

}
