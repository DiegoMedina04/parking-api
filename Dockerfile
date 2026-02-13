# Etapa de construcción
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY api/api/pom.xml .
COPY api/api/src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]