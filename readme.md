# JDBC Sniffer Demo

Sample application with JDBC Sniffer integration based on [Spring PetClinic](https://github.com/spring-projects/spring-petclinic)

JDBC Sniffer records the queries executed by your Java application and shows them right in your browser.
It allows you to early identify the performance ssues related to the database. Ideal for testing environment.

See more at [https://github.com/sniffy/sniffy](https://github.com/sniffy/sniffy)

## Demo

Live Demo - [http://demo.sniffy.io/](http://demo.sniffy.io/owners.html?lastName=)

![RecordedDemo](http://sniffy.io/demo.gif)

## Running petclinic locally
```
git clone https://github.com/sniffy/sniffy-demo.git
mvn package
java -jar target/dependency/webapp-runner.jar target/*.war
```

You can then access petclinic here: http://localhost:8080/petclinic/

## Deploying on heroku

```
heroku create
git push heroku master   
heroku open
```
