package com.imooc.lang;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.imooc.lang.UiAutomatorHelper;

public class SetLanguage extends UiAutomatorTestCase {
	
	
		public void testSetLanguage() throws UiObjectNotFoundException{
			SetEnglish();
			UiDevice device=UiDevice.getInstance();
			device.pressHome();
			SetChinese();
			
		}

		public void SetEnglish() throws UiObjectNotFoundException {
			UiObject app=new UiObject(new UiSelector().description("应用"));
			app.clickAndWaitForNewWindow();
			
			UiObject setting=new UiObject(new UiSelector().text("设置"));
			setting.clickAndWaitForNewWindow();
			
			UiScrollable scroll =new UiScrollable(new UiSelector().resourceId("com.android.settings:id/dashboard"));
			UiObject languageSet = scroll.getChildByText(new UiSelector().className("android.widget.TextView"), "语言和输入法", true);
			languageSet.clickAndWaitForNewWindow();
			
			UiObject lang = new UiObject(new UiSelector().text("语言"));
			lang.clickAndWaitForNewWindow();
			
			UiScrollable langList=new UiScrollable(new UiSelector().className("android.widget.ListView"));
			UiObject chinese=langList.getChildByText(new UiSelector().className("android.widget.TextView"), "English (United States)",true);
			chinese.click();
			
			UiCollection act_bar=new UiCollection(new UiSelector().resourceId("android:id/action_bar"));
			UiObject title = act_bar.getChildByInstance(new UiSelector().className("android.widget.TextView"), 0);
			if (title.getText().matches(".*angua.*")){
				System.out.println("英语语言设置成功！");
			}
		}
		
		
		public void SetChinese() throws UiObjectNotFoundException {
			UiObject app=new UiObject(new UiSelector().description("Apps"));
			app.clickAndWaitForNewWindow();
			
			UiObject setting=new UiObject(new UiSelector().text("Settings"));
			setting.clickAndWaitForNewWindow();
			
			UiScrollable scroll =new UiScrollable(new UiSelector().resourceId("com.android.settings:id/dashboard"));
			UiObject languageSet = scroll.getChildByText(new UiSelector().className("android.widget.TextView"), "Language & input", true);
			languageSet.clickAndWaitForNewWindow();
			
			UiObject lang = new UiObject(new UiSelector().text("Language"));
			lang.clickAndWaitForNewWindow();
			
			UiScrollable langList=new UiScrollable(new UiSelector().className("android.widget.ListView"));
			UiObject chinese=langList.getChildByText(new UiSelector().className("android.widget.TextView"), "中文 (简体)",true);
			chinese.click();
			
			UiCollection act_bar=new UiCollection(new UiSelector().resourceId("android:id/action_bar"));
			UiObject title = act_bar.getChildByInstance(new UiSelector().className("android.widget.TextView"), 0);
			if (title.getText().matches(".*输入法.*")){
				System.out.println("中文语言设置成功！");
			}
		}
		
		
		
		

		public static void main(String[] args) {
			String jarName="SetLanguage";
			String testClass="com.imooc.lang.SetLanguage";
			String testName="testSetLanguage";
			String androidId="3";
			new UiAutomatorHelper(jarName, testClass, testName, androidId);
		}
		
}
