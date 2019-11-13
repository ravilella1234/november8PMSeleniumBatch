package com.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties p;
	
	public static void init() throws Exception
	{
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//data.properties");
		 p=new Properties();
		 p.load(fis);
	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome")) 
		{
			ChromeOptions option=new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 12");
			
			//notifications
			option.addArguments("--disable-notifications");
			option.addArguments("--disable-infobars");
			option.addArguments("--start-maximized");
			
			
			//proxy servers  -- //chrome://version
			//option.addArguments("--proxy-server=http://192.168.90.84:1234");
			
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\jars\\chromedriver.exe" );
			driver=new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equals("firefox")) 
		{
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("novemberbatch");

			//handling notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			//proxy servers
			//profile.setPreference("network.proxy.type", 1);
			//profile.setPreference("network.proxy.socks", "192.168.90.54");
			//profile.setPreference("network.proxy.socks_port", 1744);
			
			
			//Setting firefox Profile
			FirefoxOptions option=new FirefoxOptions();
			option.setProfile(profile);
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\jars\\geckodriver.exe" );
			driver=new FirefoxDriver(option);
		}
		
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(p.getProperty(url));
		driver.navigate().to(p.getProperty(url));
	}

}
