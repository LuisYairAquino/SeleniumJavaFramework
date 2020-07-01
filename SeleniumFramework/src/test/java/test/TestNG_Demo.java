package test;

import java.util.Arrays;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import demo.Log4jDemo;

public class TestNG_Demo {

	static WebDriver driver = null;
	public static String browserName = null;
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);

	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver(); 
		}

		logger.info("Browser started");
		
	}

	@Test
	public static void googleSearch() throws InterruptedException {

		// goto google.com
		driver.get("https://google.com");

		// enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		//driver.findElement(By.cssSelector("body > app-root > div > main > app-landing-page > div.o-temp-auth > button")).click();

		// click on search button
		// driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("q")).submit();
		Thread.sleep(4000);

	}

	@AfterTest
	public void tearDownTest() {
		// close browser
		driver.close();
		System.out.println("Test Completed Successfully");
		PropertiesFile.setProperties();
	}

}
