package learningSelenium;

import common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdown extends BaseClass { 
    
    @Test
    public void handleDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Option 2");
    }
}
