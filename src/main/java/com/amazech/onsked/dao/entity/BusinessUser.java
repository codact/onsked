package com.amazech.onsked.dao.entity;

import lombok.Data;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="business_user")
public class BusinessUser implements Serializable {

    @EmbeddedId
    private BusinessUserId businessUserId;
    @Column(name="created_dt")
    private Date createdDt;
    @Column(name="created_by")
    private Integer createdBy;
    @Column(name="modified_dt")
    private Date modifiedDt;
    @Column(name="modified_by")
    private Integer modifiedBy;
}
