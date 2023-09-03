package Utils;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownMethods {

	WebDriver driver;
	public DropDownMethods(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void SelectUsingVisibleValue(By locator,String visibleValue) {
		SelectUsingText(driver.findElement(locator),visibleValue);
	}
	
	public void SelectUsingText(WebElement element,String visibleValue) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
		
	}
	
	public void SelectUsingValue(By locator,String value) {
		Select select = new Select(driver.findElement(locator));
		select.selectByValue(value);
	
	}
	
	public void SelectUsingIndex(By locator,int index) {
		Select select = new Select(driver.findElement(locator));
		select.selectByIndex(index);
		
	}
	
	public String getSelectedValue(By locator) {
		
		return getSelectedValue(driver.findElement(locator));
	}
	
	public String getSelectedValue(WebElement element) {
		String value = new Select(element).getFirstSelectedOption().getText();
		return value;
	}
	
	
	public List<String> getAllDropDownValues(By locator) {
		Select select = new Select(driver.findElement(locator));
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		
		for (WebElement element : elementList) {
			valueList.add(element.getText());
		}
		return valueList;
	}
	
	
}
