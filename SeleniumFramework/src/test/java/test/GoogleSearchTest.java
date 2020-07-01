package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		googleSearch();
	}

	public static void googleSearch() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();

		// goto google.com
		driver.get("https://google.com");

		// enter text in search textbox
		// driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		GoogleSearchPage.textBox_search(driver).sendKeys("Automation Step by Step");

		// click on search button
		// driver.findElement(By.name("btnK")).click();
		// driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		GoogleSearchPage.button_search(driver).sendKeys(Keys.ENTER);

		// close browser
		driver.close();

		System.out.println("Test Completed Successfully");

	}

}
