FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV JAR_FILE /home/vsts/work/1/a/target/cloud-microservices-demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8980
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
