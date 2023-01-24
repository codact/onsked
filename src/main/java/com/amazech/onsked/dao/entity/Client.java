package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer clientId;
    @Column
    private Integer bizId;
    @Column
    private String email;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String gender;
    @Column
    private Date dateOfBirth;
    @Column
    private String addressLine1;
    @Column
    private String addressLine2;
    @Column
    private String city;
    @Column
    private String stateCode;
    @Column
    private String zipCode;
    @Column
    private String countryCode;
    @Column
    private String cellPhone;
    @Column
    private String homePhone;
    @Column
    private String workPhone;
    @Column
    private String workPhoneExt;
    @Column
    private String isActive;
    @Column
    private Date createdDt;
    @Column
    private Integer createdBy;
    @Column
    private Date modifiedDt;
    @Column
    private Integer modifiedBy;
}
