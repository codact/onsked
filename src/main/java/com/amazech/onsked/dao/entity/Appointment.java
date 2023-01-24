package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name="appointment")
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer apptId;

    @Column(name="biz_id")
    private Integer bizId;

    @Column(name="loc_id")
    private Integer locId;
    @Column(name="svc_id")
    private String svcId;
    @Column(name="res_id")
    private Integer resId;
    @Column(name="start_time")
    private String startTime;
    @Column(name="end_time")
    private String endTime;
    @Column(name="status_code")
    private String statusCode;
    @Column(name="status_reason_code")
    private String statusReasonCode;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="client_id")
    private Integer clientId;
    @Column(name="created_dt")
    private String createdDt;
    @Column(name="created_by")
    private Integer createdBy;
    @Column(name="modified_dt")
    private String modifiedDt;
    @Column(name="modified_by")
    private Integer modifiedBy;

    @Column(name="is_active")
    private String isActive;
    @Column(name="reject_reason")
    private String rejectReason;

    @Column(name="is_synchronized")
    private String isSynchronized;
}
