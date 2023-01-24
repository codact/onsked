package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BusinessHolidayList implements Serializable {
	private static final long serialVersionUID = 2313663245479072264L;

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

	private String addon1;
	private String addon2;

	//From Location class
	private String locName;

}