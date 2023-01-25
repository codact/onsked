package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CourseSchedule implements Serializable {

	private static final long serialVersionUID = 2846045710998412813L;
	
	private Integer courseScheduleId;
	private String courseScheduleName;
	private Integer courseMasterId;
	private CourseMaster courseMaster = new CourseMaster();
	private Integer maxParticipants;
	private Integer enrolledParticipants;
	private String startDateTime;
	private String endDateTime;
	private Integer totalNoOfSessions;
	private Integer totalSessionsCompleted;
	private String isActive;
	private String isPublished;
	private String isCompleted;
	private String createdDt;
	private Integer createdBy;
	private String modifiedDt;
	private Integer modifiedBy;
	private Integer isEnrolled;
	private String buttonClicked;
	
//	private List<CourseScheduleComponent> courseScheduleComponentList = ListUtils.lazyList(new ArrayList<CourseScheduleComponent>(), FactoryUtils.instantiateFactory(CourseScheduleComponent.class));


}
