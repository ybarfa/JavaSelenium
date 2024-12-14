package learningSelenium;

import common.BaseClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
public class AlertAndPopups extends BaseClass {
    @Test
    public void handleAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    	
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        
        Alert simpleAlert = driver.switchTo().alert();
        
        System.out.println("Alert message: " + simpleAlert.getText());
        
        simpleAlert.accept();
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        
        Alert confirmAlert = driver.switchTo().alert();
        
        System.out.println("Confirmation alert message: " + confirmAlert.getText());
        
        confirmAlert.dismiss();
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        
        Alert promptAlert = driver.switchTo().alert();
        
        System.out.println("Prompt alert message: " + promptAlert.getText());
        
        promptAlert.sendKeys("Selenium Test");
        
        promptAlert.accept();
        
        Thread.sleep(2000);
    	 System.out.println("dfds");
    }
    
    @Test
    public void hcmTestPositive() {
    	System.out.println("Harish Testing");
    	assertEquals(3, 3);
    }
    
    @Test
    public void hcmTestNegative() {
    	assertEquals(3, 4);
    }

}
