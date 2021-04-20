package com.weisser.kafkaproducer.resource;

import com.weisser.kafkaproducer.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, Trip> kafkaTemplate;

    private static final String TOPIC = "Trips";

    @PostMapping("/publish")
    public String post(@RequestBody Trip trip) {

        kafkaTemplate.send(TOPIC, trip);

        return "Published successfully";
    }
}

