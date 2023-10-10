# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /register

CMD ["maven/bin/mvn" , "package"]

CMD ["java", "-jar", "/target/register-0.0.1-SNAPSHOT.jar"]