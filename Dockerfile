FROM openjdk:17
ADD target/tenpo-api-docker.jar tenpo-api-docker.jar
ENTRYPOINT ["java", "-jar", "tenpo-api-docker.jar"]
EXPOSE 8080