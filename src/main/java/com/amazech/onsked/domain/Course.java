package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	private String courseId;
	private String courseName;
	private String pkgName;
	private String pkgId;
	private String clientId;
	private String userId;
	private String unregId;
	private String courseType;
	private String clientType;
	private String recurringType;
	private String clientNo;
	private String numberOfDays;
	private String createdDt;
	private Integer createdBy;
	private String modifiedDt;
	private Integer modifiedBy;
	private Integer svcId;
	private String locId;
	private String bizId;
	private String resId;
	private String occurances;
	private String startDate;
	private String startTime;
	private String date;
	private String time;
	private String endDate;
	private String MaxClients;
	private String bizName;
	private String locName;
	private String stateCode;
	private String nickName;
	private String resName;
	private String email;
	private String udf1;
	private String udf2;
	private String udf3;
	private String udf4;
	private String firstName;
	private String lastName;
	private String svcName;
	private String udf5;
	private String time1;
	private String time2;
	private String time3;
	private String time4;
	private String time5;
	private String isActive;
	private String courseDate; 
	private String courseTime; 
	//private List<Course> courserecurrsive = ListUtils.lazyList(new ArrayList<Course>(), FactoryUtils.instantiateFactory(Course.class));
	

}
