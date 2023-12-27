FROM openjdk:17

WORKDIR /app

COPY target/arget/helloworld-0.0.1-SNAPSHOT.jar helloworld-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "helloworld-0.0.1-SNAPSHOT.jar"]