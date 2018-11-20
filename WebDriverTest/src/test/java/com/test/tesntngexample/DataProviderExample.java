package com.test.tesntngexample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	WebDriver driver=null;
	ExcelUtility excelData=null;
	List<Object> dataList=null;
	FormWebElements elements=null; 
	
	@Test(dataProvider="getDataFromExcel")
	public void fillDataFormTest(UserDataObject dataObj) throws MalformedURLException{
		System.out.println("Test Execution started");
		//UserDataObject dataObj=(UserDataObject)Obj;
		System.out.println("Data from Test "+dataObj.getFirstName());
		elements=new FormWebElements();
		elements.getFistNameElement(driver).clear();
		elements.getFistNameElement(driver).sendKeys(dataObj.getFirstName());
		URL url=new URL("");
		
	}
	
	@DataProvider(name="getDataFromExcel")
	public Iterator<Object> getData(){
		/*Object dataArray[][]=new Object[dataList.size()][0];
		for(int i=0;i<dataList.size();i++){
			dataArray[i][0]=dataList.get(i);
		}*/
		excelData=new ExcelUtility();
		dataList=excelData.getTestDataFromExcel();
		System.out.println("Data Array returned: "+dataList);
		//UserDataObject obj=(UserDataObject)dataList.get(0);
		//System.out.println("FirstName: "+ obj.getFirstName());
		return dataList.iterator();
	}

	
	@BeforeTest
	public void testSetUp(){
		//System.out.println("FirstName: "+dataList.get(0).getFirstName());
		System.setProperty("Webdriver.chrome.driver",".//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-form/");
	}
	
	public void tearDown(){
		driver.close();
		driver.quit();
	}
}
