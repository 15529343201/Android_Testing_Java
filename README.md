# chapter1
### Android自动化测试的相关技术工具和框架
- 自动化测试环境的部署
- Monkey工具
- MonkeyRunner工具
- Android单元测试
- Robotium
- UiAutomator
- Appium框架

### 自动化测试脚本的编写和阅读调试
- Android自动化测试环境部署及重要工具详解
- Monkey测试详解及深度解析
- MonkeyRunner框架详解及进阶
- Android单元测试框架和Robotium框架详解与实战
- UiAutomator自动化测试框架深度解析与实战
- Appium自动化测试框架详解与实战

#### Android自动化测试环境部署
- 最基本
- 常常被忽略

#### Android SDK中的各种重要工具
- Monkey测试工具(Monkey script|Monkey Server)

#### MonkeyRunner自动化测试框架
- MonkeyRunner录制回放工具
- easyMonkeyDevice模块

#### Android单元测试体系及其核心框架
- Instrumentation
- UiAutomator  系统设置的实战用例

#### 实战进阶(Robotium|Appium)
- 黑盒自动化测试
- 白盒自动化测试
- 应用界面元素定位
- Hybrid应用自动化测试
- 快速的生成测试用例

# chapter2
### Android自动化测试
- 操作系统:Windows,Linux,Mac
- 系统版本:Windows XP以上
- 内存大小:不低于4G
- 测试手机:任意Android系统手机
### 自动化测试环境
- 开发工具包(JDK,Android SDK)
- 开发环境(eclipse,ADT,Ant)
- 运行环境(Device,AVD)

### 资源获取及安装
- Java的安装:http://www.oracle.com/technetwork/java/javase/downloads/index.html
- Ant:http://ant.apache.org/bindownload.cgi 配置环境变量
- Eclipse ADT Bundle:http://wear.techbrood.com/sdk/index.html
- Android SDK更新镜像:腾讯镜像地址:android-mirror.bugly.qq.com 端口:8080  东软镜像地址:mirrors.neusoft.edu.cn 端口:80

### ADB工具
- ADB-Android Debug Bridge。电脑和android设备之间的连接、调试通道。

![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter2/Image/1.PNG)<br>
### ADB常用命令
- `adb devices`
- `adb push/pull`
- `adb forward`
- `adb start-server/kill-server`
- `adb install/uninstall`
- `adb shell`

![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter2/Image/2.PNG)<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter2/Image/3.PNG)<br>
- `adb forward tcp:1080 tcp:1080` 把电脑端的1080端口转发到设备端的1080端口
- `adb kill-server` `adb start-server`
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter2/Image/4.PNG)<br>
```
C:\Users\Administrator>adb shell
# 列出模拟器上所有的包
root@vbox86p:/ # pm list packages
root@vbox86p:/ # cd /data/data/
root@vbox86p:/data/data # ls
C:\Users\Administrator>adb uninstall cn.com.open.mooc
```

### Android命令
- Android命令可以用于查看当前android开发环境中相关的系统信息以及操作
- Android sdk
- Android avd
- Android list
- Android create project

查看帮助:`android -h`<br>
打开SDK Manager:`android sdk`<br>
打开AVD Manager:`android avd`<br>
列出模拟器清单:`android list avd`<br>
列出当前模拟器平台版本:`android list target`<br>
新建avdtest模拟器,平台版本id为2,sd卡100M:`android create avd -n avdtest -t 2 -c 100M`<br>
删除创建的模拟器:`android delete avd -n avdtest`<br>
创建应用项目:`android create project -n myandroid -p c:\myandroid -k com.mooc.myandroid -a MyandroidActivity -t 2`<br>
创建测试项目:`android create test-project -m c:\myandroid -p c:\myandroid\test -n myandroidtest`<br>
### Monitor工具
- Monitor工具:集成了在Android开发、自动化测试过程中对应用调测非常重要的常用功能。
- Devices
- DDMS
- Logcat
- uiautomatorViewer

启动Android Device Monitor:`monitor`<br>

