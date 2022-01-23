package com.hcl.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionBody {
    int VehicleSequenceNo;
    int Straddling;
    int Speed;
    int TagIagClass;
    int AviAxle;
    int AviStraddling;
    String TagInstitution;
    int TagNumber;
    String TagStatus;
    String AccountStatus;
    int Title21TagType;
    String TagSwitchPosition;
    String ImageTaken;
    int ActualClass;
    int ActualAxle;
    String PayType;
}
