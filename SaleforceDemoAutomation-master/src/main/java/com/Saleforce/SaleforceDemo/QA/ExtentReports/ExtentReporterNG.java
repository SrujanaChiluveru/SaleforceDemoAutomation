package com.Saleforce.SaleforceDemo.QA.ExtentReports;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG implements IReporter{
	
	private ExtentReports extent;
	private ExtentSparkReporter extentSparkReporter;
	
	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> suites, String outputDirectory) {
		
		String reportPath= outputDirectory+File.separator+"Extent.html";
		extent= new ExtentReports();
		extentSparkReporter= new ExtentSparkReporter(reportPath);
		extent.attachReporter(extentSparkReporter);
		
		for (ISuite iSuite : suites) {
			Map<String, ISuiteResult> result= iSuite.getResults();
			for (ISuiteResult r : result.values()) {
				ITestContext context= r.getTestContext();
				buildTestNodes(context.getPassedTests(), Status.PASS);
				buildTestNodes(context.getPassedTests(), Status.FAIL);
				buildTestNodes(context.getPassedTests(), Status.SKIP);
				
				
			}
		}
		extent.flush();
	}
	
	private void buildTestNodes(IResultMap resultMap, Status status) {
		ExtentTest test;
		if (resultMap.size()>0) {
			for (ITestResult result : resultMap.getAllResults()) {
				test= extent.createTest(result.getMethod().getMethodName());
				for (String group  : result.getMethod().getGroups()) {
					test.assignCategory(group);
					
					if (result.getThrowable()!= null) {
						test.log(status, result.getThrowable());
						
					}else {
						test.log(status, "Test "+status.toString().toLowerCase()+"ed");
					}
					
				}
				
			}
			
		}
		
	}
}
