# Dee profiler

Dee profiler 是专门为Dee量身定做的执行时间监测工具。<br/>
主要是监测Flow和Adapter的执行时间，输出log，方便定位一个任务到底是哪里消耗最多时间。

# Features

Dee profiler 主要采用字节码技术，在程序运行时动态注入时间采集代码，可长期运行在正式环境当中，对额外性能消耗极低。

# Quick Start

可以直接下载源码自己打包或者联系qq 709491094

使用需要两个文件：<br/>

1、打包生成 profiler-1.0-SNAPSHOT.jar <br/>
2、example中profile.properties <br/>

还需要再A8中或者Dee可视化配置工具的JVM参数中加入：<br/>

-javaagent:{yourpath}/profiler-1.0-SNAPSHOT.jar -Dprofile.properties={yourpath}/profile.properties

## OK let's try it

# Notice
目前对Flow throw Exception的情况没有支持。<br/>
原因是Dee中都是在方法上throw Excepiton，不方便操作字节码，需要动代码框架，对版本耦合度太高，不容易适配所有版本。<br/>
后续优化。


