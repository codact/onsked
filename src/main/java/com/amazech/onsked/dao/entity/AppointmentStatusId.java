package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class AppointmentStatusId implements Serializable {

    private String statusCode;
    private String statusReasonCode;
}
