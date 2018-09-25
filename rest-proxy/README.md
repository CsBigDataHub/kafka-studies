# REST-Proxy



### Start docker kafka
```
docker-compose up
```

### Connect to kafka
docker run --rm -it -v "$(pwd)":/tutorial --net=host landoop/fast-data-dev bash

### Create topics
```
kafka-topics --create --zookeeper localhost:2181 --topic rest-binary --replication-factor 1 --partitions 1
kafka-topics --create --zookeeper localhost:2181 --topic rest-json --replication-factor 1 --partitions 1
kafka-topics --create --zookeeper localhost:2181 --topic rest-avro --replication-factor 1 --partitions 1

```

### Import the rest-proxy-insomnia.json

### Get topic config
![](image.png)

### Producer Binary
- Send binary
![](image2.png)

- Data in topic binary http://localhost:3030/kafka-topics-ui/#/cluster/fast-data-dev/topic/n/rest-binary/
![](image3.png)

### Consumer binary
- Create consumer
![](image4.png)

- Subscribe
![](image5.png)

- Consume
![](image6.png)

- Consume offset
![](image7.png)


### Producer JSON

- Send JSON
![](image8.png)

- Data in topic binary http://localhost:3030/kafka-topics-ui/#/cluster/fast-data-dev/topic/n/rest-json/
![](image9.png)

### Consumer JSON

- Create consumer
![](image10.png)

- Subscribe
![](image11.png)

- Consume
![](image12.png)


- Consume offset
![](image13.png)


### Producer Avro

- Send Avro
![](image14.png)

- Send Avro Schema ID
![](image15.png)

- Data in topic binary http://localhost:3030/kafka-topics-ui/#/cluster/fast-data-dev/topic/n/rest-avro/
![](image16.png)

- Schema Registry
![](image17.png)

### Consumer Avro

```

$ docker run --rm -it -v "$(pwd)":/tutorial --net=host landoop/fast-data-dev bash

root@fast-data-dev / $ kafka-avro-console-consumer --bootstrap-server 127.0.0.1:9092 --property schema.registry.url=http://127.0.0.1:8081 --topic rest-avro --from-beginning
{"name":"testUser","age":null}
{"name":"testUser","age":{"int":25}}
{"name":"new user","age":null}
{"name":"another user","age":{"int":30}}

```

- Create consumer
![](image18.png)

- Subscribe
![](image19.png)

- Consume
![](image20.png)

- Consume offset
![](image21.png)
