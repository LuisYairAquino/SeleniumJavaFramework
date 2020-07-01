package demo;

import org.testng.annotations.Test;

@Test(groups = {"AllTestCases"})
public class TestNgGroupsDemo {
	
	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("This is test 1");
	}
	
	@Test(groups = {"sanity", "smoke"})
	public void test2() {
		System.out.println("This is test 2");
	}
	
	@Test(groups = {"windows.regression"})  //(groups = {"sanity","regression"})
	public void test3() {
		System.out.println("This is test 3");
	}
	
	@Test(groups = {"linux.regression"})
	public void test4() {
		System.out.println("This is test 4");
	}

}
