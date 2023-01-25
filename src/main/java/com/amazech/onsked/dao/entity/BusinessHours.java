package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="business_hours")
public class BusinessHours implements Serializable {

    @EmbeddedId
    private BusinessHoursId businessHoursId;
    @Column(name="is_open")
    private Integer isOpen;
    @Column(name="open_time")
    private String openTime;
    @Column(name="close_time")
    private String closeTime;
    @Column(name="created_dt")
    private Date createdDt;
    @Column(name="created_by")
    private Integer createdBy;
    @Column(name="modified_dt")
    private Date modifiedDt;
    @Column(name="modified_by")
    private Integer modifiedBy;
}
