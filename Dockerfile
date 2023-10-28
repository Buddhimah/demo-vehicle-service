# Use an official Python runtime as the base image
FROM python:3.9-slim

# Set the working directory in the container
WORKDIR /app

# Add a non-root user within the recommended range
RUN useradd -m appuser -s /bin/bash -u 10001

# Copy the current directory contents into the container at /app
COPY . /app

# Install any needed packages specified in requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Change the ownership of the /app directory to the non-root user
RUN chown -R appuser /app

# Use the non-root user to run the application
USER appuser

# Define environment variable
ENV NAME World

# Run app.py when the container launches
CMD ["python", "app.py"]
