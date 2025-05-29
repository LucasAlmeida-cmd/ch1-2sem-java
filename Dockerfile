# Usando uma imagem base do Ubuntu para construção
FROM ubuntu:latest AS build

# Atualizando o repositório e instalando o JDK e Maven
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Definindo variáveis de ambiente para encoding
ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

# Definindo o diretório de trabalho para a construção
WORKDIR /app

# Copiando o arquivo pom.xml e o código-fonte do projeto para o container
COPY pom.xml .
COPY src ./src

# Executando a construção do Maven, ignorando os testes e forçando UTF-8
RUN mvn clean install -DskipTests -Dfile.encoding=UTF-8

# Usando uma imagem base mais leve para executar o aplicativo
FROM openjdk:17-jdk-slim

# Definindo variáveis de ambiente para encoding
ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

# Expor a porta 8080
EXPOSE 8080

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o arquivo JAR gerado para a imagem final
COPY --from=build /app/target/GS1-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "app.jar"]