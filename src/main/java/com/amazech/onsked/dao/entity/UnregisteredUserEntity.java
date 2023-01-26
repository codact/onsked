package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name="unregistered_user_master")
public class UnregisteredUserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String dateOfBirthAsYYYYMMDD;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String stateCode;
    private String zipCode;
    private String countryCode;
    private String timeZoneCode;
    private String timezone;
    private String cellPhone;
    private String homePhone;

    private int unregId;

}