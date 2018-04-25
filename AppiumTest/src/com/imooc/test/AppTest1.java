package com.imooc.test;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppTest1 {
	AndroidDriver driver;
	
	@Before
	public void setUp() throws Exception {
DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("deviceName","192.168.117.101:5555");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", ".Calculator");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("platformName", "Android");
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.id("digit_6")).click();
		List<WebElement> btnList=driver.findElementsByClassName("android.widget.Button");
		WebElement btn7=btnList.get(0);
		btn7.click();
		driver.findElementById("com.android.calculator2:id/op_mul").click();
		
//		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.Button[contains(@text,'5')]").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"2\")").click();
		driver.findElementByAccessibilityId("equals").click();

				
		Thread.sleep(2000);
		
	}

}
