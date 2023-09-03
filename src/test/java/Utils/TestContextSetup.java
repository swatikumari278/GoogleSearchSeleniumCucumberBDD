package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import pages.pageObjectManager;

public class TestContextSetup {
	 public WebDriver driver;
	 public String acutalProductName;
     public pageObjectManager pageObjectManager;
     public TestBase testBase;
   
   public TestContextSetup() throws IOException
   {
	   testBase = new TestBase();
	   pageObjectManager = new pageObjectManager(testBase.WebDriverManager());
	   
   }
	 
	 
}
