<<<<<<< HEAD
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/sber-test-application.jar /app/
ENTRYPOINT ["java", "-jar", "sber-test-application.jar"]

ste5an/sber-test-application:msb
=======
FROM openjdk:8
ADD target/docker-sber-app.jar docker-sber-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-sber-app.jar"]


>>>>>>> b0ba126... Initial commit
