package reRunFailedTestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMultipleThreadsINvocationCOunt {
	
	WebDriver driver;
	@Test(invocationCount = 5,threadPoolSize = 3)
	public void loadTestThisWebsite() {

		System.setProperty("webdriver.chrome.driver", "C:\\JavaWorkSpace\\chromedriver4Chrome75\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Page Title is " + driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();

	}
	
	/*@Test(invocationCount = 3, threadPoolSize = 3)
	  public void testThreadPools() {

		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
			
	  }*/

}
