package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="business")
public class BusinessEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="biz_id")
    private Integer bizId;
    @Column(name="biz_name")
    private String bizName;
    @Column(name="category_code")
    private Integer categoryCode;
    @Column(name="contact_first_name")
    private String contactFirstName;
    @Column(name="contact_last_name")
    private String contactLastName;
    @Column(name="contact_email")
    private String contactEmail;
    @Column(name="contact_phone")
    private String contactPhone;
    @Column(name="website")
    private String website;
    @Column(name="is_active")
    private String isActive;
    @Column(name="reservation_lead_time")
    private Integer reservationLeadTime;
    @Column(name="cancellation_lead_time")
    private Integer cancellationLeadTime;
    @Column(name="created_dt")
    private Date createdDt;
    @Column(name="created_by")
    private Integer createdBy;
    @Column(name="modified_dt")
    private Date modifiedDt;
    @Column(name="modified_by")
    private Integer modifiedBy;
    @Column(name="description")
    private String description;
    @Column(name="is_searchable")
    private String isSearchable;
    @Column(name="dt_format_id")
    private Integer dtFormatId;
    @Column(name="allow_unregistered_users")
    private String allowUnregisteredUsers;
    @Column(name="is_deleted")
    private String isDeleted;
    @Column(name="notify_by_email")
    private String notifyByEmail;
    @Column(name="notify_by_sms")
    private String notifyBySms;
}
