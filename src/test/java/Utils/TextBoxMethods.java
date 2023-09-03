package Utils;

import org.openqa.selenium.*;

public class TextBoxMethods {
	
	private WebDriver driver;
	
	public TextBoxMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void typeText(By locator,String value) {
		driver.findElement(locator).sendKeys(value);
	}
	
	public void enterKey(WebElement element,Keys key) {
	  element.sendKeys(key);	
	}
	public void clear(By locator) {
		driver.findElement(locator).clear();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void clearAndType(By locator,String value) {
		WebElement element =  driver.findElement(locator);
		element.clear();
		element.sendKeys(value);
	}
}
