#mvn --version
FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests  

#java --version
FROM  openjdk:13
VOLUME /tmp
EXPOSE 8005
COPY --from=build /home/app/target/*.jar app.jar
ENV SPRING_PROFILES_ACTIVE=docker
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]