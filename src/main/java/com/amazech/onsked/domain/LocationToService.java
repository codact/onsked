package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LocationToService implements Serializable {
	private static final long serialVersionUID = -8980210185556859853L;
	private Integer locSvcId;
	private Integer locId;
	private Integer svcId;
	private String cost;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;
	private String locId1;
	// From service table
	private Integer bizId;
	private String duration; 
	private Integer resId;
	private String serviceName;
	private String locName;
	private String resourceName;
	
	// for package table
	private String packageName;
	private String clientLocation;
	private Boolean clientLocationFlag;
	
	//for promotion table
	private String promotionName;

}