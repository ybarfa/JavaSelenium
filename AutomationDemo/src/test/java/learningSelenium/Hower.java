package learningSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import common.BaseClass;

public class Hower extends BaseClass {
	
	@Test
	public void howerAction() throws InterruptedException{
		driver.get("https://the-internet.herokuapp.com/hovers");
		
		driver.manage().getCookies();
		
		List<WebElement> userProfiles = driver.findElements(By.cssSelector(".figure"));
		
		Actions actions = new Actions(driver);
		
		for (WebElement profile : userProfiles) {
			actions.moveToElement(profile).perform();
			
			Thread.sleep(2000);
			
			WebElement hiddenText = profile.findElement(By.cssSelector(".figcaption h5"));
			
			System.out.println(hiddenText.getText());
		}
		
		
		
	}

}
