package learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import common.BaseClass;

public class DragAndDrop extends BaseClass {

	@Test
	public void dragDrop() throws InterruptedException{
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(driver.findElement(By.id("column-a")), driver.findElement(By.id("column-b")));
		
		Thread.sleep(3000);

	}

}
