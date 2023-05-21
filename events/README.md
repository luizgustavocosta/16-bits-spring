## Events

### How to start
```shell
chmod +x gradlew
./gradlew bootRun
```

### Port
The default port is 8080

### Swagger
- http://localhost:8080/swagger-ui/index.html

#### Create - Payload example
```json
{
  "country": "Brazil",
  "episodes": [
    {
      "description": "Pilot episode",
      "lengthInSeconds": 92,
      "title": "Lugocast - Pilot"
    }
  ],
  "name": "Lugocast",
  "owner": "Luiz Costa"
}
```
