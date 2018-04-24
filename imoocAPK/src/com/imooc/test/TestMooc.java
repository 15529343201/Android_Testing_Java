package com.imooc.test;

import com.robotium.solo.Solo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


//

@SuppressWarnings("rawtypes")
public class TestMooc extends ActivityInstrumentationTestCase2 {
	private Solo solo;
	private static final String MainActivity="cn.com.open.mooc.ui.loading.MCLoadingActivity";
	private static Class launchActivityClass;
	
	static{
		try{
			launchActivityClass=Class.forName(MainActivity);
		}
		catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public TestMooc() throws ClassNotFoundException{
		super(launchActivityClass);
	}
	
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		solo=new Solo(getInstrumentation(),getActivity());
	}
	
	@Override
	protected void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}
	

	public void clickEnter(){
		Activity act = solo.getCurrentActivity();
		int btnId=act.getResources().getIdentifier("go", "id", act.getPackageName());
		solo.waitForView(btnId);
		solo.clickOnButton("直接进入");
		assertTrue("Enter Fail", solo.waitForText("分类", 1, 3000));
	}
	
	public void clickSearch(){
		Activity act = solo.getCurrentActivity();
		int searchId=act.getResources().getIdentifier("search_course", "id", act.getPackageName());
		
		ImageView view =  (ImageView) solo.getView(searchId);		
		solo.clickOnView(view);
		assertTrue("search Fail", solo.waitForText("搜索课程", 1, 3000));
	}

	public void enterSearch(){
		Activity act = solo.getCurrentActivity();
		int txtId = act.getResources().getIdentifier("search_content", "id", act.getPackageName());
		EditText edit = (EditText) solo.getView(txtId);
		
		solo.enterText(edit, "软件测试基础");
		
		int searchId= act.getResources().getIdentifier("study_latest", "id", act.getPackageName());
		ImageView view =  (ImageView) solo.getView(searchId);		
		solo.clickOnView(view);
		
		int listId = act.getResources().getIdentifier("list_view", "id", act.getPackageName());
		ListView list=(ListView) solo.getView(listId);
		int cnt = list.getChildCount();
		if(cnt>0){
			solo.clickOnText("概念篇");
		}
		else{
			assertTrue("can't Find course",false);
		}
	}
	
	public void palyChapter(){
		TextView tv = (TextView) solo.getView("cn.com.open.mooc:id/section_name", 7);
		Log.d("imooc", "chapter name :"+tv.getText().toString());
		if(tv.getText().toString().matches("(.*)敏捷测试(.*)")){
			solo.clickOnView(tv);
			solo.sleep(3000);			
		}
		else{
			assertTrue("Not Click the Agile Test Chapter",false);
		}
	}
	
	public void testPlayAgile(){
		clickEnter();
		clickSearch();
		enterSearch();
		palyChapter();
	}
	
}
