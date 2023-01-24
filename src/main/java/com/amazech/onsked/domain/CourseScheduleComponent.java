package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CourseScheduleComponent implements Serializable {

	private static final long serialVersionUID = -618674220431710377L;
	
	private Integer courseScheduleComponentId;
	private Integer courseScheduleId;
	private Integer courseMasterComponentId;
	private Integer resId;
	private String resFirstName;
	private String resLastName;
	private String resNickName;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	private Integer noOfSessions;
	private Integer sessionsCompleted;
	
//	private List<CourseScheduleAppointment> courseScheduleAppointmentList = ListUtils.lazyList(new ArrayList<CourseScheduleAppointment>(), FactoryUtils.instantiateFactory(CourseScheduleAppointment.class));
	

}
