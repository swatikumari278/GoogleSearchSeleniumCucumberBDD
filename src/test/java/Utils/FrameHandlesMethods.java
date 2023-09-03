package Utils;

import org.openqa.selenium.*;

public class FrameHandlesMethods {
	private WebDriver driver;
	private WebElement element;
	private WaitMethods wait;

	
	public FrameHandlesMethods(WebDriver driver) {
		this.driver = driver;
		wait = new WaitMethods(this.driver);
	
	}
	/** Method to switch frame using web element frame */
   public void switchFrame(By locator)
   {
        wait.elementExits(locator);
   		element = driver.findElement(locator);
   		driver.switchTo().frame(element);
   	
   }
   
   /** method to switch to default content*/
   public void switchToDefaultContent()
   {
   	driver.switchTo().defaultContent();
   }
}
