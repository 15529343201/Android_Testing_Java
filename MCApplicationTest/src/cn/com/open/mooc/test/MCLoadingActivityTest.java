package cn.com.open.mooc.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class MCLoadingActivityTest extends ActivityInstrumentationTestCase2 {
  	private Solo solo;
  	
  	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "cn.com.open.mooc.ui.loading.MCLoadingActivity";

    private static Class<?> launcherActivityClass;
    static{
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }
  	
  	@SuppressWarnings("unchecked")
    public MCLoadingActivityTest() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
		// Wait for activity: 'cn.com.open.mooc.ui.loading.MCLoadingActivity'
		solo.waitForActivity("MCLoadingActivity", 2000);
		// Wait for activity: 'cn.com.open.mooc.ui.classify.MCLoginGuideActivity'
		assertTrue("MCLoginGuideActivity is not found!", solo.waitForActivity("MCLoginGuideActivity"));
		// Set default small timeout to 16590 milliseconds
		Timeout.setSmallTimeout(16590);
		// Click on 直接进入
		solo.clickOnView(solo.getView("go"));
		// Wait for activity: 'cn.com.open.mooc.ui.index.MCMainActivity'
		assertTrue("MCMainActivity is not found!", solo.waitForActivity("MCMainActivity"));
		// Click on ImageView
		solo.clickOnView(solo.getView("search_course"));
		// Click on 软件测试基础-概念篇
		solo.clickOnView(solo.getView(android.widget.TextView.class, 139));
		// Enter the text: '软件测试基础-概念篇'
		solo.clearEditText((android.widget.EditText) solo.getView("search_content"));
		solo.enterText((android.widget.EditText) solo.getView("search_content"), "软件测试基础");
		// Click on 软件测试基础-概念篇 17481 4小时
		solo.clickOnText("概念篇");
		// Wait for activity: 'cn.com.open.mooc.ui.showmooc.ShowMoocActivity'
		assertTrue("ShowMoocActivity is not found!", solo.waitForActivity("ShowMoocActivity"));
		// Click on   33:24 已下载 2-4 软件测试模式-敏捷测试 LinearLayout
		solo.clickInList(7, 0);
		// Press menu back key
		solo.goBack();
	}
}
