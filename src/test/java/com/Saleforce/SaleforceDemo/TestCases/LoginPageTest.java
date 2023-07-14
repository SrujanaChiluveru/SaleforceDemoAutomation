package com.Saleforce.SaleforceDemo.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Saleforce.SaleforceDemo.QA.Pages.LoginPage;
import com.Saleforce.SaleforceDemo.QA.Pages.MainNavigationBar;
import com.Saleforce.SaleforceDemo.QA.TestBase.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	MainNavigationBar mainNavigationBar;

	public LoginPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initilize();
		loginPage = new LoginPage();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void validLoginTest() {
		mainNavigationBar=loginPage.loginToAppAsSysAdmin();		
		
	}
	
}
