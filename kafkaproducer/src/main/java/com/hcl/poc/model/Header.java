package com.hcl.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Header {
    int MessageSequenceNo;
    String PlazaId;
    int LaneId;
    Long TxnTime;
    String LaneMode;
    int RecordType;
    int RecordSubType;
    String LaneState;
    String LaneHealth;
    String IsDSTFlag;
    String EnforcementFlagStatus;

}
