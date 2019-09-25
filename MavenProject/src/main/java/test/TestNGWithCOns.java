package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGWithCOns {
	
	TestNGWithCOns()
	{
		System.out.println("Constructor");
	}
	
	@Test
	public void testMethod()
	{
		System.out.println("Test Method1");
	}
	
	@BeforeClass
	public void beforeClassMethod()
	{
		System.out.println("Test Method2");
	}

}
