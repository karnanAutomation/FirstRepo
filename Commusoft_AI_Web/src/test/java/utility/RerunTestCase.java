package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import action.Baseclass;
import action.Wrapper;

public class RerunTestCase extends Baseclass implements IRetryAnalyzer{

	private int RetryCount=0;
	private static final int maxcount = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(RetryCount < maxcount) 
		{
			RetryCount++;
			return true;
		}
		return false;
	}

}
