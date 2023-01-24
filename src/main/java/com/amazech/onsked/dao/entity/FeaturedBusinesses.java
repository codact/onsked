package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "featured_businesses")
public class FeaturedBusinesses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bizId;
    @Column
    private Integer createdBy;
    @Column
    private Date createdDt;
    @Column
    private String isActive;
}
