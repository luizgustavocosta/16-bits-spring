FROM openjdk:11.0.9.1-slim@sha256:201415101fea9f9aee9f6760330fdbf42685fac1ec467408c10e572fbb90fec7
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} 16-bits-how-2-lombok.jar
ENTRYPOINT ["java","-jar","/16-bits-how-2-lombok.jar"]
EXPOSE 8092