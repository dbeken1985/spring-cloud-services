FROM eclipse-temurin:17

LABEL maintainer="dbeken1985@gmail.com"

expose 8081

WORKDIR /app

COPY target/employee-service-0.0.1-SNAPSHOT.jar /app/springboot-employee-service.jar
COPY application.properties /opt/application.properties

ENTRYPOINT ["java", "-jar", "springboot-employee-service.jar","--spring.config.location=/opt/application.properties"]
