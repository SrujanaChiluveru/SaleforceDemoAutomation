package com.Saleforce.SaleforceDemo.QA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Saleforce.SaleforceDemo.QA.TestBase.TestBase;

public class LoginPage extends TestBase {
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
		
	}
	//***** Page Factory****//
	
	@FindBy(id = "username")
	WebElement txtusername;
	
	@FindBy(id="password")
	WebElement txtpassword;
	
	@FindBy(id="Login")
	WebElement btnLogin;
	
	@FindBy(id="forgot_password_link")
	WebElement lnkForgotPwd;
	
	//**** Actions
	
	public MainNavigationBar loginToAppAsSysAdmin() {
		txtusername.sendKeys(prop.getProperty("SysAdminUserName"));
		txtpassword.sendKeys(prop.getProperty("SysAdminPassword"));
		btnLogin.click();
		return new MainNavigationBar();
		
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public ForgotPwdPage clickForgotPwdlink() {
		
		lnkForgotPwd.click();
		return new ForgotPwdPage();
		
	}
	

}
