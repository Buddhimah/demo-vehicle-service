# Use the OpenJDK image based on Alpine Linux as the base image
FROM openjdk:17-alpine



# Set the working directory inside the container
WORKDIR /app

ARG USER=buddhima
ARG USER_GROUP=buddhima
ARG USER_ID=10001
ARG USER_GROUP_ID=10001
ARG USER_HOME=/home/${USER}

RUN addgroup -g ${USER_GROUP_ID} -S ory; \
    adduser -u ${USER_ID} -S ory -G ory -D  -h /app -s /bin/nologin; \
    chown -R ${USER_ID}:${USER_GROUP_ID} /app



# Download the WAR file from the provided URL and rename it to service.war

ADD --chown=10001:10001 https://github.com/Buddhimah/demo-vehicle-service/releases/download/v0.0.34/employee-0.0.34.jar /app/



# Expose the port that your Spring Boot application uses (default is 8080)
EXPOSE 8080
EXPOSE 443
EXPOSE 80

USER 10001

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "/app/employee-0.0.34.jar"]

