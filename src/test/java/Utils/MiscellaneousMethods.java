package Utils;

import org.openqa.selenium.*;

public class MiscellaneousMethods {
	
	private WebDriver driver;

	public MiscellaneousMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return driver.getCurrentUrl();
	}
	public WebElement getWebElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
}
