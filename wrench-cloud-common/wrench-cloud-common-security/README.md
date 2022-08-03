# 🔧 权限

## 安装
[最新版本](https://mvnrepository.com/artifact/io.github.maodua/wrench-cloud-common-security)

Gradle:
```groovy
dependencies {
    compile "io.github.maodua:wrench-cloud-common-security:最新版本号"
}
```
Maven:
```xml
<dependency>
    <groupId>io.github.maodua</groupId>
    <artifactId>wrench-cloud-common-security</artifactId>
    <version>最新版本号</version>
</dependency>
```
## 功能
加入此依赖后，服务会自动解析`上游服务`或`客户端`请求头中的`用户信息`，放入当前线程中使用，当访问下游服务的时候会自动传递给下游服务
```java
// 获取当前用户id
String userId = ContextHolder.getUserId();
// 是否登录用户
boolean login = ContextHolder.isLogin();
```

