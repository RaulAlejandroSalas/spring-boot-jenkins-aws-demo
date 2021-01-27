FROM openjdk:15
LABEL "dev.raul.spring-boot-jenkins-aws-demo"="Raul Soft 2021"
LABEL mainteiner="Raul Alejandro Salas Texido<alejandrosalas0891@gmail.com>"
LABEL version="1.0.0"
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
