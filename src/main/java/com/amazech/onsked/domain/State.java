package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class State implements Serializable {
    private String countryCode;
    private String stateCode;
    private String stateName;
    private String countryName;
}
