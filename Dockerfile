FROM openjdk:8
ADD target/docker-sber-app.jar docker-sber-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-sber-app.jar"]


