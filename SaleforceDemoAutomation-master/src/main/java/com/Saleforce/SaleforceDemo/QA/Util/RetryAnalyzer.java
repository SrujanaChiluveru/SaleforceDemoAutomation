package com.Saleforce.SaleforceDemo.QA.Util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
 
	int count=0;
	int retrylimit=3;
 
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<retrylimit)
		{
			count++;
			return true;
		}
		return false;
	}

	

}
