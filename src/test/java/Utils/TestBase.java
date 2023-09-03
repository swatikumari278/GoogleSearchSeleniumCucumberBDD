package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");//used this because to read property we created object prop and prop takes file input steam as args
		Properties prop = new Properties();
		prop.load(fs);
		String url = prop.getProperty("GoogleUrl");
		String browser_properties = prop.getProperty("browser");
		//This browser if you specify in maven command by running it by command line maven
		String browser_maven = System.getProperty("browser");
		String browser = browser_maven!=null ? browser_maven:browser_properties;

		if(driver == null) {

			if(browser.equalsIgnoreCase("Chrome"))
				{	System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
				}
				if(browser.equalsIgnoreCase("firefox")){
					System.setProperty("webDriver.gecko.driver",System.getProperty("user.dir")+"//src//test//resources//geckodriver.exe");
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
				}
				driver.get(url);
			}
			return driver;
		}
	}

