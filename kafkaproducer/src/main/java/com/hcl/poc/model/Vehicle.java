package com.hcl.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicle {

	private String vehicletype;
	private String enginenumber;
	private int vehicleid;
	private String vehiclenumber;
	private String registeredcity;
	private String tagtype;
	private int vehicleseqnumber;
	private int vehiclespeed;
	private long txntime;
	private String tollplazaid;
	private String taginstitution;
	private String tagnumber;
	private String tagstatus;
	private int laneid;
	private String accountstatus;
	private String fileurl;
}
