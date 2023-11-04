# Use the OpenJDK image based on Alpine Linux as the base image
FROM openjdk:17-alpine


# Set the working directory inside the container
WORKDIR /app

# Download the WAR file from the provided URL and rename it to service.war
ADD https://github.com/Buddhimah/demo-vehicle-service/releases/download/v0.0.13/service-0.0.13.war /app/service.war

# Expose the port that your Spring Boot application uses (default is 8080)
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "/app/service.war"]
