package com.hcl.poc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.poc.model.APIStatus;
import com.hcl.poc.model.Vehicle;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Value;


@RestController
public class VehicleRestController {


    @Autowired
    private KafkaTemplate<String, Vehicle> kafkaTemplate;

    @Value(value = "${topic.name}")
    private  String TOPIC;


    @RequestMapping("/poc")
    public APIStatus post(@RequestBody Vehicle vehicleInput)
    {
    	
        kafkaTemplate.send(
                TOPIC,vehicleInput);
            

        return new APIStatus("success");
    }

}
