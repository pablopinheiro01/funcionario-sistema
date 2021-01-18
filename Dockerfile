
FROM openjdk:8-jdk-alpine
RUN addgroup -S teste && adduser -S pablopinheiro -G teste
USER pablopinheiro:teste
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} funcionario-1.jar
ENTRYPOINT ["java","-jar","/funcionario-1.jar"]
