package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class CourseScheduleAppointment implements Serializable {

	private static final long serialVersionUID = -2038068990962176056L;
	
	private Integer courseScheduleAppointmentId;
	private Integer courseScheduleComponentId;
	private String startDate;
	private String startTime;
	private String endTime;
	private Integer appointmentDuration;
	private String isSlotAvailable;
	private Integer apptId;
	

}
