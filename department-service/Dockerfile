FROM eclipse-temurin:17

LABEL maintainer="dbeken1985@gmail.com"

expose 8080

WORKDIR /app

COPY target/department-service-0.0.1-SNAPSHOT.jar /app/springboot-department-service.jar
COPY application.properties /opt/application.properties

ENTRYPOINT ["java", "-jar", "springboot-department-service.jar","--spring.config.location=/opt/application.properties"]
