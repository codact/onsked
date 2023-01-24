package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Package implements Serializable {
	private static final long serialVersionUID = 801708783663451643L;
	private Integer locSvcId;
//	private List<RenderDefinition> renderDefList ;
	private String locSvcId1;
	private int locCount;
	private Integer locId;
	private Integer svcId;
	private String serviceName;
	private String locName;
	private String duration1; 
	private String cost1;
	private String packageName1;
	private String duration2; 
	private String cost2;
	private String packageName2;
	private String duration3; 
	private String cost3;
	private String packageName3;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;
	private Integer pack;
	private Integer pkgId;
	private String duration;
	private String durationInHrs;
	private String durationInMins;
	private String cost;
	private String packageName;
	private String clientLocation;
	private Boolean clientLocationFlag;
	private Integer packageId;
	private String delete;
	private String bizName;
	private Integer apptCount;
	private Integer apptCountCompleted;
	private String nickName;
	private String granularity;
	private String workingHours;
	private String sessionType;
	private String multiSessDurInHrs;
	private String multiSessDurInMins;	
	private String payoutType;	
	private String maxPayoutFactor;	
	private String effectiveFrom;	
	private String effectiveUpto;

	
}