# chapter3
### Monkey工具
- Monkey:是Android系统中自带的一个黑盒测试工具,一般通过随机触发界面事件,来确定应用是否会发生异常,多用于android应用的稳定性、压力测试。
- adb shell monkey [options] <event-count>
- 官方文档:https://developer.android.com/studio/test/monkey.html

`adb shell monkey --help`<br>
```
C:\Users\Administrator>adb shell
root@vbox86p:/ # cd /data/data
root@vbox86p:/data/data # ls
root@vbox86p:/data/data # exit
C:\Users\Administrator>adb shell monkey -p com.android.calculator2 1000
C:\Users\Administrator>adb shell monkey -p com.android.calculator2 -v -v 100
adb shell monkey -p com.baidu.searchbox -s 1471938271846 -v -v 1000
```
### Monkey脚本
- `adb shell monkey -f <script> 1`
- 参考源码:https://android.googlesource.com/platform/development/+/master/cmds/monkey/src/com/android/commands/monkey/MonkeySourceScript.java

### Monkey脚本 主要命令
- `DispatchPointer`
- `DispatchPress [keycode]`
- `LaunchActivity`
- `UserWait`
- `RotateScreen`
- `Tap`

MonkeySourceScript.java<br>
```
# Start of Script  
type= user  
count= 1  
speed= 1.0  
start data >>
LaunchActivity(com.android.calculator2, com.android.calculator2.Calculator)

# touch 9
DispatchPointer(0,0,0,400,500,0,0,0,0,0,0,0)
DispatchPointer(0,0,1,400,500,0,0,0,0,0,0,0)
UserWait(1500)
# touch 6
DispatchPress(KEYCODE_6)
UserWait(1500)
# touch +
DispatchPress(KEYCODE_PLUS)
UserWait(1500)
# touch 7
Tap(100,500,50)
UserWait(1500)
# touch =
DispatchPress(KEYCODE_EQUALS)
UserWait(1500)

RotateScreen(2,1)
UserWait(500)
```
`C:\Users\Administrator\git\Android_Testing_Java>adb push monkey.script /data/temp/monkey.script`<br>
`C:\Users\Administrator\git\Android_Testing_Java>adb shell monkey -f /data/temp/monkey.script 1`<br>
### Monkey Server
- 启动Monkey Server:`adb shell monkey --port 1080 &`
- 连接Monkey Server:`adb forward tcp:1080 tcp:1080` `telent 127.0.0.1 1080`

### Monkey Server-主要命令
- `touch [down|up|move][x][y]`
- `press [keycode]`
- `sleep`
- `getvar`
- `type`

README_NETWORK.txt<br>
### Monkey Server命令的脚本化
- 关键脚本:`set sh=WScript.CreateObject("WScript.Shell")` `WScript.Sleep 1000` `sh.SendKeys "open 127.0.0.1 1080{ENTER}"`
- 启动命令:`cscript //nologo monkeyServerRun.vbs`

monkeyServerRun.vbs<br>
monkeyServer.bat<br>
# chapter4
### MonkeyRunner
- MonkeyRunner:Android SDK中自带的一个黑盒测试工具,在PC端通过Android API控制设备的运行,支持Python脚本,可以实现Monkey无法实现的一些逻辑控制

### MonkeyRunner API
- MonkeyRunner
- MonkeyDevice
- MonkeyImage
- 官方文档:https://developer.android.com/studio/test/monkeyrunner/index.html

启动MonkeyRunner:<br>
```
>>> from com.android.monkeyrunner import MonkeyRunner,MonkeyDevice,MonkeyImage
>>> MonkeyRunner.help("text")
>>> content=MonkeyRunner.help("html")
>>> f=open("helo.html","w")
>>> f.write(content)
>>> f.close()
>>> MonkeyRunner.alert('MonkeyRunner alert','imooc','OK')
>>> MonkeyRunner.choice('MonkeyRunner choice',['test1','test2'],'imooc')
>>> MonkeyRunner.input('MonkeyRunner input','init str','imooc','OK','Cancel')
>>> MonkeyRunner.sleep(4)
>>> MonkeyRunner.waitForConnection()
```
### MonkeyRunner模块
- alert
- waitForConnection
- sleep
- help

