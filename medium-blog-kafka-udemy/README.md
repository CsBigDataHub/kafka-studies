# Medium Blog Kafka Udemy
This is the source code supporting the blog post:

<https://medium.com/@stephane.maarek/how-to-use-apache-kafka-to-transform-a-batch-pipeline-into-a-real-time-one-831b48a6ad85>

# Building 

All the instructions are in [run.sh](run.sh)
```bash
# Download Confluent Platform 3.3.0 https://www.confluent.io/download/
# Unzip and add confluent-3.3.0/bin to your PATH

# Download and install Docker for Mac / Windows / Linux and do
docker-compose up -d
# Alternatively start postgres manually on your laptop at port 5432 and username/password = postgres/postgres

# Start the Confluent platform using the Confluent CLI
confluent start
```

![](image.png)


```bash
# Create all the topics we're going to use for this demo
./kafka-topics --create --topic udemy-reviews --partitions 3 --replication-factor 1 --zookeeper localhost:2181
./kafka-topics --create --topic udemy-reviews-valid --partitions 3 --replication-factor 1 --zookeeper localhost:2181
./kafka-topics --create --topic udemy-reviews-fraud --partitions 3 --replication-factor 1 --zookeeper localhost:2181
./kafka-topics --create --topic long-term-stats --partitions 3 --replication-factor 1 --zookeeper localhost:2181
./kafka-topics --create --topic recent-stats --partitions 3 --replication-factor 1 --zookeeper localhost:2181


#show all topics
$ ./kafka-topics --list --zookeeper localhost:2181
__confluent.support.metrics
__consumer_offsets
_confluent-ksql-default__command_topic
_schemas
connect-configs
connect-offsets
connect-statuses
long-term-stats
recent-stats
udemy-reviews
udemy-reviews-fraud
udemy-reviews-valid


# Build and package the different project components (make sure you have maven installed)
mvn clean package
```

```bash
# consumer
$  ./kafka-avro-console-consumer --topic udemy-reviews --bootstrap-server localhost:9092

```


# Running
All the instructions are in [run.sh](run.sh)
Sample instructions:
```bash
export COURSE_ID=1075642  # Kafka for Beginners Course
java -jar udemy-reviews-producer/target/uber-udemy-reviews-producer-1.0-SNAPSHOT.jar

[2018-09-15 20:03:30,681] INFO Sending review 4245: {"id": 20807698, "title": "", "content": "", "rating": "5.0", "created": 2018-09-15T07:39:00.000Z, "modified": 2018-09-15T16:01:46.000Z, "user": {"id": 0, "title": "Vijay Bhasker", "name": "Vijay", "display_name": "Vijay Bhasker"}, "course": {"id": 1075642, "title": "Apache Kafka Series - Learn Apache Kafka for Beginners v2", "url": "/apache-kafka/"}} (ReviewsAvroProducerThread)
[2018-09-15 20:03:30,733] INFO Closing Producer (ReviewsAvroProducerThread)
[2018-09-15 20:03:30,737] INFO Closing the Kafka producer with timeoutMillis = 9223372036854775807 ms. (org.apache.kafka.clients.producer.KafkaProducer)
[2018-09-15 20:03:30,751] INFO Threads completed (ReviewsProducerMain)
[2018-09-15 20:03:30,751] INFO Shutting down (ReviewsProducerMain)
[2018-09-15 20:03:30,752] INFO Application closed succesfully (ReviewsProducerMain)
MacBook-Air-de-David:medium-blog-kafka-udemy davidpetro$ 

```

# Step 2: Kafka Streams - Fraud Detector

```bash
# New terminal: Start an avro consumer on our valid reviews topic
./kafka-avro-console-consumer --topic udemy-reviews-valid --bootstrap-server localhost:9092
# New terminal: Start an avro consumer on our fraud reviews topic
./kafka-avro-console-consumer --topic udemy-reviews-fraud --bootstrap-server localhost:9092

java -jar udemy-reviews-fraud/target/uber-udemy-reviews-fraud-1.0-SNAPSHOT.jar

```

# Step 3: Kafka Streams - Reviews Aggregator
```bash
# New terminal: Start an avro consumer on our recent stats topic
./kafka-avro-console-consumer --topic recent-stats --bootstrap-server localhost:9092

# New terminal: Start an avro consumer on our long term stats topic
./kafka-avro-console-consumer --topic long-term-stats --bootstrap-server localhost:9092

# Launch our review aggregator app
java -jar udemy-reviews-aggregator/target/uber-udemy-reviews-aggregator-1.0-SNAPSHOT.jar

```

# Step 4: Kafka Connect
```bash
# Load the recent and long term stats into Postgres using Kafka Connect Sink!
$ /Users/davidpetro/Documents/confluent-5.0.0/bin/confluent load SinkTopics -d kafka-connectors/SinkTopicsInPostgres.properties
This CLI is intended for development only, not for production
https://docs.confluent.io/current/cli/index.html

{"name":"SinkTopics","config":{"connector.class":"io.confluent.connect.jdbc.JdbcSinkConnector","tasks.max":"3","connection.url":"jdbc:postgresql://localhost:5432/postgres","connection.user":"postgres","connection.password":"postgres","insert.mode":"upsert","pk.mode":"record_value","pk.fields":"course_id","auto.create":"true","topics":"recent-stats,long-term-stats","key.converter":"org.apache.kafka.connect.storage.StringConverter","name":"SinkTopics"},"tasks":[],"type":null}


```

# Video Tutorial:
[![Udemy Kafka End To End Video (medium blog)](https://img.youtube.com/vi/h5i94umfzMM/0.jpg)](https://www.youtube.com/watch?v=h5i94umfzMM)

# Learning Kafka

If you want to explore all that Kafka has to offer, you can learn Kafka with my Udemy courses:
- [Kafka for Beginners](http://bit.ly/kafka-beginners-medium)
- [Kafka Connect](http://bit.ly/kafka-connect-medium)
- [Kafka Streams](http://bit.ly/kafka-streams-medium)
- [Kafka Setup and Administration](http://bit.ly/kafka-cluster-medium)
- [Confluent Schema Registry & REST Proxy](http://bit.ly/confluent-schema-registry-medium)
- [Kafka Security](http://bit.ly/kafka-security-medium)

