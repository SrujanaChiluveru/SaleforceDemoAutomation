package com.Saleforce.SaleforceDemo.QA.Util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Saleforce.SaleforceDemo.QA.TestBase.TestBase;

public class TestStatusListner extends TestBase implements ITestListener{

	public void onTestFailure(ITestResult result) {
		TestUtil.takeScreenShot(result.getMethod().getMethodName());
		
	}
}
