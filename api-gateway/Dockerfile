FROM eclipse-temurin:17

LABEL maintainer="dbeken1985@gmail.com"

expose 9191

WORKDIR /app

COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app/springboot-api-gateway.jar
COPY application.properties /opt/application.properties

ENTRYPOINT ["java", "-jar", "springboot-api-gateway.jar","--spring.config.location=/opt/application.properties"]
