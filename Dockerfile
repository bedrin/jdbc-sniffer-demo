FROM openjdk:8

ADD ./* /tmp/source/

RUN cd /tmp/source && \
    mvn clean install && \
    mkdir /deployment && \
    cp target/spring-petclinic-1.5.1.jar /deployment && \
    cd /deployment

WORKDIR /deployment

EXPOSE 8080

CMD ["java", "-jar", "spring-petclinic-1.5.1.jar"]
