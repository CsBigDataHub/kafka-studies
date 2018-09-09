# schema-registry

### 1
docker-compose up

### 2
docker run --net=host -it confluentinc/cp-schema-registry:3.3.0 bash

### Produce a record with one field
kafka-avro-console-producer \
    --broker-list 127.0.0.1:9092 --topic test-avro \
    --property schema.registry.url=http://127.0.0.1:8081 \
    --property value.schema='{"type":"record","name":"myrecord","fields":[{"name":"f1","type":"string"}]}'

### put somes datas
{"f1": "value1"}
{"f1": "value2"}

![](image.png)

### automatically create topic schema test-avro 
- http://localhost:3030/schema-registry-ui/#/ 

![](image1.png)


### automatically create topic test-avro
- http://localhost:3030/kafka-topics-ui/#/cluster/fast-data-dev/topic/n/test-avro/

![](image2.png)

### put more datas
{"f1": "value3"}

### put a field does not exist
- {"f3": "value4"}

![](image3.png)


### put wrong type
- {"f1": 1}

![](image4.png)


### Consume the records from the beginning of the topic:
kafka-avro-console-consumer --topic test-avro \
    --bootstrap-server 127.0.0.1:9092 \
    --property schema.registry.url=http://127.0.0.1:8081 \
    --from-beginning

![](image5.png)

### Produce some errors with an incompatible schema (we changed to int) - should produce a 409
kafka-avro-console-producer \
    --broker-list localhost:9092 --topic test-avro \
    --property schema.registry.url=http://127.0.0.1:8081 \
    --property value.schema='{"type":"int"}'

![](image6.png)

### Some schema evolution (we add a field f2 as an int with a default)
kafka-avro-console-producer \
    --broker-list localhost:9092 --topic test-avro \
    --property schema.registry.url=http://127.0.0.1:8081 \
    --property value.schema='{"type":"record","name":"myrecord","fields":[{"name":"f1","type":"string"},{"name": "f2", "type": "int", "default": 0}]}'

- put this data
{"f1": "evolution", "f2": 1 }

![](image7.png)

### Consume the records again from the beginning of the topic:
kafka-avro-console-consumer --topic test-avro \
    --bootstrap-server localhost:9092 \
    --from-beginning \
    --property schema.registry.url=http://127.0.0.1:8081

![](image8.png)