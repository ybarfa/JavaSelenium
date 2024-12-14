package learningSelenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import common.BaseClass;

public class DynamicContent extends BaseClass {

    @Test
    public void verifyDynamicContent() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement initialElement = driver.findElement(By.xpath("//a[@href='/dynamic_content']"));
        initialElement.click();

        WebElement dynamicContent = driver.findElement(By.xpath("//div[@class='large-10 columns large-centered']"));
        String initialText = dynamicContent.getText();

        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(dynamicContent));    // To Handle StaleElementReferenceException

        WebElement updatedElement = driver.findElement(By.cssSelector(".large-10.columns"));
        String updatedText = updatedElement.getText();

        if (!initialText.equals(updatedText)) {
            System.out.println("Dynamic Content has been Changed");
        } else {
            System.out.println("Dynamic Content has not been Changed");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
