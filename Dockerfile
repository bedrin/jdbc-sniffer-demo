FROM openjdk:8

WORKDIR /deployment

ADD target /deployment

EXPOSE 8080

CMD ["java", "-jar", "spring-petclinic-1.5.1.jar"]
