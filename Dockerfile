FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ADD target/auth-service-0.0.1-SNAPSHOT.jar spring-boot-app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/spring-boot-app.jar"]