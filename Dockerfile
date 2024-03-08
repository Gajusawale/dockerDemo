From eclipse-temurin:17

WORKDIR /app

EXPOSE 8443

COPY docker-demo-0.0.1-SNAPSHOT.jar /app/docker-demo.jar 

COPY keystore.p12 /keystore.p12

CMD ["java", "-jar", "docker-demo.jar"]

