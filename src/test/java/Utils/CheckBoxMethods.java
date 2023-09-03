package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxMethods {

	private WebDriver driver;
	
    public CheckBoxMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectCheckBox(By locator) {
		selectCheckBox(driver.findElement(locator));
	}
	
	public void unSelectCheckBox(By locator) {
		unSelectCheckBox(driver.findElement(locator));
	}
	
	public boolean isIselectedMethod(By locator) {
		return isIselected(driver.findElement(locator));
	}
	
	public boolean isIselected(WebElement element) {
		boolean flag = element.isSelected();
		return flag;
	}
	
	public void selectCheckBox(WebElement element) {
		if(!isIselected(element))
			element.click();
	}
	
	public void unSelectCheckBox(WebElement element) {
		if(isIselected(element))
			element.click();
	}
	
	
	
}
