package com.qa.Projecttestscripts;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.Projecttestscripts.TrainStatusTablePOM;

public class TestBase_TrainStatusTable {
	

	WebDriver driver;
	TrainStatusTablePOM trainstatus_or;
	
	@Parameters({"Browser","Url"})

	@BeforeClass
	public void setup(String Browser,String Url)
	{
		if(Browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions chrome_Profile=new ChromeOptions();
			chrome_Profile.addArguments("chrome.switches","--disable-extensions");
			chrome_Profile.addArguments("disable-infobars");	 
			chrome_Profile.setExperimentalOption("useAutomationExtension", false);
			chrome_Profile.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			System.setProperty("webdriver.chrome.driver","SeleniumProjects\\Externaldownloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver(chrome_Profile);
			driver.manage().window().maximize();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver","SeleniumProjects\\Externaldownloads\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		
		trainstatus_or=new TrainStatusTablePOM(driver);
		driver.get(Url);
		
	}
		
		@AfterClass
		public void tearDown()
		{
			driver.close();
		}
		
		public void captureScreenshot(WebDriver driver,String tname) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File Source=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
			FileUtils.copyFile(Source,target);
			System.out.println("Screenshot is Captured");
		}
		
}