package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "country")
public class CountryEntity implements Serializable {

    @Id
    private String countryCode;
    @Column
    private String countryName;
}
