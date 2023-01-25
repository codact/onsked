package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class CourseMasterMonthday implements Serializable {

	private static final long serialVersionUID = -705001285719806762L;

	private Integer courseMasterMonthdayId;
	private Integer courseMasterId;
	private Integer weekNo;
	private Integer weekday;
	private String weekdayName;

}
