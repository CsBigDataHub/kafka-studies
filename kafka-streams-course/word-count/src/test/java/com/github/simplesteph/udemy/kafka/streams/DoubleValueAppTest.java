package com.github.simplesteph.udemy.kafka.streams;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.DoubleDeserializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.TopologyTestDriver;
import org.apache.kafka.streams.test.ConsumerRecordFactory;
import org.apache.kafka.streams.test.OutputVerifier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

public class DoubleValueAppTest {
    TopologyTestDriver testDriver;

    StringSerializer stringSerializer = new StringSerializer();

    ConsumerRecordFactory<String, String> recordFactory =
            new ConsumerRecordFactory<>(stringSerializer, stringSerializer);

    @Before
    public void setUpTopologyTestDriver(){
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "test2");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:1234");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        DoubleValueApp doubleValueApp = new DoubleValueApp();
        Topology topology = doubleValueApp.createTopology();
        testDriver = new TopologyTestDriver(topology, config);
    }

    @After
    public void closeTestDriver(){
        testDriver.close();
    }

    private void pushNewInputRecord(String key, String value){
        testDriver.pipeInput(recordFactory.create("app-double-input", key, value));
    }

    private ProducerRecord<String, Double> readOutput(){
        return testDriver.readOutput("app-double-output", new StringDeserializer(), new DoubleDeserializer());
    }

    @Test
    public void makeSureDoubleValueAreCorrect() {
        pushNewInputRecord("david", "256.00");
        pushNewInputRecord("lian", "4.0");
        pushNewInputRecord("aline", "16.0");

        OutputVerifier.compareKeyValue(readOutput(), "david", 65536.00);
        OutputVerifier.compareKeyValue(readOutput(), "lian", 16.00);
        OutputVerifier.compareKeyValue(readOutput(), "aline", 256.00);
    }
}