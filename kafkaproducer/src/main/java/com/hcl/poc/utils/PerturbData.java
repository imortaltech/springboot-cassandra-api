package com.hcl.poc.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PerturbData {
	// List of Provinces
	List<String> provinceList=Arrays.asList("Callifornia","Texas","Washington","Florida","Hawai");
	
	// List of Cities
	List<String> cityList=Arrays.asList("New york","san fransisco","Chicago","Los Angeles","Boston");
	
	// List of vehicle type
	List<String> typeList=Arrays.asList("Car","Bus","Truck");
	
	//List of tags
	List<String> tagTypes=Arrays.asList("RFID Passive","RFID programable","Data tag");
	
	// List of Tag institutions
	List<String> tagInstituion=Arrays.asList("Impinj, Inc.","Texas Instruments","NXP USA Inc.");
	
	// Status alternatives
	List<String> statusList=Arrays.asList("Active","Inactive");
}
