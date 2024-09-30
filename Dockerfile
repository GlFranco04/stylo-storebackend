# Paso 1: Usar una imagen base oficial de Maven para construir el JAR
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app

# Paso 2: Copiar todo el código fuente al contenedor
COPY . .

# Paso 3: Ejecutar el comando para construir el JAR
RUN mvn clean package -DskipTests

# Paso 4: Usar una imagen base más ligera de Java para el runtime
FROM openjdk:17-jdk-slim
WORKDIR /app

# Paso 5: Copiar el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/stylo-store-backend-0.0.1-SNAPSHOT.jar stylo-store-backend.jar

# Paso 6: Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Paso 7: Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "stylo-store-backend.jar"]
