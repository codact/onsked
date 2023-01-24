package com.amazech.onsked.domain;

import lombok.Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CourseMaster implements Serializable{

	private static final long serialVersionUID = -7404675949992994050L;
	
	private Integer courseMasterId;
	private String courseMasterName;
	private Integer bizId;
	private String bizName;
	private String courseSchedulingType;
	private String courseSchedulingTypeName;
	private Integer onceInNDays;
	private String monthlySchedulingUnit;
	private String isActive;
	private String createdDt;
	private Integer createdBy;
	private String modifiedDt;
	private Integer modifiedBy;
	
//	private List<CourseMasterComponent> courseMasterComponentList = ListUtils.lazyList(new ArrayList<CourseMasterComponent>(), FactoryUtils.instantiateFactory(CourseMasterComponent.class));
//	private List<CourseMasterMonthdate> courseMasterMonthdateList = ListUtils.lazyList(new ArrayList<CourseMasterMonthdate>(), FactoryUtils.instantiateFactory(CourseMasterMonthdate.class));
//	private List<CourseMasterMonthday> courseMasterMonthdayList = ListUtils.lazyList(new ArrayList<CourseMasterMonthday>(), FactoryUtils.instantiateFactory(CourseMasterMonthday.class));
//	private List<CourseMasterWeekday> courseMasterWeekdayList = ListUtils.lazyList(new ArrayList<CourseMasterWeekday>(), FactoryUtils.instantiateFactory(CourseMasterWeekday.class));


}
