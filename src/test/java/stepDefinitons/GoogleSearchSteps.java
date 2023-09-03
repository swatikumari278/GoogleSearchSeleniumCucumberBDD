package stepDefinitons;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import Utils.TestContextSetup;
import io.cucumber.java.en.*;
import pages.GoogleSearchPage;

public class GoogleSearchSteps {

	private TestContextSetup testContextSetup;
	private GoogleSearchPage gSObj;

	public GoogleSearchSteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		gSObj = testContextSetup.pageObjectManager.getGoogleSearchPageObject();
	}

	@Given("User in on Google Page")
	public void user_in_on_google_page() {
		gSObj.AssertTitle();
	}

	@When("^User searches for the (.+) on the google page$")
	public void user_search(String product) {
		gSObj.SerchProduct(product);
	}

	@Then("^Searched (.+) should be visible$")
	public void searched_product_should_be_visible(String product) {
		gSObj.validationOfSearchProduct(product);
	}

	@When("^User searches the product in \"([^\"]+)\" with (\\d+)$")
	public void search_product_using_excel(String SheetName, int RowNumber) throws InvalidFormatException, IOException {
		gSObj.readDataByExcel(SheetName, RowNumber);

	}
}
