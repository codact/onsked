package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class CurrencyId implements Serializable {

    private String countryCode;
    private String currencyCode;
}
