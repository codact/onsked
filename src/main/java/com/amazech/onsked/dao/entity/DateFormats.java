package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "date_formats")
public class DateFormats implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer dtFormatId;
    @Column
    private String dtFormat;
}
