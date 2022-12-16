FROM openjdk:11
ADD target/in28Minutes-first-webapp-0.0.1-SNAPSHOT.war in28Minutes-first-webapp-0.0.1-SNAPSHOT.war
ADD target/in28Minutes-first-webapp-0.0.1-SNAPSHOT in28Minutes-first-webapp-0.0.1-SNAPSHOT
ENTRYPOINT ["java", "-jar","in28Minutes-first-webapp-0.0.1-SNAPSHOT.war"]
EXPOSE 8080

