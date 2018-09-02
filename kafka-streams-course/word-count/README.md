# word-count

### start zookeeper

```
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```

### start kafka-server

```
$ bin/kafka-server-start.sh config/server.properties
```

### create topic input

```
$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 2 --topic word-count-input
Created topic "word-count-output".

```

### create topic output

```
$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 2 --topic word-count-output
Created topic "word-count-output".

```

### list topics

```
$ bin/kafka-topics.sh --list --zookeeper localhost:2181
word-count-input
word-count-output
```


### run consumer

```

$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
    --topic word-count-output \
    --from-beginning \
    --formatter kafka.tools.DefaultMessageFormatter \
    --property print.key=true \
    --property print.value=true \
    --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer \
    --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
    
```

### run WordCountApp.java


### run producer

```
$ bin/kafka-console-producer.sh --broker-list localhost:9092 --topic word-count-input
hell>^R  
hello world 
>my test
>world again
>hello world my message
>my message is heelo world to day
```


### consumer outuput

```
$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092     --topic word-count-output     --from-beginning     --formatter kafka.tools.DefaultMessageFormatter     --property print.key=true     --property print.value=true     --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer     --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
hello	1
test	1
again	1
my	1
world	2
world	3
my	2
message	1
hello	2
my	3
message	2
is	1
heelo	1
world	4
to	1
day	1


```


### list topics
- Counts it's because "count("Counts")"
- changelog because aggregation "groupByKey"
- repartition because change the key "selectKey((key, word) -> word)"

```

$ bin/kafka-topics.sh --list --zookeeper localhost:2181
word-count-input
word-count-output
wordcount-application-Counts-changelog
wordcount-application-Counts-repartition

```

### consumer wordcount-application-Counts-changelog

```
$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092     --topic wordcount-application-Counts-changelog     --from-beginning     --formatter kafka.tools.DefaultMessageFormatter     --property print.key=true     --property print.value=true     --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer     --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
hello	1
test	1
again	1
hello	2
my	1
world	2
world	3
my	2
message	1
my	3
message	2
is	1
heelo	1
world	4
to	1
day	1

```

### consumer wordcount-application-Counts-repartition
```
$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092     --topic wordcount-application-Counts-repartition     --from-beginning     --formatter kafka.tools.DefaultMessageFormatter     --property print.key=true     --property print.value=true     --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer     --property value.deserializer=org.apache.kafka.common.serialization.StringDeserializer
world	world
my	my
world	world
world	world
my	my
message	message
my	my
message	message
is	is
heelo	heelo`
world	world
to	to
day	day
hello	hello
test	test
again	again
hello	hello

```

-----------------------------------------------------------------------
-----------------------------------------------------------------------


# DoubleValueApp

### create topic input

```
$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 2 --topic app-double-input
Created topic "app-double-output".

```

### create topic output

```
$ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 2 --topic app-double-output
Created topic "app-double-output".

```

### run consumer

```

$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
    --topic app-double-output \
    --from-beginning \
    --formatter kafka.tools.DefaultMessageFormatter \
    --property print.key=true \
    --property print.value=true \
    --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer \
    --property value.deserializer=org.apache.kafka.common.serialization.DoubleDeserializer
   
```

### run producer

```
$ bin/kafka-console-producer.sh --broker-list localhost:9092 --topic app-double-input --property "parse.key=true" --property "key.separator=,"
```

### put this data in producer
```
>david,2.0
>david,10.0
>aline,100.0
```

### consumer
```
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
    --topic app-double-output \
    --from-beginning \
    --formatter kafka.tools.DefaultMessageFormatter \
    --property print.key=true \
    --property print.value=true \
    --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer \
    --property value.deserializer=org.apache.kafka.common.serialization.DoubleDeserializer
david	4.0
david	100.0
aline	10000.0
```