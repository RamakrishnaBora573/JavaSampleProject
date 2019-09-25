package naukri;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ResumeUpload {
	
	WebDriver driver=null;
	
	@Test
	public void resumeUploadIntoNaukri() throws IOException, InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\JavaWorkSpace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[text()='Login']/ancestor::a[contains(@title,'Jobseeker')]")).click();
		
		driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("ramakrishna.qa027@gmail.com");		
		driver.findElement(By.xpath("//input[@name = 'PASSWORD']")).sendKeys("Rama@Naukri86");
		driver.findElement(By.xpath("//button[@value= 'Login']")).click();		
		driver.findElement(By.xpath("//a[text()='UPDATE PROFILE']")).click();
		
		driver.findElement(By.xpath("//input[@id='attachCV']")).click();
		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\AutoIT\\resumeUpload.exe");
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
		
		
		
		
		
	}

}
