package com.imooc.test;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppTest2 {
	AndroidDriver driver;

	@Before
	public void setUp() throws Exception {
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
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.startActivity("cn.com.open.mooc", ".user.login.MCLoginActivity");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("cn.com.open.mooc:id/Weibo_login_image").click();
		
		Set<String> contexts=driver.getContextHandles();
		for(String context : contexts){
			System.out.println("context:"+context);
			if(context.contains("WEBVIEW")){
				driver.context(context);				
			}
		}	
			Thread.sleep(5000);
			
			WebElement loginName=driver.findElementById("loginName");
			loginName.sendKeys("ÖÐÎÄ");
			WebElement loginPass=driver.findElementById("loginPassword");
			loginPass.sendKeys("pass");
		
			Thread.sleep(5000);
			
			
	}

}
