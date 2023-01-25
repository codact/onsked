package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResourceHours implements Serializable {
	private static final long serialVersionUID = 7566175277644621573L;
	private Integer resId;
	private String dayOfWeek;
	private String isOpen;
	private Integer locId;
	private String openTime;
	private String openTimeMin;
	private String openTimeAmPm;
	private String closeTime;
	private String closeTimeMin;
	private String closeTimeAmPm;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;
	private String dayOfWeekInWords;
	
	//From Resource Working Hours
	private String resHrOvrFlw;
	private Integer resHrOvrFlwUpto;
	
	private String firstName;
	private String lastName;
	private String nickName;

}