# Alpine because it's lighter
FROM openjdk
# Add JAR file and run it as entrypoint
ADD target/spring-boot-jpa-postgresql-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose the port
EXPOSE 8080
