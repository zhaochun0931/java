https://start.spring.io/




https://www.jetbrains.com/guide/java/tutorials/your-first-spring-application/





mvn spring-boot:run
mvn spring-boot:run -Dspring-boot.run.arguments=--logging.level.org.springframework=TRACE


http://localhost:8080/

http://localhost:8080/goodbye


$ curl localhost:8080
hello world from Spring Boot
$
$
$ curl localhost:8080/hello
Hello  World! 2024-06-08T19:35:54.962241
$
$
$
$ curl localhost:8080/goodbye
Goodbye from Spring Boot
$
$






# change the default port

src/main/resources/application.properties

src/main/resources/application.yml

