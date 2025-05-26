package automationCore;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;


public class BaseClass {
	
	Properties property;
	FileInputStream fileinput;
	
	public WebDriver driver;
	WaitUtility implicitWait = new WaitUtility();
	
	 @BeforeMethod
	 @Parameters("browser")
	  public void initialiseBrowser(String browser) throws Exception {
		 property= new Properties();
		 fileinput = new FileInputStream(Constant.configFile);
		 property.load(fileinput);
		  //driver= new ChromeDriver();
		 if(browser.equalsIgnoreCase("Chrome"))
		 {
			 driver= new ChromeDriver();
		 }
		 else if(browser.equalsIgnoreCase("Firefox"))
		 {
			 driver= new FirefoxDriver();
		 }
		 else if(browser.equalsIgnoreCase("Edge"))
		 {
			 driver= new EdgeDriver();
		 }
		 else {
			 throw new Exception("Invalid browser");
		 }
		  driver.get(property.getProperty("baseurl"));
		  //driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		  driver.manage().window().maximize();
		  implicitWait.implicitWait(driver);
	  }
	 
	 @AfterMethod
	 public void driverQuit(ITestResult itestresult) throws IOException { 
		 if(itestresult.getStatus()==ITestResult.FAILURE) {
			 ScreenshotUtility screenshotutility = new ScreenshotUtility();
			 screenshotutility.getScreenshot(driver, itestresult.getName());
		 }
		driver.quit();
	 }
	 
	 
	}




