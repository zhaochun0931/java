# Base Ubuntu image
FROM ubuntu:22.04

# Disable interactive prompts during package install
ENV DEBIAN_FRONTEND=noninteractive

# Install dependencies
RUN apt-get update && apt-get install -y \
    curl \
    unzip \
    zip \
    wget \
    openjdk-17-jdk \
    maven \
    git \
    vim \
    && rm -rf /var/lib/apt/lists/*

# Install Spring Boot CLI
RUN curl -s https://repo.spring.io/release/org/springframework/boot/spring-boot-cli/3.3.4/spring-boot-cli-3.3.4-bin.zip -o /tmp/spring.zip \
    && unzip /tmp/spring.zip -d /opt \
    && ln -s /opt/spring-3.3.4/bin/spring /usr/local/bin/spring \
    && rm /tmp/spring.zip

# Set working directory
WORKDIR /workspace

# Verify installation
RUN java -version && spring --version

# Default command
CMD ["/bin/bash"]
