package Utility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage
{
	public static WebDriver driver;

	public void OpenBrowser(String browserName) throws InterruptedException {
		if (browserName.equals("Chrome")) {
			//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
			String ss = "C:\\Users\\MOKSHAGNA\\Desktop\\Automation\\src\\main\\resources\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", ss);
			driver = new ChromeDriver();
			driver.get(getProperty("browser.baseURL"));
			driver.manage().window().maximize();
			Thread.sleep(5000);


		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "accept");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("requireWindowFocus", true);//to move mouse manually			
			driver = new InternetExplorerDriver();
			driver.get(getProperty("browser.baseUR"));
			driver.manage().window().maximize();


		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(getProperty("browser.baseUR"));
			driver.manage().window().maximize();


		}

	}


	public static String getProperty(String key) {
		String strPropValue ="";
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("resources/browser-config.properties"));
			properties.load(new FileInputStream("resources/testdata-config.properties"));
			strPropValue = properties.getProperty(key);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return strPropValue;
	}



}
