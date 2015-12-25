## 基础知识

### 1. 获取 Android 应用的包名和类名：
#### 1.1. 查看应用包名

```shell
adb shell
ls data/data
```
或使用 monitor 工具查看

#### 1.2. 查看应用 Activity 类名
```shell
adb shell
logcat | [busybox] grep START
```
这时，打开应用或启动新 Activity 会看到有如下新增 log：

```shell
I/ActivityManager(  723): START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x10200000 cmp=com.lovexiaov.learnfromzero/.AtyMain (has extras)} from uid 10039 on display 0
```
其中 `com.lovexiaov.learnfromzero/.AtyMain` 斜杠前是包名，斜杠后是类名。

可以看到，这又是一种获取应用包名的方法。

## Android Monkey 的使用

### 1. Android Monkey 参数


## Android 单元测试

## Android自动化测试





