package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class CourseParticipant implements Serializable {

	private static final long serialVersionUID = 7758174645079060215L;
	
	private Integer courseParticipantId;
	private Integer courseScheduleId;
	private Integer clientId;
	private String clientFirstName;
	private String clientLastName;
	private String clientEmail;
	private String clientCellPhone;
	private String isActive;
	private String createdDt;
	private String createdBy;
	private String modifiedDt;
	private String modifiedBy;
	

}
