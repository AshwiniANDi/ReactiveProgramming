package com.ash.kafka_demo.rest;

import com.ash.kafka_demo.payload.Student;
import com.ash.kafka_demo.producer.KafkaJsonProducer;
import com.ash.kafka_demo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessages(@RequestBody String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessages(@RequestBody Student message){
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Json Message sent successfully");
    }
}
