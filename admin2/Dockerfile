FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/admin2-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} admin2.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/admin2.jar"]