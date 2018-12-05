FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
RUN cd /
COPY ${JAR_FILE} app.jar
EXPOSE 8980
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
