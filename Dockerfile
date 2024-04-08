# Usar a imagem do Eclipse Temurin com Java 17 JDK baseada em Alpine
FROM eclipse-temurin:17-jdk-alpine

# Copiar o artefato JAR construído para a imagem
COPY target/motorista-service-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta em que a aplicação vai rodar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]