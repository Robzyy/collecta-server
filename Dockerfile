# STAGE 1: Build Java Spring app
# --------------------------------------

# Pull Gradle image
FROM gradle:jdk21-alpine AS build

# Set working directory
WORKDIR /app

# Copy Gradle files
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Copy project files
COPY src ./src

# Build app, without testing branch, just main
RUN gradle build -x test


# STAGE 2: Run the application
# --------------------------------------

FROM amazoncorretto:21-alpine

WORKDIR /app

ARG JAR_FILE
ENV JAR_FILE=${JAR_FILE}

COPY --from=build /app/build/libs/*.jar ./

EXPOSE 4150

ENTRYPOINT java -jar ${JAR_FILE}