# Build stage
FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app
COPY pom.xml.
COPY src .
RUN mvn package -DskipTests

# Final stage
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/my-maven-docker-project.jar.
EXPOSE 8080
CMD ["java", "-jar", "my-maven-docker-project.jar"]
