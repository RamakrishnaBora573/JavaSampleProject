package webtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableDemo {
	
	
	WebDriver driver=null;
	@Test
	public void handlingWebTable()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\JavaWorkSpace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/web-table-element.php");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.xpath("//table[@class='dataTable']/thead"));
		List<WebElement> li = element.findElements(By.tagName("th"));
		
		System.out.println(li.size());
		
		for(int i=0;i<li.size();i++)
		{
			System.out.println(li.get(i).getText());
		}
		
		boolean bStatus = driver.findElement(By.xpath("//a[contains(text(),'Bharat') and contains(text(),'Petroleum')]")).isDisplayed();
		if(bStatus)
		{
			System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Bharat Petroleum')]/../following::td[2]")).getText());
		}
	}

}
