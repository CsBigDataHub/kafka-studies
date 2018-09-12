# Kafka Avro Producer in Java

### Generate Avro from customer-v1.avsc

```
mvn package
```
### Start docker

```
docker-compose up
```

### run KafkaAvroJavaProducerV1Demo

- customer-avro-0@0 (Partition 0 and offset 0)
```
Connected to the target VM, address: '127.0.0.1:53459', transport: 'socket'
log4j:WARN No appenders could be found for logger (org.apache.kafka.clients.producer.ProducerConfig).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "automated_email": false}
customer-avro-0@0
```

- Run again customer-avro-0@0 (Partition 0 and offset 1)
```
Connected to the target VM, address: '127.0.0.1:53459', transport: 'socket'
log4j:WARN No appenders could be found for logger (org.apache.kafka.clients.producer.ProducerConfig).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "automated_email": false}
customer-avro-0@1
```

### run Consumer console
 - docker run --net=host -it confluentinc/cp-schema-registry:3.3.0 bash

```
$ kafka-avro-console-consumer --bootstrap-server 127.0.0.1:9092 --topic customer-avro --from-beginning --property schema.registry.url=http://127.0.0.1:8081
{"first_name":"John","last_name":"Doe","age":34,"height":178.0,"weight":75.0,"automated_email":false}
{"first_name":"John","last_name":"Doe","age":34,"height":178.0,"weight":75.0,"automated_email":false}


```

### run KafkaAvroJavaConsumerV1Demo

```
log4j:WARN No appenders could be found for logger (org.apache.kafka.clients.consumer.ConsumerConfig).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
Waiting for data...
Polling
Polling
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "automated_email": false}

```
