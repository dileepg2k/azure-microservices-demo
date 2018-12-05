FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
WORKDIR ${JAR_FILE_PATH}
COPY ${JAR_FILE_NAME} app.jar
EXPOSE 8980
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
