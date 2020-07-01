package test;

import java.io.IOException;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTestNG {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extentTestng.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test1() throws Exception {
		ExtentTest test = extent.createTest("My First Test", "Sample description");
		
		driver.get("https://google.com");
		test.pass("Navigated to google.com");
		
		test.log(Status.INFO, "This step shows usage of log(status, details");
		test.info("This step shows usage of info (details)");
		//log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		// test with snapshots
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@Test
	public void test2() throws Exception {
		ExtentTest test = extent.createTest("My First Test", "Sample description");
		
		driver.get("https://google.com");
		test.pass("Navigated to google.com");
		
		test.log(Status.INFO, "This step shows usage of log(status, details");
		test.info("This step shows usage of info (details)");
		//log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		// test with snapshots
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

}
