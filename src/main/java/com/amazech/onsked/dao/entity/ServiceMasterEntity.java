package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "service_master")
public class ServiceMasterEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer serviceCode;
    @Column
    String serviceName;
    @Column
    Integer categoryCode;
    @Column
    String description;
    @Column
    String isActive;
}
