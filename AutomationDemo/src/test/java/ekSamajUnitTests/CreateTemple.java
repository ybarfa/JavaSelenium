package ekSamajUnitTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.BaseClass;

public class CreateTemple extends BaseClass{
	
	@Test
	public void createTemple(){
		driver.get("https://eksamaj.com/login");
		driver.manage().window().maximize();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("yashbarfa09@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Welcome");
		
		WebElement sign_in_button = driver.findElement(By.xpath("//span[contains(text(), 'Sign in')]"));
		sign_in_button.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/dashboard']")));
		
		WebElement superadmin = driver.findElement(By.xpath("//a[@href=\"/superadmin\"]"));
		superadmin.click();
		
		WebElement createTemple = driver.findElement(By.xpath("//span[contains(text(), 'Create Temple')]"));
		createTemple.click();
		
		WebElement templename = driver.findElement(By.xpath("//input[@id='form_in_modal_name']"));
		templename.sendKeys("TestAutomation Temple");
		
		WebElement villageInput = driver.findElement(By.xpath("//input[@id='form_in_modal_village']"));
		villageInput.sendKeys("TestAutomation");
		
		WebElement tehsilInput = driver.findElement(By.xpath("//input[@id='form_in_modal_tehsil']"));
		tehsilInput.sendKeys("TesttehsilAutomation");
		
		WebElement districtInput = driver.findElement(By.xpath("//input[@id='form_in_modal_district']"));
		districtInput.sendKeys("TestAutomationDistrict");
		
		WebElement stateInput = driver.findElement(By.xpath("//input[@id='form_in_modal_state']"));
		stateInput.sendKeys("TestAutomationState");
		
		WebElement pincodeInput = driver.findElement(By.xpath("//input[@id='form_in_modal_pincode']"));
		pincodeInput.sendKeys("456789");
		
		WebElement submitbutton =driver.findElement(By.xpath("//span[contains(text(), 'OK')]"));
		submitbutton.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'TestAutomation Temple')]")));
		
		
	}

}
