#Start with a base image containing Java runtime
FROM openjdk:17-slim as build
#ADD the application's jar to the container
COPY target/iphostECS-0.0.1-SNAPSHOT.jar iphostECS-0.0.1-SNAPSHOT.jar
EXPOSE 8080
#execute the application
ENTRYPOINT ["java","-jar","/iphostECS-0.0.1-SNAPSHOT.jar"]