package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class AppointmentStatus implements Serializable {

    private static final long serialVersionUID = -8430634775877864225L;

    private String statusCode;
    private String statusDescription;
    private String statusReasonCode;
    private String statusReasonDescription;
    private String isActive;
}
