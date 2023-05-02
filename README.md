# 작성 틀

### API 설명

일반 로그인

### HTTP Method

POST

### URI

> http://localhost:8080/auth/login
> 

### Header

### Request Dto

- email
- password

```json
//요청 값
{
    "email": "song123@naver.com",
    "password": "0000"
}
```

### Response Dto

- grantType
- accessToken
- tokenExpiresIn

```json
//응답
{
    "grantType": "bearer",
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY3MzA5MDM1M30.t04aM6S3CRqVjAW71NfhtgOndhJIePppdn5e1QRTMi7_Jj9uc_2IbPNcfXTqfgnkEPmcPLitl5WtgbQv9_Kdng",
    "tokenExpiresIn": 1673090353658
}
```

[회원가입](https://www.notion.so/9a7b1cd78d4a40c1967353305f26f269)

[회원 정보 조회](https://www.notion.so/d2542442fa79417a8b56cea74fdc2e43)

[회원 정보 수정](https://www.notion.so/1602c5fd4e4046db8169a8577fef47c2)

[회원 탈퇴](https://www.notion.so/b7fc2b8db7c247e9a9ffd7d50b25029a)
