FROM openjdk:8
ADD target/kong-0.0.1-SNAPSHOT.jar kong-0.0.1-SNAPSHOT.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "kong-0.0.1-SNAPSHOT.jar"]