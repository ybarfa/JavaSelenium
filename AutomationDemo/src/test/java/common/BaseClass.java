package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class BaseClass {
    protected WebDriver driver;
    
    @BeforeClass
    public void setup() {
    	System.out.println("Setup Method Called ");
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
    	System.out.println("Tear Down called");
        if (driver != null) {
            driver.quit();
        }
    }
}
