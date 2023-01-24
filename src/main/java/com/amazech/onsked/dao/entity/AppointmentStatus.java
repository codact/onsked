package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name="appointment_status")
public class AppointmentStatus implements Serializable {

    @EmbeddedId
    private AppointmentStatusId appointmentStatusId;
    @Column(name="status_description")
    private String statusDescription;
    @Column(name="status_reason_description")
    private String statusReasonDescription;
    @Column(name="is_active")
    private String isActive;
}
