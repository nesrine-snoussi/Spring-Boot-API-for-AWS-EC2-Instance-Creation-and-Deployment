# FROM openjdk:11
# # ADD target/my-maven-docker-project.jar my-maven-docker-project.jar
# COPY . .
# ENTRYPOINT ["java", "-jar","my-maven-docker-project.jar"]
# EXPOSE 8080

# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-11-slim AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn  package -DskipTests
# Use an official OpenJDK image as the base image
FROM openjdk:11-jre-slim
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/kaka.jar .
# Set the command to run the application
CMD ["java", "-jar", "kaka.jar"]