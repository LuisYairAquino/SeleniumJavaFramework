package pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	private static WebElement element = null;

	public static WebElement textBox_search(WebDriver driver) {

		element = driver.findElement(By.name("q"));
		return element;

	}

	public static WebElement button_search(WebDriver driver) {

		element = driver.findElement(By.name("q"));
		return element;

	}

}
