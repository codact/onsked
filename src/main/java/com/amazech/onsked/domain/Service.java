package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Service implements Serializable {
	private static final long serialVersionUID = 2582863838867046114L;
	private Integer locSvcId;
	private Integer svcId;
	private Integer bizId;
	private Integer serviceCode;
	private String serviceName;  // Data from service_master table
	private String details;
	private String duration;
	private String defaultCost;
	private String isActive;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;
    private String categoryCode;
	List<ServiceMaster> masterServices = null;
	private String categoryName;
	//From packages
	private String packageNames;
	private String locName;

	private Integer locId;
	private String cost;

}