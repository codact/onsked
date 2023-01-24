package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Holiday implements Serializable {
    private String countryCode;
    private String holidayDt;
    private String holidayDtAsYYYYMMDD;
    private String holidayReason;
    private String isActive;
    private Date createdDt;
    private Integer createdBy;
    private Date modifiedDt;
    private Integer modifiedBy;
    private String formattedDt;
}
