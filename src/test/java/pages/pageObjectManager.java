package pages;

import org.openqa.selenium.WebDriver;

public class pageObjectManager {

public WebDriver driver;
public GoogleSearchPage googleSearchPageObj;

public pageObjectManager(WebDriver driver) {
	this.driver=driver;
}

public GoogleSearchPage getGoogleSearchPageObject() {
	googleSearchPageObj = new GoogleSearchPage(driver);
	return googleSearchPageObj;
	
}


}
