# 


### 生成密钥对脚本

```bash
# 先生成pem私钥，格式为 PEM-encoded X.509 format
openssl genrsa -out refresh.pem 2048
# 生成公钥
openssl rsa -in refresh.pem -out refresh.pub -pubout
# 将私钥转换成PKCS#8格式
openssl pkcs8 -topk8 -inform PEM -in refresh.pem -outform PEM -out refresh.key -nocrypt
```
