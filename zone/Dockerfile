FROM openjdk:8-jdk-alpine

RUN apk add maven

VOLUME /tmp
EXPOSE 8080

ENV SERVER_PORT 8080
ENV DB_USER "root"
ENV DB_PASSWORD "root"
ENV DB_NAME "climbing"
ENV DB_URL "0.0.0.0"
ENV DB_PORT "3306"
ENV DB_OPTIONS "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"

ADD src src
ADD pom.xml pom.xml

ENTRYPOINT mvn clean spring-boot:run -Dspring-boot.run.arguments=--spring.datasource.url="jdbc:mysql://${DB_URL}:${DB_PORT}/${DB_NAME}${DB_OPTIONS}",--spring.datasource.username="${DB_USER}",--spring.datasource.password="${DB_PASSWORD}",--spring.datasource.port="${SERVER_PORT}"
