package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleWebDriver {
	
	WebDriver driver;
	
	@Test
	public void invokeDriver() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\JavaWorkSpace\\chromedriver4Chrome75\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://inforonestop");
		//driver.get("http://rbora:Rama&Infor86@inforonestop");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		//driver.switchTo().alert()driver.findElement(By.)
		
	}

}
