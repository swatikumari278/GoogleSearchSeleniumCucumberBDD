package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickMethods {

private WebDriver driver;
private WaitMethods wait;
private WebElement element;

public ClickMethods(WebDriver driver) 
{
	this.driver = driver;
	wait = new WaitMethods(this.driver);
	
}
public void clickElement(By locator) {
	wait.elementToBeClickable(locator);
	driver.findElement(locator).click();
}

public void clickForcefully(By locator)
{
	wait.elementExits(locator);
	element = driver.findElement(locator);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();",element);
}
public void doubleClick(By locator)
{
	wait.elementExits(locator);
	element = driver.findElement(locator);
	Actions action = new Actions(driver);
	action.moveToElement(element).doubleClick().perform();
}

}
