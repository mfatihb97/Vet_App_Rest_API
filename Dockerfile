FROM maven:3.8.4-openjdk-20 AS build

WORKDIR /app

COPY ./pom.xml /app

COPY ./src /app/src

RUN mvn clean package -Dmaven.test.skip=true

FROM adoptopenjdk/openjdk20:jdk-20.3 AS runtime

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
