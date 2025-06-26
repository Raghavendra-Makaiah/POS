# ---------- Build Stage ----------
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ---------- Runtime Stage ----------
FROM openjdk:17-jdk-slim AS runtime

WORKDIR /app
# Copy the built jar from the builder stage
COPY --from=builder /app/target/discoveryserver-0.0.1-SNAPSHOT.jar discovery-server.jar

# Expose the port discovery-server runs on
EXPOSE 8761

# Expose the port user-service runs on
EXPOSE 8081

# Expose the port order-service runs on
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "discovery-server.jar"]
