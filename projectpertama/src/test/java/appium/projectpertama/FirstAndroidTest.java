package appium.projectpertama;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.http.HttpClient.Factory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;  
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstAndroidTest {

	AppiumDriver driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities ();
		caps.setCapability("platformName", "Android");
		caps.setCapability ("automationName", "UiAutomator2");
		caps.setCapability("platformVersion","11.0");
		caps.setCapability("deviceName","Android emulator");
		caps.setCapability("app",(System.getProperty("user.dir")+"/apps/projectpertama/apps/ApiDemos.apk"));
			
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
	}
		
	@Test
	public void click_App_Button() {
		driver.findElementByAccessibilityId("App").click();
	}
		
	@AfterTest
	public void tearDown() {
		if (null != driver) {
            driver.quit();
        }
	}
}
