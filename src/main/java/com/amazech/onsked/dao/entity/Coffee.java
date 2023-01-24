package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "coffee")
public class Coffee implements Serializable {

    @Id
    private String colour;
    @Column
    private String brands;
}
