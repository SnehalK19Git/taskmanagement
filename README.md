TASK Management API

This is Spring Boot Docker containerized project . It serves the endpoints for managing simple to do tasks.

**Tools and Technologies**
- Java 17
- Spring Boot v3.1.2
- H2 Database
- Docker
- Maven
- STS IDE

**How to run**
To run locally in any IDE
- clone the project and simply run the TaskManagementApplication class

To build and run Docker container locally 
- checkout project
- build the docker image using cmd "docker buildx build ."
- run the image in Docker Desktop "docker run [image-name]"

To run application jar file without code checkout
- Run command "docker build https://github.com/SnehalK19Git/taskmanagement.git#main -f Dockerfile" 
- Run command "docker run [image-name]"

