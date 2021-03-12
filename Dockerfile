FROM openjdk:11
ADD target/mathematics.jar mathematics.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "mathematics.jar"]