FROM openjdk:11.0.9.1-slim@sha256:201415101fea9f9aee9f6760330fdbf42685fac1ec467408c10e572fbb90fec7
RUN addgroup --group spring
RUN adduser spring spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-helloworld.jar
ENTRYPOINT ["java","-jar","/spring-helloworld.jar"]
EXPOSE 8092