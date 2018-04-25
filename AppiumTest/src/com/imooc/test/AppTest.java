package com.imooc.test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppTest {

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver driver;
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("deviceName","192.168.117.101:5555");
		cap.setCapability("platformVersion", "7.0");
//		cap.setCapability("appPackage", "com.android.calculator2");
//		cap.setCapability("appActivity", ".Calculator");
		
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", "c:\\dan\\mukewang.apk");
		
		cap.setCapability("appPackage", "cn.com.open.mooc");
		cap.setCapability("appActivity", "cn.com.open.mooc.index.splash.MCSplashActivity");
		cap.setCapability("devicereadyTimeout", 30);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Thread.sleep(5000);
		driver.quit();

	}

}
