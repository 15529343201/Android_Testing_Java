package com.example.android.testingfun.test.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.robotium.solo.Solo;

public class TestAPK extends ActivityInstrumentationTestCase2 {

	private Solo solo;
	private static final String MainActivity="com.example.android.testingfun.lesson3.ClickFunActivity";
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
	public TestAPK() throws ClassNotFoundException{
		super(launchActivityClass);
	}
	
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		solo=new Solo(getInstrumentation(),getActivity());
	}
	
	public void testButton(){
		Activity act = solo.getCurrentActivity();
		int btnId=act.getResources().getIdentifier("launch_next_activity_button","id",act.getPackageName());
		solo.waitForView(btnId);
		solo.clickOnButton("hello world");
		
		int txtId=act.getResources().getIdentifier("info_text_view","id",act.getPackageName());
		TextView outMsg = (TextView)solo.getView(txtId);
		assertEquals("imooc Android Automation Testing",outMsg.getText().toString());
		
	}
	
	@Override
	protected void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}
	
}
