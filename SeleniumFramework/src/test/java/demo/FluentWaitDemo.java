package demo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {
	
	public static void main(String[] args) throws Exception {
		test1();
	}

	public static void test1() throws Exception {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Abcd");
		driver.findElement(By.name("q")).submit();
		
		//driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH")).click();;
		
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver.findElement(By.linkText("El ABCD de la creatividad efectiva en YouTube"));
				
				if (linkElement.isEnabled()) {
					System.out.println("Element found");
				}
				return linkElement;
			}
		});
		
		element.click();
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
