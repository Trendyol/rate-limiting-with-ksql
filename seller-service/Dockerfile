FROM maven:3.5-jdk-11 AS build
WORKDIR /tmp
COPY . .
RUN mvn verify -DskipTests -DskipITs

FROM openjdk:11-jdk
COPY --from=build /tmp/target/app.jar .
EXPOSE 8080
ENTRYPOINT java -jar /app.jar
