package com.example;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by Amarendra Kumar on 11/21/2016.
 */
public class KafkaProducerTest {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG , "localhost:9092,localhost:9093,localhost:9094");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG , "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG , "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> kafkaProducer = new KafkaProducer(properties);

        System.out.println(kafkaProducer.metrics());

        for(int i=0;i<150;i++){
            kafkaProducer.send(new ProducerRecord("my-topics","Key-"+Integer.toString(i),"Value-"+Integer.toString(i)));
        }
        kafkaProducer.close();
    }

}
