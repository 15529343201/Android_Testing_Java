package com.example.android.testingfun.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;
import com.example.android.testingfun.R;
import com.example.android.testingfun.lesson3.ClickFunActivity;
import com.robotium.solo.Solo;


public class TestMain extends ActivityInstrumentationTestCase2<ClickFunActivity> {
	
	private Solo solo;
	public TestMain(){
		super(ClickFunActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		solo=new Solo(getInstrumentation(),getActivity());
	}
	
	public void testButton(){
		solo.waitForView(R.id.launch_next_activity_button);
		solo.clickOnButton("hello world");
		TextView outMsg = (TextView)solo.getView(R.id.info_text_view);
		assertEquals("imooc Android Automation Testing",outMsg.getText().toString());
		
	}
	
	@Override
	protected void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}

}
