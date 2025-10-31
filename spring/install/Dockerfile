# Base Ubuntu image
FROM ubuntu:22.04

# Disable interactive prompts during package install
ENV DEBIAN_FRONTEND=noninteractive

# Install dependencies: Java, Maven, unzip, curl, git
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    maven \
    curl \
    unzip \
    wget \
    git \
    vim \
    && rm -rf /var/lib/apt/lists/*

# Install Spring Boot CLI (tested version)
RUN SPRING_VERSION=2.7.12 \
    && curl -Lo /tmp/spring-cli.zip https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-cli/${SPRING_VERSION}/spring-boot-cli-${SPRING_VERSION}-bin.zip \
    && unzip /tmp/spring-cli.zip -d /opt \
    && ln -s /opt/spring-boot-cli-${SPRING_VERSION}/bin/spring /usr/local/bin/spring \
    && rm /tmp/spring-cli.zip

# Set working directory
WORKDIR /workspace

# Verify installations
RUN java -version && mvn -v && spring --version

# Default command
CMD ["/bin/bash"]
