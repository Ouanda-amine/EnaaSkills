FROM openjdk:21
ADD target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "EnaaSkills.jar"]