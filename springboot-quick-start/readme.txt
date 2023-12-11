https://start.spring.io/




https://www.jetbrains.com/guide/java/tutorials/your-first-spring-application/





mvn spring-boot:run
mvn spring-boot:run -Dspring-boot.run.arguments=--logging.level.org.springframework=TRACE


http://localhost:8080/

http://localhost:8080/goodbye









# change the default port

src/main/resources/application.properties

server.port=8081



src/main/resources/application.yml

server:
  port: 8082
