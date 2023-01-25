package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class BusinessHoliday implements Serializable {
	private static final long serialVersionUID = -3837948809131379467L;
	private Integer holidayId;
	private Integer bizId;
	private Integer locId;
	private String dateOfHoliday;
	private String dateOfHolidayAsYYYYMMDD;
	private String reason;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;
	private String formattedDt;
	private String locId1;
	//From Location class
	private String locName;

}