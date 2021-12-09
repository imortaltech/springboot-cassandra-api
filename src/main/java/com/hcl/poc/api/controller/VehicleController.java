package com.hcl.poc.api.controller;

import com.hcl.poc.api.model.Vehicle;
import com.hcl.poc.api.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
