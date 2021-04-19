package com.weisser.kafkaproducer.resource;

import com.weisser.kafkaproducer.model.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, Taxi> kafkaTemplate;

    private static final String TOPIC = "Taxi_Location";

    @PostMapping("/publish")
    public String post(@RequestBody Taxi taxi) {

        kafkaTemplate.send(TOPIC, taxi);

        return "Published successfully";
    }
}

