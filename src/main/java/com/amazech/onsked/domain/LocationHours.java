package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

@Data
public class LocationHours implements Serializable {
	private static final long serialVersionUID = -1925113716198170697L;
	private Integer locId;
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
	private String dayOfWeekInWords;
	private String actualDt;
	private String timeZoneCode;
	private Float lat;
	private Float lng;
	private String apptGranularity;

}