FROM openjdk:17-alpine
EXPOSE 8080
COPY target/taskmanagement.jar /usr/app
WORKDIR /usr/app
CMD ["java", "-jar", "taskmanagement.jar"]