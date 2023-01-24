package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class CourseMasterMonthdate implements Serializable {

	private static final long serialVersionUID = 7380738562061916364L;

	private Integer courseMasterMonthdateId;
	private Integer courseMasterId;
	private Integer monthdate;
	

}
