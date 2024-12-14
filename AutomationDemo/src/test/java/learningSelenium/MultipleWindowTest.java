package learningSelenium;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseClass;

public class MultipleWindowTest extends BaseClass {

    @Test
    public void multipleWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector(".example a")).click();

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        
        // Switch to the first window and verify its title
        driver.switchTo().window(windowHandles.get(0));
        Assert.assertEquals("The Internet", driver.getTitle());

        // Switch to the new window
        driver.switchTo().window(windowHandles.get(1));

        // Wait until the new window has a title
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> !driver.getTitle().isEmpty());
        
        // Pause for 3 seconds after opening the new window
        Thread.sleep(3000);
        
        Assert.assertEquals("New Window", driver.getTitle());
    }

    @Test
    public void multipleWindowsRedux() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        // Get initial window handle
        String firstWindow = driver.getWindowHandle();
        String newWindow = "";

        // Trigger new window to open
        driver.findElement(By.cssSelector(".example a")).click();

        // Grab all window handles and find the new one
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        for (String window : windowHandles) {	
            if (!window.equals(firstWindow)) {
                newWindow = window;
            }
        }

        // Switch to the first window and verify its title
        driver.switchTo().window(firstWindow);
        Assert.assertEquals("The Internet", driver.getTitle());

        // Switch to the new window and verify its title
        driver.switchTo().window(newWindow);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> !driver.getTitle().isEmpty());

        // Pause for 3 seconds after opening the new window
        Thread.sleep(3000);

        Assert.assertEquals("New Window", driver.getTitle());
    }
}
