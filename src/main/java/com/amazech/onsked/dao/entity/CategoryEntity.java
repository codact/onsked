package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity(name="category")
public class CategoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer categoryCode;
    @Column
    private String categoryName;
    @Column
    private String details;
    @Column
    private String resourceTitle;
    @Column
    private String resourceTitlePlural;
    @Column
    private String receiverTitle;
    @Column
    private String receiverTitlePlural;
    @Column
    private String isActive;
}
