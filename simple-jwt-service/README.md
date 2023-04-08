# Simple Jwt Service
## 简介
本项目是一个简单的jwt认证服务，使用了spring security和jwt，实现了注册、登陆、刷新token等功能。本项目的目的是为了学习spring security和jwt，所以没有使用数据库，而是使用了内存存储，所以重启服务后数据会丢失。网上很多jwt的教程都是基于jjwt的,但是spring security oath其实有标准的实现，本项目使用此实现。

## Api 概览
本服务共包括四个接口，/api/v1/auth下为认证相关接口，/test为测试接口。首先需要注册账号，根据注册的账号进行登陆，获取jwtToken，然后在请求头中添加Authorization: Bearer jwtToken，即可访问/test接口。刷新接口需要传入正确的refreshToken，认证refreshToken并发放新的accessToken。
- 注册接口: /api/v1/auth/signup
- 登陆接口: /api/v1/auth/login
- 刷新接口: /api/v1/auth/refresh
- 测试接口: /test