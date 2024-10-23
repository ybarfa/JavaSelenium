package learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AbTesting {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win32\\chromedriver.exe");
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testABTestingContent() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/abtest");

        String expected_content = "Also known as split testing. This is a way in which businesses are able "
                + "to simultaneously test and learn different versions of a page to see which text and/or "
                + "functionality works best towards a desired outcome (e.g. a user action such as a click-through).";
        
        WebElement content = driver.findElement(By.xpath("//p[contains(text(), 'Also known as split testing')]"));
        String actual_content = content.getText();
        System.out.println(actual_content);
        
        Thread.sleep(3000);
        
        Assert.assertEquals(actual_content, expected_content, "Content does not match");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
