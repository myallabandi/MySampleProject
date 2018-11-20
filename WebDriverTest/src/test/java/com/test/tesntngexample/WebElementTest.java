package com.test.tesntngexample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class WebElementTest {
	WebDriver driver=null;
	
	private void selectRadioButton(List<WebElement> listOfElements,String expectedVale){
		 for(WebElement ele:listOfElements){
			  if(ele.getAttribute("value").toString().trim().equalsIgnoreCase(expectedVale)){
				  ele.click();
			  }
		  }
	}
	
  @Test
  public void enterData() {
	  String firstName="Manikanta";
	  String lastName="Yallabandi";
	  String gender="Male";
	  String experience="4";
	  driver.findElement(By.xpath(".//input[@name='firstname']")).sendKeys(firstName);
	  driver.findElement(By.xpath(".//input[@name='lastname']")).sendKeys(lastName);
	  List<WebElement> genderElementsList=driver.findElements(By.name("sex"));
	  this.selectRadioButton(genderElementsList, gender);
	  List<WebElement> expElementList=driver.findElements(By.name("exp"));
	  this.selectRadioButton(expElementList, experience);
	 // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  try{
		  Thread.sleep(1000);
	  }catch(InterruptedException e){
		  e.printStackTrace();
	  }
  }
  
  @BeforeMethod
  public void launchBrowser() {
	  DesiredCapabilities cab=DesiredCapabilities.chrome();
	  cab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	  driver=new ChromeDriver(cab);
	  driver.get("http://toolsqa.com/automation-practice-form/");
	  driver.manage().window().maximize();
	 // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
  }

  @AfterMethod
  public void tearDown() {
	  driver.close();
  }

}
