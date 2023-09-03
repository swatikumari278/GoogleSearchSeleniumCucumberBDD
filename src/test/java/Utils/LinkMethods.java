package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class LinkMethods {

	private WebDriver driver;
	
	public LinkMethods(WebDriver driver) {

		this.driver = driver;
	
	}
	
	public void clickLink(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}
	
	public void clickPartialLink(String partialLinkText) {
		driver.findElement(By.partialLinkText(partialLinkText)).click();
	}
	
	public String getHyperLink(By locator){
		return getHyperLink(driver.findElement(locator));
	}
	
	public String getHyperLink(WebElement element) {
		String link = element.getAttribute("hreg");
		return link;
	}
	
}