### MonkeyDevice模块
- installpackage
- startActivity
- press
- touch
- takesnapshot
- getProperty

http://www.android-doc.com/tools/help/MonkeyImage.html<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/5.PNG)<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/6.PNG)<br>
### MonkeyImage模块
- ConvertoBytes
- getSubImage
- sameAs
- writeToFile

MonkeyImage博客:https://blog.csdn.net/QingLang0213/article/details/48317453<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/7.PNG)<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/8.PNG)<br>
### MonkeyRunner录制回放工具
- Monkey_recorder
- Monkey_playback

![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/9.PNG)<br>
`monkey_record.py` `monkey_playback.py` `recorder.mr`<br>
### MonkeyRunner进阶
- EasyMonkeyDevice
- By

`By.java` `EasyMonkeyDevice.java` `README`<br>
启动view server<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/10.PNG)<br>
启动hierarchyviewer:D:\android-sdk\tools<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/11.PNG)<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/12.PNG)<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/13.PNG)<br>
### MonkeyRunner实战
- Case1:使用press、touch方法分别触发计算器按键,并用MonkeyImage来比较两次计算结果是否一致
- Case2:用EasyMonkeyDevice来获取按键并触发,再用HierarchyViewer获取对象属性校验结果正确性

`calculator_mr.py`<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/14.PNG)<br>
### 思考题
- Question1:MonkeyRunner用例实现脚本中,有一处明显的错误,请看看那个地方实现得有问题?
- Question2:Case1使用subImage对象来进行图像对比时,需要依据坐标范围来指定比较区域,如何不依赖坐标实现图像对比?

### 思考题解答
- `calculator_mr1.py`

![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/15.PNG)<br>
# chapter5
### Android单元测试类
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/16.PNG)<br>
### Instrumentation框架
- 官方解释:Base class for implementing application instrumentation code.When running with instrumentation turned on,this class will be instantiated for you `before any of the application code`,allowing you to `monitor all of the interaction` the system has with the application.An Instrumentation implementation is described to the system `through an AndroidManifest.xml's tag`.

![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/17.PNG)<br>
Eclipse中搭建Android开发环境 https://www.cnblogs.com/694579350liuq/p/7444666.html<br>
Eclipse中离线安装ADT插件详细教程及下载链接 https://blog.csdn.net/menghuanbeike/article/details/69945871<br>
在Eclipse上创建Android模拟器 https://blog.csdn.net/u010670619/article/details/47110965<br>
创建android模拟器 https://www.cnblogs.com/csulennon/p/4178404.html<br>
Eclipse的 Run as 不出现Android Application的问题 http://blog.sina.com.cn/s/blog_77bf45a90101eol6.html<br>

配置好环境运行`MyFirstTestActivity工程`<br>
创建一个测试的工程ClickFunTest:`New-->Android Test Project-->ClickFunTest`然后可以在eclipse中运行<br>
命令行测试运行:<br>
1.进入到待测试工程的目录<br>
2.`android create test-project -m .. -p tests`<br>
3.`adb shell am instrument -e class com.example.android.testingfun.lesson3.ClickFunActivityTest -w com.example.android.testingfun.tests/android.test.InstrumentationTestRunner`<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/18.PNG)<br>

### Robotium介绍
- http://www.robotium.org
- https://github.com/RobotiumTech/robotium

### Robotium白盒测试
- 基于Instrumentation
- robotium-solo-5.6.1.jar

创建一个测试的工程ClickFunWhite:Build Path引入robotium-solo-5.6.1.jar<br>
命令行测试:<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/19.PNG)<br>
### Robotium黑盒测试
- 应用重签名 `Re-sign.jar` http://www.troido.de/re-sign.jar

