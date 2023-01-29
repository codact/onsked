package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Data
@Embeddable
public class StateId implements Serializable {

    String country_code;
    String state_code;
}
