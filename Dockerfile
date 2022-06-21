FROM maven:3.8-openjdk-11 AS build

# copy our application code
WORKDIR /app

COPY /backend ./
COPY /backend/pom.xml ./

RUN mvn package

FROM openjdk:11-jre-slim

COPY --from=build app/target/ /usr/local/lib/target/
ENTRYPOINT ["java","-jar","/usr/local/lib/target/backend-1.0.jar"]

