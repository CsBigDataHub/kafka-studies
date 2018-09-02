# favourite-colour-java


### start zookeeper

```
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

### start kafka-server

```
$ bin/kafka-server-start.sh config/server.properties
```

### create input topic with one partition to get full ordering
```
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic favourite-colour-input
```

### create intermediary log compacted topic
```
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic user-keys-and-colours --config cleanup.policy=compact
```

### create output log compacted topic
```
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic favourite-colour-output --config cleanup.policy=compact
```

### List topic
```
 bin/kafka-topics.sh --list --zookeeper localhost:2181
favourite-colour-input
favourite-colour-output
user-keys-and-colours

``` 

### run FavouriteColourApp.java


# launch a Kafka consumer
``` 
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
    --topic favourite-colour-output \
    --from-beginning \
    --formatter kafka.tools.DefaultMessageFormatter \
    --property print.key=true \
    --property print.value=true \
    --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer \
    --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
``` 

# then produce data to it
```
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic favourite-colour-input
```

### Put values in producers : 

```
>david,blue 
aline,red
>john,green
>alice,red
>
```


### Consumer result

```
blue	1
red	1
green	1
red	2
```

### List topic
```
bin/kafka-topics.sh --list --zookeeper localhost:2181
__consumer_offsets
favourite-colour-input
favourite-colour-java-CountsByColours-changelog
favourite-colour-java-CountsByColours-repartition
favourite-colour-output
user-keys-and-colours
```