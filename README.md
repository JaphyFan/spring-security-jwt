<h1 align="center">Spring Security Jwt Sample </h1>

> English | [中文文档](README_ZH.md)

## Prerequisites
- jdk17
- springboot 3.0.4

## Introduction
The project is divided into three modules
- simple-jwt-service: The basic implementation of jwt, which integrates security's oauth2, is more concise than jjwt's implementation, and realizes functions such as registration, login, and token refresh.
- auth-service: a service that integrates jwt authentication and authorization. It is essentially an extension of simple-jwt-service. For simplicity, the implementation of RefreshToken is removed
- web-service: a service that simulates the interaction between a third party and auth-service

## How to run
### simple-jwt-service
It can run independently, register, log in, refresh token and other operations through the interface under /api/v1/auth, and then test it through the /test interface

### auth-service and web-service
You need to start the auth-service(profile=auth) first, and then start the web-service. The web-service will pull the public key of the auth-service to verify the validity of the jwt, and then perform authentication tests and authorization tests based on prepost annotations through the web-service interface.

## Script
### Generate key pair script for jwt
Note: This script is generated under mac, it may need to be modified under windows

```bash
# Generate pem private key in PEM-encoded X.509 format
openssl genrsa -out refresh.pem 2048
# generate public key
openssl rsa -in refresh.pem -out refresh.pub -pubout
# Convert the private key to PKCS#8 format
openssl pkcs8 -topk8 -inform PEM -in refresh.pem -outform PEM -out refresh.key -nocrypt
```