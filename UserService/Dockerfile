# Use OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set environment variables
ENV APP_HOME=/app
WORKDIR $APP_HOME

# Stage 1: Build the JAR
FROM maven:3.9.4-eclipse-temurin-17 AS builder
#WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder target/userservice-*.jar user-service.jar

# Expose the port user-service runs on
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "user-service.jar"]
