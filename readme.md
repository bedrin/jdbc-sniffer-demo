# JDBC Sniffer Demo

Live Demo - [http://jdbcsniffer.herokuapp.com/](http://jdbcsniffer.herokuapp.com/owners.html?lastName=)

![RecordedDemo](https://bedrin.github.io/jdbc-sniffer/jdbcsniffer.gif)

Sample application with JDBC Sniffer integration based on [Spring PetClinic](https://github.com/spring-projects/spring-petclinic)

## Running petclinic locally
```
	git clone https://github.com/bedrin/jdbc-sniffer-demo.git
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