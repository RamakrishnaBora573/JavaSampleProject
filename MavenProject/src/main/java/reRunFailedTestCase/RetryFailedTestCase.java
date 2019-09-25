package reRunFailedTestCase;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCase implements IRetryAnalyzer{
	
	private int iRetryCount = 0;
	private int iMaxRetryCount = 2;
	
	public boolean retry(ITestResult result)
	{
		if(iRetryCount<=iMaxRetryCount)
		{
			
		    System.out.println("Retrying : "+result.getName()+" again the count is "+(iRetryCount+1));	
		    iRetryCount++;
		    return true;			
		}		
		
		return false;		
		
	}

}
