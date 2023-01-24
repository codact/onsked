package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class BusinessUserId implements Serializable {

    private Integer bizId;
    private Integer userId;
}
