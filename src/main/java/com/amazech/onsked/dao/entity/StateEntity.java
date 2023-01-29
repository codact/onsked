package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name="state")
public class StateEntity implements Serializable {

    @Id
    @EmbeddedId
    StateId stateId;
    @Column
    String stateName;
}
