# Kafka Avro Producer in Java V2

### Generate Avro from customer-v2.avsc

```
mvn package
```
### Start docker

```
docker-compose up
```

### run KafkaAvroJavaProducerV2Demo

- customer-avro-0@2 (Partition 0 and offset 2)
```
log4j:WARN No appenders could be found for logger (org.apache.kafka.clients.producer.ProducerConfig).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "phone_number": "(123)-456-7890", "email": "john.doe@gmail.com"}
customer-avro-0@2

```

### run Consumer KafkaAvroJavaConsumerV1Demo from kafka-avro-v1
 
```
/Library/Java/JavaVirtualMachines/jdk-10.0.1.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=52455:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Users/davidpetro/Documents/courses/java/kafka-studies/kafka-avro-course/kafka-avro-v1/target/classes:/Users/davidpetro/.m2/repository/org/apache/avro/avro/1.8.2/avro-1.8.2.jar:/Users/davidpetro/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/Users/davidpetro/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/Users/davidpetro/.m2/repository/com/thoughtworks/paranamer/paranamer/2.7/paranamer-2.7.jar:/Users/davidpetro/.m2/repository/org/xerial/snappy/snappy-java/1.1.1.3/snappy-java-1.1.1.3.jar:/Users/davidpetro/.m2/repository/org/apache/commons/commons-compress/1.8.1/commons-compress-1.8.1.jar:/Users/davidpetro/.m2/repository/org/tukaani/xz/1.5/xz-1.5.jar:/Users/davidpetro/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/davidpetro/.m2/repository/org/apache/kafka/kafka-clients/0.11.0.1/kafka-clients-0.11.0.1.jar:/Users/davidpetro/.m2/repository/net/jpountz/lz4/lz4/1.3.0/lz4-1.3.0.jar:/Users/davidpetro/.m2/repository/io/confluent/kafka-avro-serializer/3.3.1/kafka-avro-serializer-3.3.1.jar:/Users/davidpetro/.m2/repository/io/confluent/kafka-schema-registry-client/3.3.1/kafka-schema-registry-client-3.3.1.jar:/Users/davidpetro/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.8.4/jackson-databind-2.8.4.jar:/Users/davidpetro/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.8.0/jackson-annotations-2.8.0.jar:/Users/davidpetro/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.8.4/jackson-core-2.8.4.jar:/Users/davidpetro/.m2/repository/org/slf4j/slf4j-log4j12/1.7.21/slf4j-log4j12-1.7.21.jar:/Users/davidpetro/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/Users/davidpetro/.m2/repository/io/confluent/common-config/3.3.1/common-config-3.3.1.jar:/Users/davidpetro/.m2/repository/io/confluent/common-utils/3.3.1/common-utils-3.3.1.jar:/Users/davidpetro/.m2/repository/org/apache/zookeeper/zookeeper/3.4.10/zookeeper-3.4.10.jar:/Users/davidpetro/.m2/repository/jline/jline/0.9.94/jline-0.9.94.jar:/Users/davidpetro/.m2/repository/io/netty/netty/3.10.5.Final/netty-3.10.5.Final.jar:/Users/davidpetro/.m2/repository/com/101tec/zkclient/0.10/zkclient-0.10.jar com.github.simplesteph.kafka.apps.KafkaAvroJavaConsumerV1Demo
log4j:WARN No appenders could be found for logger (org.apache.kafka.clients.consumer.ConsumerConfig).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
Waiting for data...
Polling
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "automated_email": false}
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "automated_email": false}
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "automated_email": true}
```

### run Consumer KafkaAvroJavaConsumerV2Demo
 
```
/Library/Java/JavaVirtualMachines/jdk-10.0.1.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=53498:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Users/davidpetro/Documents/courses/java/kafka-studies/kafka-avro-course/kafka-avro-v2/target/classes:/Users/davidpetro/.m2/repository/org/apache/avro/avro/1.8.2/avro-1.8.2.jar:/Users/davidpetro/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/Users/davidpetro/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/Users/davidpetro/.m2/repository/com/thoughtworks/paranamer/paranamer/2.7/paranamer-2.7.jar:/Users/davidpetro/.m2/repository/org/xerial/snappy/snappy-java/1.1.1.3/snappy-java-1.1.1.3.jar:/Users/davidpetro/.m2/repository/org/apache/commons/commons-compress/1.8.1/commons-compress-1.8.1.jar:/Users/davidpetro/.m2/repository/org/tukaani/xz/1.5/xz-1.5.jar:/Users/davidpetro/.m2/repository/org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar:/Users/davidpetro/.m2/repository/org/apache/kafka/kafka-clients/0.11.0.1/kafka-clients-0.11.0.1.jar:/Users/davidpetro/.m2/repository/net/jpountz/lz4/lz4/1.3.0/lz4-1.3.0.jar:/Users/davidpetro/.m2/repository/io/confluent/kafka-avro-serializer/3.3.1/kafka-avro-serializer-3.3.1.jar:/Users/davidpetro/.m2/repository/io/confluent/kafka-schema-registry-client/3.3.1/kafka-schema-registry-client-3.3.1.jar:/Users/davidpetro/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.8.4/jackson-databind-2.8.4.jar:/Users/davidpetro/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.8.0/jackson-annotations-2.8.0.jar:/Users/davidpetro/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.8.4/jackson-core-2.8.4.jar:/Users/davidpetro/.m2/repository/org/slf4j/slf4j-log4j12/1.7.21/slf4j-log4j12-1.7.21.jar:/Users/davidpetro/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/Users/davidpetro/.m2/repository/io/confluent/common-config/3.3.1/common-config-3.3.1.jar:/Users/davidpetro/.m2/repository/io/confluent/common-utils/3.3.1/common-utils-3.3.1.jar:/Users/davidpetro/.m2/repository/org/apache/zookeeper/zookeeper/3.4.10/zookeeper-3.4.10.jar:/Users/davidpetro/.m2/repository/jline/jline/0.9.94/jline-0.9.94.jar:/Users/davidpetro/.m2/repository/io/netty/netty/3.10.5.Final/netty-3.10.5.Final.jar:/Users/davidpetro/.m2/repository/com/101tec/zkclient/0.10/zkclient-0.10.jar com.github.simplesteph.kafka.apps.v2.KafkaAvroJavaConsumerV2Demo
log4j:WARN No appenders could be found for logger (org.apache.kafka.clients.consumer.ConsumerConfig).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
Waiting for data...
Polling
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "phone_number": null, "email": "missing@example.com"}
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "phone_number": null, "email": "missing@example.com"}
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "phone_number": "(123)-456-7890", "email": "john.doe@gmail.com"}
{"first_name": "John", "last_name": "Doe", "age": 34, "height": 178.0, "weight": 75.0, "phone_number": "(123)-456-7890", "email": "john.doe@gmail.com"}
```
