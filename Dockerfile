FROM openjdk:17-bullseye
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.war"]
