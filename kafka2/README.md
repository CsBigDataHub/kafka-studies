
1 - docker-compose up kafka-cluster

2 - docker run --rm -it -v "$(pwd)":/tutorial --net=host landoop/fast-data-dev bash

````

root@fast-data-dev / $ ls -l tutorial/
total 12
-rw-r--r-- 1 root root    0 Aug 19 17:22 README.md
-rw-r--r-- 1 root root 1278 Aug 18 22:12 docker-compose.yml
-rw-r--r-- 1 root root 1633 Apr  9  2017 kafka-connect-tutorial-sinks.sh
-rw-r--r-- 1 root root 3468 Apr 18  2017 kafka-connect-tutorial-sources.sh
drwxr-xr-x 5 root root  160 Aug 18 21:24 setup
drwxr-xr-x 7 root root  224 Aug 18 21:24 sink
drwxr-xr-x 6 root root  192 Aug 18 21:24 source

````

# create the topic we write to with 3 partitions

- Toolbox
kafka-topics --create --topic demo-1-standalone --partitions 3 --replication-factor 1 --zookeeper 192.168.99.100:2181

kafka-topics --create --topic demo-2-standalone --partitions 3 --replication-factor 1 --zookeeper 127.0.0.1:2181

4 - go to demo
cd /tutorial/source/demo-1


# 5 Usage is connect-standalone worker.properties connector1.properties [connector2.properties connector3.properties]
connect-standalone worker.properties file-stream-demo-standalone.properties

# example 2

docker run --rm -it --net=host landoop/fast-data-dev bash
kafka-topics --create --topic demo-2-distributed --partitions 3 --replication-factor 1 --zookeeper 192.168.99.100:2181

kafka-topics --create --topic demo-2-distributed --partitions 3 --replication-factor 1 --zookeeper 127.0.0.1:2181

127.0.0.1:2181

kafka-topics --create --topic demo-2-distributed --partitions 3 --replication-factor 1 --zookeeper 127.0.0.1:2181