直接点击:Re-sign,拖动MyFirstTestActivity.apk到其中,生成MyFirstTestActivity_debug.apk<br>
新版本sdk中,如果报错,把build-tool中的zipalign.exe放入到tools中<br>
- 命令行重签名

解压MyFirstTestActivity.apk删除其中的META-INF<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/20.PNG)<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/21.PNG)<br>
`jarsigner -keystore debug.keystore -storepass android -keypass android -sigalg MD5 withRSA -digestalg SHA1 APIFile androiddebugkey`<br>
创建一个测试的工程ClickFunBlack,选择This project,引入Junit和robotium jar包<br>
拷贝build-tools下的aapt到tools下<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/22.PNG)<br>
### Robotium主要API
http://recorder.robotium.com/javadoc/<br>
- 点击类操作

1.`clickOnText(String text)`<br>
2.`clickOnButton(String text)`<br>
3.`clickOnView(View view)`<br>
4.`clickOnScreen(float x,float y)`<br>
- 输出类操作

1.`enterText(EditText editText,String text)`<br>
2.`ClearText(EditText editText)`<br>
- Get相关操作

1.`getCurrentActivity()`<br>
2.`getText(int index)`<br>
3.`getButton(int index)`<br>
4.`getview(String id)`<br>
- Search相关操作

1.`searchButton`<br>
2.`searchText`<br>
3.`searchEditText`<br>
- 判断相关操作

1.`assertCurrentActivity`<br>
2.`assertMemoryNotLow`<br>
3.`isCheckBoxChecked`<br>
4.`isTextChecked`<br>

### Robotium自动化实例
1.启动慕课网应用<br>
2.进入主界面<br>
3.搜索并打开课程<br>
4.选择指定章节<br>

下载慕课网app(https://www.imooc.com/mobile/app),mukewang.apk,解压删除其中的META-INF,使用命令行重签名<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/23.PNG)<br>
创建一个测试的工程imoocAPK<br>
获取签名信息:`aapt d badging c:\Dan\code\mukewang1.apk`<br>
### Robotium录制回放工具
- Robotium Recorder:http://recorder.robotium.com/updates

![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/24.PNG)<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/25.PNG)<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter5/Image/26.PNG)<br>
会生成mukewang_debug.apk<br>
点击录制,最终会生成工程MCApplicationTest<br>
# chapter6
### UiAutomator简介
- 随AndroidV4.1推出,官方推荐用于V4.3版本以上
- 用于应用UI自动化测试,模拟操作
- 优点

1.API丰富,简单易懂<br>
2.无Activity限制,支持跨应用<br>
3.几乎所有的工人操作都能进行模拟<br>
- 缺点

1.权限较低,无法像Instrumentation一样获取应用的较高权限<br>
2.有很多Android API不能使用<br>
### 建立UiAutomator测试工程
- 新建Java工程
- 依赖包android.jar、uiautomator.jar
- 继承UiAutomatorTestCase

### 执行UiAutomator测试
- 生成编译文件:`android create uitest-project`
- 编译执行包:`ant build`
- 上传执行包:`adb push`
- 执行测试:`adb shell uiautomator runtest`

创建一个Java工程:`TestUi`<br>
```Java
public class TestUi extends UiAutomatorTestCase {

	public void testHome() {
		UiDevice.getInstance().pressHome();
	}
}
```
查看平台对应版本的id:`android list target`<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter6/Image/27.PNG)<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter6/Image/28.PNG)<br>
### UiAutomator脚本调试工具
- UiAutomatorHelper:https://github.com/fan2597/UiAutomatorHelper

下载UiAutomatorDebug源码,导入到eclipse,拷贝UiAutomatorHelper.java到TestUi工程下.<br>
```Java
public static void main(String[] args) {		
	String jarName="FirstUi";
	String testClass="com.imooc.UiTest.TestUi";
	String testName="testScrollable";
	String androidId="3";
	new UiAutomatorHelper(jarName, testClass, testName, androidId);
}
```
`Run AS`-->`Java Application`<br>
### UiAutomator APIs
- UiDevice
- UiSelecter
- UiObject
- UiCollection
- UiScrollable

