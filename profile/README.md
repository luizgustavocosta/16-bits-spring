## Cover in this project

- Security 
- Jpa 
- Profile 

## Endpoints
``
http://<server>:8282/comics/preview
``

``
http://<server>:8282/comics/characters
``
http://localhost:8282/comics/logout

## Available profiles

- dev 
- dc 
- marvel 
- default 

## How to run

### Console
```mvn verify -DskipTests -P<profile>```

or without -P argument since the default is profile is `marvel`

```mvn verify -DskipTests```
### Docker
Before build the image run the Maven command below
``
mvn clean verify
``
#### Build
```docker build -t 16bits/spring-profile:0.0.1 .```

#### Run
```docker run --name 16-bits-spring-profile -p 8282:8282 16bits/spring-profile:0.0.1```

#### Publish (using DockerHub)
```docker push 16bits/spring-profile:0.0.1```



