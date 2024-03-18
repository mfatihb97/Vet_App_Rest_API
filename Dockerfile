FROM maven:3.8.4-openjdk-20 AS build

WORKDIR /app

COPY ./pom.xml /app

COPY ./src /app/src

RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:20-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 7171

CMD \["java", "-jar", "app.jar"\]