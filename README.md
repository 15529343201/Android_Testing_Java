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




