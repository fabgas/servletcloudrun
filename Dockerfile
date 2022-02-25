FROM openjdk:11-jre-slim

EXPOSE 8080

ARG JAR_FILE=target/*jar-with-dependencies.jar
COPY ${JAR_FILE} servlet.jar
ENTRYPOINT ["java","-jar","servlet.jar"]