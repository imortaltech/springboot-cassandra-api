package com.hcl.poc.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AggVehicle {
    @JsonProperty("vehicletype")
    private String vehicleType;
    @JsonProperty("enginenumber")
    private String engineNumber;
    private Window window;
    @JsonProperty("count(vehicleid)")
    private String count;

}
