package com.configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public static WebDriver driver;

	public static WebDriver browserInformation() {
		// Control the test from properties file and test can run on both browser Chrome or FireFox 
		String browserName = Config.getStringValue("browser");
	if(browserName.contains("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\driver\\executables\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		driver = new ChromeDriver();
	}
	
	else if(browserName.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\driver\\executables\\geckodriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new FirefoxDriver();
		
	}
	
	driver.manage().timeouts().implicitlyWait(Config.getIntValue("time"), TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
	

}
}
