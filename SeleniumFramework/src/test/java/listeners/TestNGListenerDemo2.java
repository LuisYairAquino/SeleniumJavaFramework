package listeners;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class) //esto se puede eliminar ya con el testng.xml
public class TestNGListenerDemo2 {
	
	@Test
	public void test4() {
		System.out.println("I am inside the test 4");
	}
	
	@Test
	public void test5() {
		System.out.println("I am inside the test 5");
	}
	
	@Test
	public void test6() {
		System.out.println("I am inside the test 6");
		throw new SkipException("This test is skipeed");
	}

}
