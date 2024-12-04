# Usa un'immagine di base con JDK 21
FROM openjdk:21-jdk-slim

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file JAR nell'immagine
COPY target/ShelterManagement-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta dell'app
EXPOSE 8080

# Comando per eseguire l'app
ENTRYPOINT ["java", "-jar", "app.jar"]
