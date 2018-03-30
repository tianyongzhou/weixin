# weixin
JAVA语言开发的微信公众平台基础框架
------------------------------------
联系QQ：1061447280
欢迎各位加入^^
-----------------------------------
集成：
1、将 weixin.properties文件中的：
app_id=xxx
app_secret=xxx
token=xxx
替换成你申请的微信公众号信息；

2、此项目是是一个javaWeb项目，将以下的jar包：
commons-beanutils-1.7.0.jar
commons-codec-1.10.jar
commons-collections.jar
commons-collections-3.2.jar
commons-httpclient-3.0.1.jar
commons-lang-2.4.jar
commons-logging-1.2.jar
dom4j-1.6.1.jar
ezmorph-1.0.3.jar
fluent-hc-4.5.4.jar
gson-2.8.0.jar
httpclient-4.5.4.jar
httpclient-cache-4.5.4.jar
httpcore-4.4.7.jar
httpmime-4.5.4.jar
json-lib-2.3-jdk13.jar
junit-4.9.jar
xmlpull-1.1.3.1.jar
xstream-1.4.9.jar
下载并添加到：web/lib目录下，当然也可通过maven构建；

3、将项目编译运行即可
------------------------------------------------
 如何二次开发？？
 1、微信所有推送过来的消息、事件我都进行的的对象封装并通过相应接口的进行接收，可将weixin.properties配置文件中wxAdapterPath项
 （参考：com.tyz.weixin.TestWxAdpter）修改成自己的数据接口，但必须实现AbsWxAdapter抽象类；
 2、所有进行微信相关配置都通过WxUtils工具类中的各方法进行封装，简单调用即可，非常方便！
 -----------------------------------------------------------------------------------------------
 接口方法都测试通过，小伙伴可以放心使用，个人必定能力时间有限，欢迎各位志同道合的朋友加入！！！
