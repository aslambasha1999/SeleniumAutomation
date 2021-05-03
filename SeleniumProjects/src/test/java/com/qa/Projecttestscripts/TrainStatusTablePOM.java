package com.qa.Projecttestscripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainStatusTablePOM {

	WebDriver driver;
	
	@FindBy(xpath="//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]")
	WebElement TrainInfoTab;
	
	public WebElement getTrainInfoTab()
	{
		return TrainInfoTab;
	}
	
	@FindBy(xpath="//body/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[1]/ul[1]/li[1]/a[1]")
	WebElement LiveTrainStatusLink;
	
	public WebElement getLiveTrainStatusLink()
	{
		return LiveTrainStatusLink;
	}
	
	@FindBy(xpath="//input[@name='train_number']")
	WebElement EnterTrainNo;
	
	public WebElement getEnterTrainNo()
	{
		return EnterTrainNo;
	}
	
	@FindBy(partialLinkText="Train between Statio")
	WebElement TrainsBtwStations;
	
	public WebElement getTrainsBtwStations()
	{
		return TrainsBtwStations;
	}
	
	@FindBy(xpath="//input[@id='form-stn']")
	WebElement fromStation;
	
	public WebElement getfromStation()
	{
		return fromStation;
	}
	
	@FindBy(xpath="//input[@id='to-stn']")
	WebElement toStation;
	
	public WebElement gettoStation()
	{
		return toStation;
	}
	
	@FindBy(xpath="//input[@value='Search Trains']")
	WebElement SearchTrainsBtn;
	
	public WebElement getSearchTrainsBtn()
	{
		return SearchTrainsBtn;
	}
	
	@FindBy(xpath="//div[@class='TrainInFo-block']")
	List<WebElement> ListofTrains;
	
	public List<WebElement> getListofTrains()
	{
		return ListofTrains;
	}
	
	
	
	
	@FindBy(tagName="tr")
	int rowCount;
	
	public int getrowCount()
	{
		return rowCount;
	}
	
	@FindBy(tagName="//thread//th")
	int colCount;
	
	
	public int getcolCount()
	{
		return colCount;
	}
	

	public TrainStatusTablePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
}
