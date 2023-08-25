FROM openjdk:17-alpine
EXPOSE 8080
COPY target/task-management-0.0.1-SNAPSHOT.jar /task-management.jar
WORKDIR /
CMD ["java", "-jar", "task-management.jar"]
