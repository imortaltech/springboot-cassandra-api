package com.hcl.poc.api.controller;

import com.hcl.poc.api.model.AggVehicle;
import com.hcl.poc.api.model.Vehicle;
import com.hcl.poc.api.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleRepository repository;

    @GetMapping("/getAllVehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        List<Vehicle> vehicleList=new ArrayList<>();
        repository.findAll().forEach(vehicleList::add);

        if (vehicleList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("/aggVehicle")
    public ResponseEntity<List<AggVehicle>> consumeAgregateValues(){

        if (jsonMessages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(jsonMessages, HttpStatus.OK);
    }


    List<AggVehicle> jsonMessages=new ArrayList<>();

    @KafkaListener(groupId = "poc", topics = "pocNewTopic",containerFactory = "vehicleKafkaListenerContainerFactory")
    public List<AggVehicle> getAgregatedValuesJson(AggVehicle data){
        System.out.println(data);
        jsonMessages.add(data);
        return jsonMessages;
    }
}
