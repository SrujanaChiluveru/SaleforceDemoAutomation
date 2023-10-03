package com.Saleforce.SaleforceDemo.QA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Saleforce.SaleforceDemo.QA.TestBase.TestBase;

public class MainNavigationBar extends TestBase {
	
	public MainNavigationBar()
	{
		PageFactory.initElements(driver, this);
	}
	
// ***************** Object Repository
@FindBy(xpath ="//div[@class='slds-global-header__item']//div[@class='slds-global-header__logo']")
WebElement logo;

@FindBy(xpath ="//button[@aria-label='Search']")
WebElement searchbox;

@FindBy(xpath = "//ul[@class='slds-global-actions']//button[contains(@class,'branding-favorites-star-button')]")
WebElement addFavorite;

@FindBy(xpath = "//ul[@class='slds-global-actions']//button[contains(@class,'branding-favorites-list-button')]")
WebElement favoriteList;

@FindBy(xpath = "//ul[@class='slds-global-actions']//li//a[contains(@class,'globalCreateTrigger')]")
WebElement globalActions;

@FindBy(xpath = "//ul[@class='slds-global-actions']//button[@aria-label='Guidance Center']")
WebElement guidenceCenter;

@FindBy(xpath = "//ul[@class='slds-global-actions']//button[contains(@class,'slds-global-actions__help')]")
WebElement help;

@FindBy(xpath = "//ul[@class='slds-global-actions']//li//a[contains(@class,'slds-global-actions__setup')]")
WebElement setup;

@FindBy(xpath = "//ul[@class='slds-global-actions']//button[contains(@class,'slds-global-actions__notifications')]")
WebElement Notifications;

@FindBy(xpath = "//ul[@class='slds-global-actions']//button[contains(@class,'branding-userProfile-button')]")
WebElement userProfile;

//Actions



}
