package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDemo {
	
		
	@Parameters("strValue")
	@Test(priority=1)
	public void method(String str)
	{
		
		System.out.println("Method"+str);
	}
	
	@Parameters("intValue")
	@Test(priority=0)
	public void method(int i)
	{
		
		System.out.println("Method 1"+i);
	}
	
	@Parameters("longValue")
	@Test(priority=2)
	public void method(long l)
	{
		
		System.out.println("Method 2"+l);
	}
	

}
