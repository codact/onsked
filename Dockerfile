FROM openjdk:14-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} onsked.jar
ENTRYPOINT ["java","-jar","/onsked.jar"]