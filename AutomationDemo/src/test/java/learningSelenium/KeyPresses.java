package learningSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.BaseClass;



public class KeyPresses extends BaseClass{
	
	@Test
	public void keypress() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/key_presses");
		
		WebElement input_feild = driver.findElement(By.id("target"));
		
		input_feild.sendKeys("A");
		
		Thread.sleep(2000);
		
		input_feild.sendKeys(Keys.ALT);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement resultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result"))) ;
		
		System.out.println(resultMessage.getText());
		
		Thread.sleep(2000);
	}
	

}
