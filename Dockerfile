From eclipse-temurin:17


WORKDIR /app

COPY target/docker-demo-0.0.1-SNAPSHOT.jar /app/docker-demo.jar 

CMD ["java", "-jar", "docker-demo.jar"]
