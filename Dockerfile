FROM openjdk:19
COPY build/libs/ms-users-group6263-1.0-SNAPSHOT.jar app.jar
EXPOSE 8084
CMD ["java","-Dspring.profiles.active=prod", "-jar", "app.jar"]