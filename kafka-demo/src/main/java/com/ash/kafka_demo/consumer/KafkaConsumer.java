package com.ash.kafka_demo.consumer;

import com.ash.kafka_demo.payload.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    //@KafkaListener(topics="ashTopic", groupId = "myGroup")
    public void consumeMessage(String message){
    System.out.println("Messages consumed from topic ashTopic are : "+message);
    }

    @KafkaListener(topics="ashTopic", groupId = "myGroup")
    public void consumeJsonMessage(Student student){
        System.out.println("Json Messages consumed from topic ashTopic are : "+student);
    }
}
