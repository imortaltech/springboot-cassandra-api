# kafka-producer
**Overview**

This POC contains Kafka Producer and Integrated with Kafka and Minio 
using Spring Boot.The following features covered on this sub module.
- Kafka Integration to publish data in a schedule interval on configured Topic
- Minio Integration to persist/upload data
- REST APIs exposed to list out Buckets, Upload and Download data.
- Default Topic Name is 'pocTopic'
- Enabled with Gradle Build tool


**Pre-requisite**
- Run in Docker
```
Docker or Docker Desktop required 
```
- Build and Customize and Run 
```
. github account should be created 
. git cli required
. Gradle required
. Java JDK 1.8 or JDK.11 required 
. Intelij CE for development
. Docker Hub account required 
. Docker or Docker Desktop required  
```
**How to clone the codebase**
- generate ssh keys using ssh-keygen
- add public key into SSH Key Section under github profile settings
- open windows command prompt and do git clone git@github.com:ERS-HCL/kafka-spark-streaming.git

**How to build the Kafka Producer project in CLI/IDE**
```
cd kafkaproducer
gradle build
```

**How to run the Kafka Producer project in CLI/IDE for development and debug**
```
run the docker compose inside kafkaproducer folder for development and debug
cd kafkaproducer
gradle run
```

**How to build, run and Publish docker Image for kafka Producer**
```
cd kafkaproducer
docker build -t repo:kafka-with-minio:latest
docker run -t repo:kafka-with-minio:latest
docker push -t  repo:kafka-with-minio:latest
```

**How to run Kafka Producer with Minio, Kafka in Docker altogether** 

```

docker-compose up

```

**Configurable Variables**
```
      KAFKA_BOOTSTRAP_ADDRESS: kafka:9092
      MINIO_URL: http://minio:9000
      TOPIC_URL: pocTopic
      BUCKET_NAME: sparkpoc
      MINIO_ROOT_USER: minio
      MINIO_ROOT_PASSWORD: minio123
      APP_PORT: 8082

```


**Todo**
- Topic name should be configurable
- Docker Hub repo should be configurable
- Application Port should be configurable 
- maven should be removed 
- add this build job in Github pipeline

**Screen shots**

- Spring Boot - Kafka Producer console output

![KafkaProducer](./docs/kafkaproducer.jpg?raw=true)

- Minio Local Host

![Minio](./docs/dashboard.jpg?raw=true)

- Spring Boot Microservice - Minio Integration

![MicroService](./docs/microservice.jpg?raw=true)


**Reference**
- https://www.docker.com/products/docker-desktop
- https://gradle.org/install/
- https://kafka.apache.org/
- https://spring.io/projects/spring-boot 
