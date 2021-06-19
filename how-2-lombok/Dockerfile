FROM openjdk:11.0.9.1-slim
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-helloworld.jar
ENTRYPOINT ["java","-jar","/spring-helloworld.jar"]
EXPOSE 8092