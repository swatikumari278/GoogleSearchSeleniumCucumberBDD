package pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utils.ClickMethods;
import Utils.MiscellaneousMethods;
import Utils.ReadExcelMethod;
import Utils.TextBoxMethods;
import Utils.WaitMethods;

public class GoogleSearchPage {

	WebDriver driver;
    ClickMethods click;
    WaitMethods wait;
    MiscellaneousMethods mis;
    TextBoxMethods text;
    ReadExcelMethod read;

public GoogleSearchPage(WebDriver driver) {
		 this.driver=driver;
		 click = new ClickMethods(this.driver);
		 wait = new WaitMethods(this.driver);
		 mis = new MiscellaneousMethods(driver);
		 text = new TextBoxMethods(driver);
		 read = new ReadExcelMethod(driver);
		 
}

private By popUpLocator = By.xpath("//button[contains(text(),'Got It, thanks')]");
private By SearchLocator = By.xpath("//textarea[@type='search']");
public static String excelFilePath ="C://GoogleSearchProduct.xlsx";
private WebElement element;

public void AssertTitle() {
	Assert.assertTrue(mis.getTitle().contains("Google"));
}
	
public void dismissPopUpNotification() {
	click.clickElement(popUpLocator);
}
public void SerchProduct(String product) {
	element = mis.getWebElement(SearchLocator);
	text.typeText(SearchLocator, product);
	text.enterKey(element,Keys.ENTER);
}

public void validationOfSearchProduct(String product) {
	String searchText=text.getText(SearchLocator);
	Assert.assertEquals(product, searchText);
	
}
public void readDataByExcel(String sheetName, int rowNumber) throws InvalidFormatException, IOException{
	List<Map<String, String>> testData=	read.getData(excelFilePath, sheetName);
	String product = testData.get(rowNumber).get("Product");
	SerchProduct(product);
	
}
}
