FROM openjdk:17-alpine
EXPOSE 8080
COPY target/task-management-0.0.1-SNAPSHOT.jar /usr/app
WORKDIR /usr/app
CMD ["java", "-jar", "taskmanagement.jar"]