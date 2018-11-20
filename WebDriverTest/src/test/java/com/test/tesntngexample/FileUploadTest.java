package com.test.tesntngexample;

import org.testng.annotations.Test;

import com.google.common.base.Function;

import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class FileUploadTest {
	
	private WebDriver driver=null;
  @SuppressWarnings("unchecked")
  @Test(enabled=false)
  public void fileUpload() {
	  Reporter.log("File upload test Started");
	  driver.get("http://demo.guru99.com/test/upload/");
	  System.out.println(driver.getTitle());
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  WebElement uploadButton=null;
	  @SuppressWarnings({ "rawtypes" })
	Wait wait=new FluentWait(driver)
			  .withTimeout(30, TimeUnit.SECONDS)
			  .pollingEvery(5, TimeUnit.SECONDS)
			  .ignoring(NoSuchElementException.class);
	  uploadButton= (WebElement) wait.until(new Function<WebDriver, WebElement>(){
		  public WebElement apply(WebDriver driver){
			 return driver.findElement(By.id("uploadfile_0"));
		  }
	  });
	  uploadButton.sendKeys("C:\\Users\\myallabandi\\Documents\\load_failure.txt");
	  WebElement termsCheckbox=driver.findElement(By.id("terms"));
	  if(!termsCheckbox.isSelected()){
		  termsCheckbox.click();
	  }
	  try{
		  Thread.sleep(5000);
	  }catch(InterruptedException e){
		  e.printStackTrace();
	  }
	  Reporter.log("File upload test completed");
  }
  
  @Test(enabled=true)
  public void actionDemo(){
	  System.out.println("Action demo started "+driver);
	  driver.get("http://demo.guru99.com/v1/");
	  driver.manage().window().maximize();
	  Reporter.log("Action demo application launched");
	 WebElement element= driver.findElement(By.xpath("//li[@class='dropdown']//a[@href='#']"));
	  System.out.println("Class Name before click:"+driver.findElement(By.xpath("//li[@class='dropdown']")).getAttribute("class"));
	  element.click();
	  System.out.println("Class Name After click:"+driver.findElement(By.xpath("//li[@class='dropdown']")).getAttribute("class"));
	  driver.findElement(By.linkText("Table Demo")).click();
	  Reporter.log("Table Demo application was launched");
	 JavascriptExecutor exe= (JavascriptExecutor)driver;
	 Reporter.log("Action Demo Test ended");
	 //exe.executeScript(arg0, arg1);
	 
  }
  
  @Test(dataProvider="TestData", enabled=false)
  public void dataProviderTest(){
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	   String browser="firefox";
	   System.out.println("Before Test started");
	  if(browser.equalsIgnoreCase("firefox")){
	  this.firefoxBrowser();
	  }else if(browser.equalsIgnoreCase("chrome")){
		  this.chromeBrowser();
	  }
  }

  @AfterMethod
  public void closeBrowserWindow() {
	  driver.close();
  }

  
  public void chromeBrowser(){
	  System.out.println("Chrome driver called");
	  Reporter.log("Chrome driver is called");
	  System.setProperty("Webdriver.chrome.driver",".//chromedriver.exe");
	  driver=new ChromeDriver();
  }
  
  public void firefoxBrowser(){
	  Reporter.log("Firefox driver is called");
	  System.setProperty("Webdriver.firefox.marionette",".//geckodriver.exe");
	  driver=new FirefoxDriver();
  }
}