```Java
//		device.pressHome();
//		device.waitForIdle(2000);
//		device.pressMenu();
//		device.waitForIdle(2000);
//		device.pressRecentApps();
//		
//		device.pressKeyCode(KeyEvent.KEYCODE_I);
//		device.pressKeyCode(KeyEvent.KEYCODE_M);
//		device.pressKeyCode(KeyEvent.KEYCODE_O);
//		device.pressKeyCode(KeyEvent.KEYCODE_O);
//		device.pressKeyCode(KeyEvent.KEYCODE_C);
//		
//		device.takeScreenshot(new File("/sdcard/a.png"));
```
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter6/Image/29.PNG)<br>
```Java
//		device.click(700, 2200);
//		
//		if(device.isScreenOn()){
//			device.sleep();
//		}
//		device.waitForIdle(2000);
//		if(!device.isScreenOn()){
//			device.wakeUp();
//		}
//		
//		device.drag(900, 2200, 700, 1000, 50);		
//		device.waitForIdle(5000);
//		device.drag(700, 1000, 900, 2200, 50);
//		
//		device.swipe(1200, 1500, 200, 1500, 20);
//		device.waitForIdle(5000);
//		device.swipe(200, 1500, 1200, 1500, 20);
//		
//		device.openNotification();
		device.openQuickSettings();
```
- UiSelector

1.`Text`<br>
2.`description`<br>
3.`class`<br>
4.`package`<br>
5.`index`<br>
6.`其他属性`<br>
```Java
public void testSelect() throws UiObjectNotFoundException{
	UiSelector s=new UiSelector().className("android.view.ViewGroup").index(1).childSelector(new UiSelector().index(3));
	UiObject browserBtn = new UiObject(s);
	browserBtn.click();
}
```
- UiObject

1.`click`<br>
2.`drag`<br>
3.`swipe`<br>
4.`setText`<br>
5.`属性获取`<br>
6.`是否存在`<br>
```Java
public void testObject() throws UiObjectNotFoundException{
	UiObject obj=new UiObject(new UiSelector().resourceId("com.android.dialer:id/emptyListViewImage"));
	obj.swipeLeft(20);
	UiObject obj2 = new UiObject(new UiSelector().resourceId("com.android.dialer:id/emptyListViewImage"));
	if(obj2.exists()){
		obj2.swipeRight(20);
	}
		
	UiObject obj3=new UiObject(new UiSelector().resourceId("com.android.dialer:id/search_box_start_search"));
	obj3.clickAndWaitForNewWindow();
	new UiObject(new UiSelector().resourceId("com.android.dialer:id/search_view")).setText("10086");
		
	String str = new UiObject(new UiSelector().resourceId("com.android.dialer:id/cliv_name_textview")).getClassName();
	System.out.println("classname : ------"+str);
}
```
- UiCollection

