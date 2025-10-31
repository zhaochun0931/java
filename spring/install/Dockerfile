FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive
ENV SPRING_VERSION=2.7.12
ENV PATH=$PATH:/opt/spring-${SPRING_VERSION}/bin

# Install dependencies
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    maven \
    curl \
    unzip \
    git \
    vim \
    && rm -rf /var/lib/apt/lists/*

# Download and install Spring Boot CLI
RUN curl -Lo /tmp/spring.zip https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-cli/${SPRING_VERSION}/spring-boot-cli-${SPRING_VERSION}-bin.zip \
    && unzip /tmp/spring.zip -d /opt/ \
    && rm /tmp/spring.zip

# Set working directory
WORKDIR /workspace

# Verify installation
RUN java -version && mvn -v && spring --version

CMD ["/bin/bash"]
