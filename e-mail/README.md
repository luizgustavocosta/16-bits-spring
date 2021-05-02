## How to run

1. Add the following keys as environment variable
    - email.to
    - spring.mail.username
    - spring.mail.password
2. Then run the AppMain class
3. And using curl do the following request, using -v as verbose
```curl
curl -v -X POST http://localhost:8080/api/v1/email
```