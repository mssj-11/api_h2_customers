FROM amazoncorretto:18-alpine-jdk

COPY target/api_h2_customers-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java" , "-jar" , "/app.jar"]