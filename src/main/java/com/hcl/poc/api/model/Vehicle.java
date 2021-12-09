package com.hcl.poc.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(value = "vehicleinfo")
public class Vehicle {

    @PrimaryKey
    private UUID uuid;

    @Column(value = "vehicletype")
    private String vehicleType;

    @Column(value = "enginenumber")
    private String engineNumber;

    @Column(value = "vehicleid")
    private int vehicleId;

    @Column(value = "vehiclenumber")
    private String vehicleNumber;

    @Column(value = "registeredcity")
    private String registeredCity;

    @Column(value = "tagtype")
    private String tagType;

    @Column(value = "vehicleseqnumber")
    private int vehicleSeqNumber;

    @Column(value = "vehiclespeed")
    private int vehicleSpeed;

    @Column(value = "txntime")
    private Date txnTime;

    @Column(value = "tollplazaid")
    private String tollPlazaId;

    @Column(value = "taginstitution")
    private String tagInstitution;

    @Column(value = "tagnumber")
    private String tagNumber;

    @Column(value = "tagstatus")
    private String tagStatus;

    @Column(value = "laneid")
    private int laneId;

    @Column(value = "accountstatus")
    private String accountStatus;

    @Column(value = "fileUrl")
    private String fileurl;
}
