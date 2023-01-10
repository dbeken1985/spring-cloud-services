FROM eclipse-temurin:17

LABEL maintainer="dbeken1985@gmail.com"

EXPOSE 8888

WORKDIR /app

COPY target/config-server-0.0.1-SNAPSHOT.jar /app/springboot-config-server.jar
COPY application.properties /opt/application.properties

ENTRYPOINT ["java", "-jar", "springboot-config-server.jar","--spring.config.location=/opt/application.properties"]
