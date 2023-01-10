FROM eclipse-temurin:17

LABEL maintainer="dbeken1985@gmail.com"

EXPOSE 8086

WORKDIR /app

COPY target/organization-service-0.0.1-SNAPSHOT.jar /app/springboot-organization-service.jar
COPY application.properties /opt/application.properties

ENTRYPOINT ["java", "-jar", "springboot-organization-service.jar","--spring.config.location=/opt/application.properties"]
