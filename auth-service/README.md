# Auth Service

## 重要端点
- http://127.0.0.1:8081/oauth2/jwks
```json
{
   "keys":[
      {
         "kty":"RSA",
         "e":"AQAB",
         "kid":"e902868c-50ec-419c-a85a-1e181794577e",
         "n":"3FlqJr5TRskIQIgdE3Dd7D9lboWdcTUT8a-fJR7MAvQm7XXNoYkm3v7MQL1NYtDvL2l8CAnc0WdSTINU6IRvc5Kqo2Q4csNX9SHOmEfzoROjQqahEcve1jBXluoCXdYuYpx4_1tfRgG6ii4Uhxh6iI8qNMJQX-fLfqhbfYfxBQVRPywBkAbIP4x1EAsbC6FSNmkhCxiMNqEgxaIpY8C2kJdJ_ZIV-WW4noDdzpKqHcwmB8FsrumlVY_DNVvUSDIipiq9PbP4H99TXN1o746oRaNa07rq1hoCgMSSy-85SagCoxlmyE-D-of9SsMY8Ol9t0rdzpobBuhyJ_o5dfvjKw"
      }
   ]
}
```
- http://127.0.0.1:8081/.well-known/openid-configuration
- http://localhost:8081/.well-known/oauth-authorization-server