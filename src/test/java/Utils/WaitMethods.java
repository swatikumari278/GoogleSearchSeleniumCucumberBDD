package Utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethods {

private WebDriver driver;
WebDriverWait wait;
int timeOutInSeconds = 20;


/** Method to wait 
 * @param time : String : Time to wait
 * @param method : String : wait by sleep or implicit method 
 * @throws NumberFormatException
 * @throws InterruptedException
 */
public void sleep(int timeOutInSeconds) throws NumberFormatException, InterruptedException
{
	//sleep method takes parameter in milliseconds
	Thread.sleep(timeOutInSeconds);
}

public WaitMethods(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver,Duration.ofSeconds(timeOutInSeconds));
}

public void setImplicitWait(int timeOutInSeconds) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutInSeconds));
}
public void pageLoadWait(int timeOutInSeconds) {
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOutInSeconds));
	
}
public void waitForElementVisible(By locator) {
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
}

public void elementExits(By locator) {
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}



public void waitForIframe(By locator) {
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	driver.switchTo().defaultContent();
} 


public void elementToBeClickable(By locator) {
	wait.until(ExpectedConditions.elementToBeClickable(locator));
}


}
