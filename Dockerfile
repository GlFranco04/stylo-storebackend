# Paso 1: Usar una imagen base de Java
FROM openjdk:17-jdk-slim

# Paso 2: Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Paso 3: Copiar el archivo JAR del proyecto al contenedor
COPY target/stylo-store-backend-0.0.1-SNAPSHOT.jar stylo-store-backend.jar

# Paso 4: Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Paso 5: Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "stylo-store-backend.jar"]
