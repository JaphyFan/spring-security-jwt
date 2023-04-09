# Spring Security Jwt Sample

## 运行环境
- jdk17
- springboot 3.0.4

## 简介
本项目分成三个模块
- simple-jwt-service: jwt的基本实现,整合了security 的oauth2，比起jjwt的实现更加简洁，实现了注册、登陆、刷新token等功能。
- auth-service: 集成jwt认证和授权的服务,本质上是在simple-jwt-service扩展而来，为了简单，移除了RefreshToken的实现
- web-service: 一个模拟第三方和auth-service交互的服务

## 如何运行
### simple-jwt-service
可单独运行，通过/api/v1/auth下的接口进行注册、登陆、刷新token等操作，然后通过/test接口进行测试

### auth-service和web-service
需要先启动auth-service，然后启动web-service，web-service会拉取auth-service的公钥用于认证jwt有效性，然后通过web-service的接口进行认证测试和基于prepost注解的授权测试

## 脚本
### 生成用于jwt的密钥对脚本
注：本脚本是在mac下生成，windows下可能需要修改

```bash
# 先生成pem私钥，格式为 PEM-encoded X.509 format
openssl genrsa -out refresh.pem 2048
# 生成公钥
openssl rsa -in refresh.pem -out refresh.pub -pubout
# 将私钥转换成PKCS#8格式
openssl pkcs8 -topk8 -inform PEM -in refresh.pem -outform PEM -out refresh.key -nocrypt
```
