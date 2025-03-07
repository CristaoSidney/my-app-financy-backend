FROM ubuntu:latest AS build

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    apt-get clean

WORKDIR /app

COPY . .

RUN mvn clean package

FROM openjdk:17-jdk-slim

EXPOSE 8080

WORKDIR /app

COPY --from=build /app/target/my_app_financy_backend-0.0.1-SNAPSHOT.jar /app/my_app_financy_backend-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/my_app_financy_backend-0.0.1-SNAPSHOT.jar"]