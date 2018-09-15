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

### Send binary
![](image2.png)

### Data in topic binary

- http://localhost:3030/kafka-topics-ui/#/cluster/fast-data-dev/topic/n/rest-binary/

![](image3.png)

### Consumer binary
- Create consumer
![](image4.png)

- Subscribe
