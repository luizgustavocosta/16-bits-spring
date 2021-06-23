https://mapstruct.org
https://projectlombok.org
https://www.jpa-buddy.com

<!--- STARTEXCLUDE --->
# 16-Bits - Lombok, MapStruct, and Liquibase
A simple SpringBoot application to demonstrate the libraries.
<!--- ENDEXCLUDE --->
<!--- STARTEXCLUDE --->
## Objectives
* Overview of Lombok, MapStruct, and Liquibase

## How this works
* As a business application, has the Controller, Service, and Repository.
* Has one table to store Country data
* Accepts JSON requests
## Class Diagram
![Class Diagram](src/main/resources/static/class-diagram.png)

## Prerequisites
* At least Java 11
* Code editor to browse the classes

### Running on your local machine
1. Download the repo using git
```bash
git clone https://github.com/luizgustavocosta/16-bits-spring.git
cd 16-bits-spring/how-2-lombok
```
Then generate the jar
```bash
mvn clean verify
```
And then run
```bash
java -jar target/how-2-lombok-0.0.1-SNAPSHOT.jar
```

<!--- ENDEXCLUDE --->

References
https://github.com/pkainulainen/maven-examples