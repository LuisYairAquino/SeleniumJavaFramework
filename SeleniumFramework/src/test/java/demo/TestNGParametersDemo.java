package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {

	@Test
	@Parameters({"MyName"})
	public void test(@Optional("Luis Aquino") String name) { //Lo podemos poner como opcional también con el tag @Optional en el parametro
		System.out.println("The name is : " + name); 
	}
	
}
