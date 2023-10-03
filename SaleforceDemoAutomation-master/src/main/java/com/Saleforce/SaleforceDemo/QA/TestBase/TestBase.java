package com.Saleforce.SaleforceDemo.QA.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.Saleforce.SaleforceDemo.QA.Util.EventListeners;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverListener eventListner;
	
	public TestBase()
	
	{
		prop= new Properties();
		try {
			FileInputStream ip = new FileInputStream("E:\\EclipseWorkSpace\\SaleforceDemo\\SaleforceDemoAutomation-master\\src\\main\\java\\com\\Saleforce\\SaleforceDemo\\QA\\Config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void initilize() {
		String browser= prop.getProperty("browser");
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
		}
		else if (browser.equals("Safari")) {
			
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
		}
	eventListner = new EventListeners();
	driver= new EventFiringDecorator<WebDriver>(eventListner).decorate(driver);
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	
	//Launch URL
	driver.get(prop.getProperty("url"));
	
	}
	

}
