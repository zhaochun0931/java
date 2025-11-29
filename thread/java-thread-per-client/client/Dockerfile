FROM amazoncorretto:8-al2023-jdk
WORKDIR /app
COPY MultiClient.java .
COPY SingleClient.java .
RUN javac MultiClient.java SingleClient.java
CMD ["java", "MultiClient"]

