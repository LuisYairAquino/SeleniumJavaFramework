package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {

	static WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public static void googleSearch2() throws InterruptedException {

		// goto google.com
		driver.get("https://google.com");

		// enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		// click on search button
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("q")).submit();
		Thread.sleep(4000);

	}
	
	@Test
	public static void googleSearch3() throws InterruptedException {

		// goto google.com
		driver.get("https://google.com");

		// enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		// click on search button
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("q")).submit();
		Thread.sleep(4000);
		

	}

	@AfterTest
	public void tearDownTest() {
		// close browser
		driver.close();
		System.out.println("Test Completed Successfully");
	}

}
