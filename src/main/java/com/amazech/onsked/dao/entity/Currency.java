package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "currency")
public class Currency implements Serializable {

    @EmbeddedId
    private CurrencyId currencyId;
    @Column
    private String currencyName;
    @Column
    private String symbol;

}
