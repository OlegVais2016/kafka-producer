package com.weisser.kafkaproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Taxi {

    private Long id;
    private double lat;
    private double lng;
}
