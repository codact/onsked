package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class CourseMasterWeekday implements Serializable {

	private static final long serialVersionUID = 7415907604451469638L;

	private Integer courseMasterWeekdayId;
	private Integer courseMasterId;
	private Integer weekday;
	private String weekdayName;
	

}
