package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Country implements Serializable {
    private String countryCode;
    private String countryName;
}
