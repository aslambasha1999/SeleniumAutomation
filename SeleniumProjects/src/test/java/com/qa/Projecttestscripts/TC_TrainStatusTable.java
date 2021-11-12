package com.qa.Projecttestscripts;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.Projecttestscripts.TestBase_TrainStatusTable;
import com.qa.utility.ExcelUtility;

public class TC_TrainStatusTable extends TestBase_TrainStatusTable{
	
	@Test(dataProvider="getData",priority=1)
	public void TrainStatusTable(String Input1) throws IOException, InterruptedException
	{
		captureScreenshot(driver,"TrainStatusTable");
		trainstatus_or.getTrainInfoTab().click();
		Thread.sleep(1000);
		trainstatus_or.getLiveTrainStatusLink().click();
		trainstatus_or.getEnterTrainNo().clear();
		trainstatus_or.getEnterTrainNo().sendKeys(Input1);
		trainstatus_or.getEnterTrainNo().submit();
		
		Assert.assertTrue(driver.getCurrentUrl().contains(Input1));				
		for(WebElement tdata:driver.findElements(By.tagName("tr")))
		{
			Reporter.log(tdata.getText(),true);
		}
		Thread.sleep(3000);
	}
	
	@Test(dataProvider="getData1",priority=2)
	public void TrainStatusTableNeg(String Input2) throws IOException, InterruptedException
	{
		captureScreenshot(driver,"TrainStatusTableNeg");
		trainstatus_or.getTrainInfoTab().click();
		Thread.sleep(1000);
		trainstatus_or.getLiveTrainStatusLink().click();
		Thread.sleep(1000);
		trainstatus_or.getEnterTrainNo().clear();
		trainstatus_or.getEnterTrainNo().sendKeys(Input2);
		trainstatus_or.getEnterTrainNo().submit();
		Thread.sleep(1000);
		
		Assert.assertFalse(driver.getCurrentUrl().contains(Input2));					
		for(WebElement tdata:driver.findElements(By.tagName("tr")))
		{
			Reporter.log(tdata.getText(),true);
		}
		Thread.sleep(3000);
	}
	
	@Test(dataProvider="getData2",priority=3)
	public void SearchforTrainsTab(String Input1,String Input2) throws InterruptedException, IOException
	{
		
		captureScreenshot(driver,"SearchforTrainsTab");
		trainstatus_or.getTrainInfoTab().click();
		Thread.sleep(1000);
		trainstatus_or.getTrainsBtwStations().click();
		trainstatus_or.getfromStation().sendKeys(Input1);
		Thread.sleep(5000);
		trainstatus_or.getfromStation().sendKeys(Keys.ARROW_DOWN);
		trainstatus_or.getfromStation().sendKeys(Keys.ENTER);
		trainstatus_or.getfromStation().sendKeys(Keys.TAB);
		trainstatus_or.gettoStation().sendKeys(Input2);
		Thread.sleep(5000);
		trainstatus_or.gettoStation().sendKeys(Keys.ARROW_DOWN);
		trainstatus_or.gettoStation().sendKeys(Keys.ENTER);
		
		trainstatus_or.getSearchTrainsBtn().click();	
		
		Assert.assertTrue(driver.getTitle().contains("Trains: Tickets, Fare and Availability"));	
		
		List<WebElement> trainsList=driver.findElements(By.xpath("//div[@class='TrainInFo-block']"));
		for(WebElement ele:trainsList)
		{
			Reporter.log(ele.getText(),true);
		}
		
		Thread.sleep(2000);
				
	}
	
	
	@Test(dataProvider="getData3",priority=4)
	public void SearchforTrainsTabNeg(String Input1,String Input2) throws InterruptedException, IOException
	{
		captureScreenshot(driver,"SearchforTrainsTabNeg");
		trainstatus_or.getTrainInfoTab().click();
		Thread.sleep(1000);
		trainstatus_or.getTrainsBtwStations().click();
		trainstatus_or.getfromStation().sendKeys(Input1);
		Thread.sleep(5000);
		trainstatus_or.getfromStation().sendKeys(Keys.ARROW_DOWN);
		trainstatus_or.getfromStation().sendKeys(Keys.ENTER);
		trainstatus_or.getfromStation().sendKeys(Keys.TAB);
		trainstatus_or.gettoStation().sendKeys(Input2);
		Thread.sleep(5000);
		trainstatus_or.gettoStation().sendKeys(Keys.ARROW_DOWN);
		trainstatus_or.gettoStation().sendKeys(Keys.ENTER);
		
		trainstatus_or.getSearchTrainsBtn().click();
		
		Thread.sleep(3000);
		
		Assert.assertFalse(driver.getTitle().contains("Trains: Tickets, Fare and Availability"));	
		List<WebElement> trainsList=driver.findElements(By.xpath("//div[@class='TrainInFo-block']"));
		for(WebElement ele:trainsList)
		{
			Reporter.log(ele.getText(),true);
		}
		
		
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	@DataProvider
	public String[][] getData() throws IOException
	{
	
		String xlPath="src\\test\\java\\com\\qa\\testdata\\TrainNumberList.xlsx";
		String xlSheet="Sheet1";
		int rowCount=ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet,rowCount);
		
	
		String[][] data=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlPath,xlSheet,i,j);
			}
		}	
		return data;		
	
	}
	
	
	
	@DataProvider
	public String[][] getData1() throws IOException
	{
	
		String xlPath="src\\test\\java\\com\\qa\\testdata\\TrainNumberList.xlsx";
		String xlSheet="Sheet2";
		int rowCount=ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet,rowCount);
		
	
		String[][] data=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlPath,xlSheet,i,j);
			}
		}	
		return data;		
	
	}
	
	@DataProvider
	public String[][] getData2() throws IOException
	{
	
		String xlPath="src\\test\\java\\com\\qa\\testdata\\TrainNumberList.xlsx";
		String xlSheet="Sheet3";
		int rowCount=ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet,rowCount);
		
	
		String[][] data=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlPath,xlSheet,i,j);
			}
		}	
		return data;		
	
	}
	
	@DataProvider
	public String[][] getData3() throws IOException
	{
	
		String xlPath="src\\test\\java\\com\\qa\\testdata\\TrainNumberList.xlsx";
		String xlSheet="Sheet4";
		int rowCount=ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet,rowCount);
		
	
		String[][] data=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlPath,xlSheet,i,j);
			}
		}	
		return data;		
	
	}

}