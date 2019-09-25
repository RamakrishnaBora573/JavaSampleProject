package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDiverTest {
	
	WebDriver driver=null;

	@Test
	public void runMethod()
	{
		  System.setProperty("webdriver.chrome.driver", "C:\\FrameworkJar\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
		  driver.get(arg0);
		  
		  System.out.println("Before"+driver.getTitle());
          driver.navigate().to("http://www.google.com");
          driver.navigate().to("http://www.facebook.com");
          driver.navigate().to("http://www.india.com");
          driver.navigate().back();
          driver.quit();
          
		
		
	}

}


