FROM java:openjdk-8-jre-alpine

EXPOSE 8080
ADD /target/fastfood-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
