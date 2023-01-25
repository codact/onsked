package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="business_holiday")
public class BusinessHoliday implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer holidayId;
    @Column(name="biz_id")
    private Integer bizId;
    @Column(name="loc_id")
    private Integer locId;
    @Column(name="holiday_dt")
    private Date holidayDt;
    @Column(name="reason")
    private String reason;
    @Column(name="created_dt")
    private Date createdDt;
    @Column(name="created_by")
    private Integer createdBy;
    @Column(name="modified_dt")
    private Date modifiedDt;
    @Column(name="modified_by")
    private Integer modifiedBy;
}
