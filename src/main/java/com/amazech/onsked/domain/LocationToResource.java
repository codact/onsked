package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LocationToResource implements Serializable {
	private static final long serialVersionUID = -3781157928710501102L;
	private Integer locId;
	private Integer resId;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;
	private String isActive;

}