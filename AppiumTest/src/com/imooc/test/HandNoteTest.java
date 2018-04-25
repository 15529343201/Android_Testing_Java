package com.imooc.test;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HandNoteTest {
	AndroidDriver driver;
	
	@Before
	public void setUp() throws Exception {
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("deviceName","192.168.117.101:5555");
		cap.setCapability("platformVersion", "7.0");
	
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
	public void testHandNote() throws InterruptedException {
		//enterGuide();
		driver.startActivity("cn.com.open.mooc", ".index.MCMainActivity");
		Thread.sleep(2000);
		driver.findElementById("cn.com.open.mooc:id/iv_handnote_icon").click();
		Thread.sleep(5000);
		driver.findElementByAccessibilityId("最新").click();
		
		List<WebElement> noteList=driver.findElementsByClassName("android.view.View");
		WebElement latestNote = noteList.get(4);
		
		String noteTitle = latestNote.getAttribute("name");
		System.out.println("Latest note's title is :"+noteTitle);
		latestNote.click();
		Thread.sleep(5000);
		List<WebElement> noteDetail=driver.findElementsByClassName("android.webkit.WebView");
		WebElement note=noteDetail.get(1);
		String title=note.getAttribute("name");
		
		Assert.assertEquals(title, noteTitle);
		
		
		driver.findElementById("cn.com.open.mooc:id/left_icon").click();
		Thread.sleep(2000);
		driver.findElementById("cn.com.open.mooc:id/left_icon").click();
		
		
	}

	public void enterGuide() throws InterruptedException{
		Thread.sleep(1000);
		int width=driver.manage().window().getSize().width;
		int height=driver.manage().window().getSize().height;
		
		driver.swipe(width*3/4, height/2, width/4, height/2, 200);		
		Thread.sleep(1000);
		driver.swipe(width*3/4, height/2, width/4, height/2, 200);
		Thread.sleep(1000);
		//driver.findElementByAndroidUIAutomator("new UiSelector().text(\"马上开始\")").click();
		driver.findElementByClassName("android.widget.ImageView").click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("cn.com.open.mooc:id/icon_close").click();
		Thread.sleep(4000);
		
	}
	
}
