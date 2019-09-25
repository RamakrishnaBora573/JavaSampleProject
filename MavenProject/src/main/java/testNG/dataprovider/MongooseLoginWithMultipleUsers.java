package testNG.dataprovider;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MongooseLoginWithMultipleUsers {
	
	WebDriver driver;
	
	String sTestCaseName=null;
	int iTestCaseRow;
	
/*	@BeforeMethod
	public void accessMongooseHomePage()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\JavaWorkSpace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.46.74.82/slxclient/default.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
	}*/
	@DataProvider
	public Object[][] getLoginCredentials() throws Exception{
		
		GetDataFromExcel.setExcelFile("C:\\JavaWorkSpace\\MavenProject\\src\\main\\java\\testNG\\dataprovider\\testData\\TestData.xlsx","Login");
		sTestCaseName = this.toString();
		 
	    // From above method we get long test case name including package and class name etc.
	 
	    // The below method will refine your test case name, exactly the name use have used
	 
	    sTestCaseName = GetDataFromExcel.getTestCaseName(this.toString());
	 
	     // Fetching the Test Case row number from the Test Data Sheet
	 
	     // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
	 
	     iTestCaseRow = GetDataFromExcel.getRowContains(sTestCaseName,0);
	 
	     Object[][] testObjArray = GetDataFromExcel.getTestData("C:\\JavaWorkSpace\\MavenProject\\src\\main\\java\\testNG\\dataprovider\\testData\\TestData.xlsx","Login",iTestCaseRow);
	 
	      return (testObjArray);
	 
		}
	
	@Test(dataProvider="getLoginCredentials")
	public void loginIntoApplication(String sTestCaseName,String sUserName,String sPassword)
	{
		
				/*driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys(sUserName);
				
				driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
				
				driver.findElement(By.xpath("//input[@id='configCombo-inputEl']")).sendKeys("Mongoose");
				
				driver.findElement(By.xpath("//span[@id='signinBtn-btnInnerEl']")).click();*/
		System.out.println(sTestCaseName);
		System.out.println(sUserName);
		System.out.println(sPassword);
	
		
	}
	/*@AfterMethod
	public void closeBrowser() 
	{		
		driver.close();
		
		
	}*/

}
