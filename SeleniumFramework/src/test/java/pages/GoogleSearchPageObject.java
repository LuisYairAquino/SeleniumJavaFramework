package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObject {
	
	WebDriver driver = null;
	
	By textbox_search = By.name("q");
	
	public GoogleSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getPage(String url) {
		driver.get(url);
	}
	

	public void setTextInSearchButton(String text){
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(textbox_search).sendKeys(Keys.ENTER);
	}
	
	public void closeDriver() {
		driver.close();
	}

}
