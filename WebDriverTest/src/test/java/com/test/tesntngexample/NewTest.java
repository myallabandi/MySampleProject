package com.test.tesntngexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class NewTest {
	private WebDriver driver=null;
  @Test(priority=1)
  public void verifyPageTitleTest() {
	  String expectedTitle="ONLINE STORE | Toolsqa Dummy Test site";	  
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test(priority=2)
  public void nativationTest(){
	 // driver.navigate().to("http://www.store.demoqa.com");
	  driver.findElement(By.xpath(".//*[text()='My Account']")).click();
	  //driver.navigate().back();
	  //driver.navigate().forward(); 
	  //driver.navigate().back();
	  //driver.navigate().refresh();
  }
  
  @BeforeMethod
  public void launchBrowser(){
	  driver=new ChromeDriver();
	  driver.get("http://store.demoqa.com/");
	  //driver.manage().window().maximize();
	//  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
  }
  
  @BeforeSuite
  public void initialSetup() {
	  System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
  }

  @AfterMethod
  public void tearDown() {
	  driver.close();
  }
  
  @AfterSuite
  public void finalTearDown(){
	  driver.quit();
  }

}
