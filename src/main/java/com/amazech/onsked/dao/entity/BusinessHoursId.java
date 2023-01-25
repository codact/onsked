package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Data
@Embeddable
public class BusinessHoursId implements Serializable {

    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer bizId;
    private Integer dayOfWeek;
}
