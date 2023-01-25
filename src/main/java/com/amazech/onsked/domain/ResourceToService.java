package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResourceToService implements Serializable {
	private static final long serialVersionUID = 8228547496215472071L;
	private Integer resId;
	private Integer svcId;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;

}