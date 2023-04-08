# spring security jwt sample

## prerequisites
- jdk17
- springboot 3.0.4

## 简介
本项目分成三个模块
- simple-jwt-service: jwt的基本实现
- auth-service: 集成jwt认证和授权的服务,本质上是在simple-jwt-service扩展而来，为了简单，移除了RefreshToken的实现
- web-service: 一个模拟第三方和auth-service交互的服务


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
