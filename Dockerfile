# Define the base image for the build stage
ARG VERSION=21
ARG GRADLE_VERSION=8
ARG BUILDER=docker.io/library/gradle
FROM ${BUILDER}:${GRADLE_VERSION}-jdk${VERSION} AS build
WORKDIR /app

# Copy Gradle and source files
COPY build.gradle* gradlew* settings.gradle* ./
COPY gradle/ ./gradle/
COPY src src

# Build the application
RUN ./gradlew clean build -x check -x test

# Define the base image for the runtime stage
FROM eclipse-temurin:${VERSION}-jdk AS runtime
WORKDIR /app
VOLUME /tmp

# Install wget
RUN apt-get update && \
    apt-get install -y --no-install-recommends wget && \
    apt-get clean && \
    rm -f /var/lib/apt/lists/*_*

# Copy the built application from the build stage
COPY --from=build /app/build/libs/learning-spring-boot-0.0.1-SNAPSHOT.jar /app/learning-spring-boot.jar

# Set environment variables and expose the port
ENV PORT=8080
EXPOSE ${PORT}

# Configure the start command for the container
CMD ["java", "-jar", "/app/learning-spring-boot.jar"]
