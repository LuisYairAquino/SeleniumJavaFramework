package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) throws IOException, InterruptedException {

		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("Google Search Test One",
				"This is a test to validate google search functionality");

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();

		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");

		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Automation");
		Thread.sleep(5000);
		test1.pass("Entered text in searchbox");
		searchbox.submit();
		Thread.sleep(5000);

		driver.close();
		driver.quit();
		test1.pass("Closed browser");

		test1.info("Test Completed!");
		
		
		
		Thread.sleep(5000);
		// creates a toggle for the given test, adds all log events under it
		ExtentTest test2 = extent.createTest("Google Search Test Two",
				"This is a test to validate google search functionality");

		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();

		test2.log(Status.INFO, "Starting Test Case");
		driver.get("https://google.com");
		test2.pass("Navigated to google.com");

		WebElement searchbox2 = driver.findElement(By.name("q"));
		searchbox2.sendKeys("Automation");
		test2.fail("Entered text in searchbox");
		searchbox2.submit();

		driver.close();
		driver.quit();
		test2.pass("Closed browser");

		test2.info("Test Completed!");

		// calling flush writes everything to the log file
		extent.flush();

	}
}
