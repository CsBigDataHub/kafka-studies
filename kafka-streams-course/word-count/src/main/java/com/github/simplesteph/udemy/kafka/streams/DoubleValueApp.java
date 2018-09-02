package com.github.simplesteph.udemy.kafka.streams;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.ForeachAction;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;


public class DoubleValueApp {

    public Topology createTopology(){
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> textLines2 = builder.stream("app-double-input");
        textLines2.peek(printPeek())
                .mapValues(textLine -> Double.valueOf(textLine) * Double.valueOf(textLine))
                .peek(printPeek())
                .to("app-double-output", Produced.with(Serdes.String(), Serdes.Double()));
        return builder.build();
    }

    private ForeachAction<Object, Object> printPeek() {
        return (key, value)-> System.out.println("print my key : ".concat(String.valueOf(key))
                .concat("print my value : ")
                .concat(String.valueOf(value)));
    }

    public static void main(String[] args) {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "appdouble-application");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        DoubleValueApp wordCountApp = new DoubleValueApp();

        KafkaStreams streams = new KafkaStreams(wordCountApp.createTopology(), config);
        streams.start();

        // shutdown hook to correctly close the streams application
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

        // Update:
        // print the topology every 10 seconds for learning purposes
        while(true){
            streams.localThreadsMetadata().forEach(data -> System.out.println(data));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}