FROM eclipse-temurin:17

LABEL maintainer="dbeken1985@gmail.com"

EXPOSE 8761

WORKDIR /app

COPY target/service-registry-0.0.1-SNAPSHOT.jar /app/springboot-service-registry.jar
COPY application.properties /opt/application.properties

ENTRYPOINT ["java", "-jar", "springboot-service-registry.jar","--spring.config.location=/opt/application.properties"]
