package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class) //esto se puede eliminar ya con el testng.xml
public class TestNGListenerDemo {
	
	@Test
	public void test1() {
		System.out.println("I am inside the test");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside the test 2");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://google.com/");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("abcd");
		
		driver.close();
	}
	
	@Test
	public void test3() {
		System.out.println("I am inside the test 3");
		throw new SkipException("This test is skipeed");
	}

}
