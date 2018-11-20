package HttpAuthentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingHttpAuthentication {
	WebDriver driver=null;
	
	@BeforeMethod
	public void launchApplication(){
		//System.setProperty("webdriver.ie.driver", ".//IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		DesiredCapabilities capability=DesiredCapabilities.internetExplorer();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver=new InternetExplorerDriver(capability);
		driver.get("https://cas-ca.rim.net");
		
	}
	
	@Test
	public void ExampleTest(){
		System.out.println("Page Title: "+driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
