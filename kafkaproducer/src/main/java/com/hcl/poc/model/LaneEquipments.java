package com.hcl.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LaneEquipments {
    private Header header;
    private ErrorMessage errorBody;
}
