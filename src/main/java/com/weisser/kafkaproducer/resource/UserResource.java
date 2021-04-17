package com.weisser.kafkaproducer.resource;

import com.weisser.kafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

    @PostMapping("/publish")
    public String post(@RequestBody User user) {

        kafkaTemplate.send(TOPIC, user);

        return "Published successfully";
    }
}

