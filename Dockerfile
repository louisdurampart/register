# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

VOLUME /tmp

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080

