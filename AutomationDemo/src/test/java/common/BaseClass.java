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
        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win32\\chromedriver.exe");

        // Initialize the WebDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
    	System.out.println("Tear Down called");
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
