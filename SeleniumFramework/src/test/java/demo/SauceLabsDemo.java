package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsDemo {

	public static final String USERNAME = "LuisAquino";
	public static final String ACCESS_KEY = "5105fe05-831c-4c07-8c6c-bff397108597";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Linux");
		caps.setCapability("version", "latest");
		caps.setCapability("name", "GoogleTestAquino");
		caps.setCapability("extendedDebugging", "true");

		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Step By Step");
		driver.findElement(By.name("q")).submit();
		System.out.println(driver.getTitle());
		
		driver.quit();
		System.out.println("Test Completed");
		
		
	}

}