是对象的集合。可从集合中进一步查询需要的对象。<br>
```Java
public void testCollection() throws UiObjectNotFoundException{
	UiCollection viewGroup = new UiCollection(new UiSelector().resourceId("com.android.calculator2:id/pad_numeric"));
	UiObject btn9=viewGroup.getChildByText(new UiSelector().className("android.widget.Button"), "9");
	UiObject btn8=viewGroup.getChildByText(new UiSelector().className("android.widget.Button"), "8");
	UiObject btn7=viewGroup.getChildByText(new UiSelector().className("android.widget.Button"), "7");
	UiObject btnEqu=viewGroup.getChildByText(new UiSelector().className("android.widget.Button"), "=");
		
	UiCollection viewGroup2 = new UiCollection(new UiSelector().resourceId("com.android.calculator2:id/pad_operator"));
	UiObject btnTime=viewGroup2.getChildByDescription(new UiSelector().className("android.widget.Button"), "times");
		
	btn7.click();
	btnTime.click();
	btn8.click();
	btn9.click();
	btnEqu.click();
		
	int cnt1= viewGroup.getChildCount();
	System.out.println("numpad Count:------"+cnt1);
	int cnt2 = viewGroup2.getChildCount(new UiSelector().className("android.widget.Button"));
	System.out.println("operator Count:-------"+cnt2);		
}
```
- UiScrollable
处理可滚动控件的滚动相关操作<br>
```Java
public void testScrollable() throws UiObjectNotFoundException{
	UiScrollable scroll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
	scroll.scrollBackward(); //向后滚动
	scroll.scrollForward();//向前滚动
	// scroll.scrollForward(10);
	scroll.scrollToBeginning(maxSwips);//多少次到滚动到起始位置
	scroll.scrollToEnd(5);
	scroll.flingForward();//快速向前滚动
	scroll.flingToEnd(30);
	scroll.scrollTextIntoView("Basing");//滚动到Basing控件
	scroll.scrollIntoView(new UiObject(new UiSelector().text("Basing")));//同样滚动到Basing控件
	scroll.scrollIntoView(new UiSelector().text("Basing"));
	UiObject basing=scroll.getChildByText(new UiSelecter().className("android.widget.TextView"),"Basing",true);
	basing.click();
}
```
### UiAutomator实例
- 进入App列表页
- 找到设置应用并进入
- 进入语言设置
- 更新当前语言

创建工程SetLanguage<br>
# chapter7
### Appium简介
- 开源App自动化测试工具,支持IOS和Android跨平台测试 http://appium.io
- Android4.3+基于UiAutomator
- Android2.3+基于Instrumentation(Selendroid)
- C/S架构,基于Selenium WebDriver协议同一接口
- 脚本多语言支持 Java、Python、ruby、php、JavaScript、C#

### Appium安装
- Android基本开发环境准备
- 安装Node.js https://nodejs.org/en/
- 安装Appium 

1.npm安装 `npm install -g appium`<br>
2.官方安装包: https://bitbucket.org/appium/appium.app/downloads/<br>
3.安装验证: `appium-doctor(npm安装)`<br>
- Appium客户端(Java)

1.`Java-client`<br>
2.`selenium-java`<br>
3.`selenium-server-standalone`<br>

### 使用Appium
创建AppiumTest工程,引入相关三个包<br>
```Java
public static void main(String[] args) throws MalformedURLException, InterruptedException {
	AppiumDriver driver;
		
	DesiredCapabilities cap=new DesiredCapabilities();
		
	cap.setCapability("deviceName","192.168.117.101:5555");
	cap.setCapability("platformVersion", "7.0");
	cap.setCapability("appPackage", "com.android.calculator2");
	cap.setCapability("appActivity", ".Calculator");
	driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
}		
```
- 创建java项目
- 运行Appium Server `appium [参数]` `-a -p --log --command-timeout`

![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter7/Image/30.PNG)<br>
获取命令行参数:`appium -h`<br>
运行java项目,`run as-->java application`<br>
### DesiredCapabilities介绍
- 定义Appium运行所需的基本配置信息
- 扩展自Webdriver的DesiredCapabilities对象

![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter7/Image/31.PNG)<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter7/Image/32.PNG)<br>
appium文档:http://appium.io/docs/cn/about-appium/intro/<br>
```Java
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
```
### 界面元素定位
- `findElementBy(By)`
- `findElementsByClassName`
- `findElementById`
- `findElementByAccessibilityId`
- `findElementByXPath`
- `findElementByAndroidUIAutomator`

创建Junit用例,`AppTest1.java`<br>
### 界面等待方法
- 显式等待 `Thread.sleep(ms)`
- 隐式等待 `driver.manage().timeouts().implicitlyWait(Second,TimeUnit.SECONDS)`;

### 混合应用测试
- `Context`切换
- `ChromeDriver`的使用

创建Junit测试用例,`AppTest2.java`<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter7/Image/33.PNG)<br>
### Appium实例
进入慕课主页-->进入手记-->选择最新手记-->查看手记-->验证-->返回主页<br>
创建Junit测试用例,HandNoteTest.java<br>

























