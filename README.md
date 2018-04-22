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

http://wear.techbrood.com/tools/help/MonkeyDevice.html<br>
![image](https://github.com/15529343201/Android_Testing_Java/blob/chapter4/Image/5.PNG)<br>





















