package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResourceLeaveSchedule implements Serializable {
	private static final long serialVersionUID = 5899622616848303473L;
	private Integer resId;
	private String startTime;
	private String endTime;
	private String leaveCode;
	private String reason;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;

}