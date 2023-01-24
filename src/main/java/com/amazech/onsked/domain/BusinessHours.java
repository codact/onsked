package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
@Data
public class BusinessHours implements Serializable {
	private static final long serialVersionUID = -1925113716198170697L;
	private Integer bizId;
	private String dayOfWeek;
	private String isOpen;
	private String openTime;
	private String openTimeMin;
	private String openTimeAmPm;
	private String closeTime;
	private String closeTimeMin;
	private String closeTimeAmPm;
	private String createdDt;
	private Integer createdBy;
	private String modifiedDt;
	private Integer modifiedBy;
	private Integer day;
	private String dayOfWeekInWords;
	private String actualDt; 
	DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	DateFormat df = new SimpleDateFormat("yyyy mm dd hh:mm:ss");

}