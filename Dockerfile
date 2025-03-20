# Etapa 1: Construcción
FROM gradle:8.0.0-jdk17 as builder
WORKDIR /app

# Copia todos los archivos del proyecto
COPY . .

# Da permisos de ejecución a Gradle Wrapper
RUN chmod +x ./gradlew

# Ejecuta la compilación sin ejecutar pruebas
RUN ./gradlew clean build -x test --no-daemon --refresh-dependencies

# Etapa 2: Imagen ligera para producción
FROM openjdk:17-alpine
WORKDIR /app

# Copia el JAR compilado desde la fase de construcción
COPY --from=builder /app/build/libs/*.jar app.jar

# Expone el puerto 5123
EXPOSE 5123

# Ejecuta la aplicación
CMD ["java", "-jar", "app.jar"]
