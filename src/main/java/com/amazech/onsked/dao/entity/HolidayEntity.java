package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "holiday")
public class HolidayEntity implements Serializable {

    @Id
    String countryCode;
    @Column
    Date holidayDt;
    @Column
    String holidayReason;
    @Column
    String isActive;
    @Column
    Date createdDt;
    @Column
    Integer createdBy;
    @Column
    Date modifiedDt;
    @Column
    Integer modifiedBy;
}
