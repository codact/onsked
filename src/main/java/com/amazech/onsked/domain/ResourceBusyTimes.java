package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class ResourceBusyTimes implements Serializable {
	private static final long serialVersionUID = 6061060768192097195L;
//	@JsonProperty("courseId")
	private String courseId;
	private String apptId;//start_time, end_time, appt_id, user_id, role_code, first_name, service_name, resource_name
	private String start;
	private String end;
	private int blkId;
	//For user details
	private String firstName;
	private String svc;
	private String pkg;
	private String resName;
	private String userId;
	private String userRoleCode;
	private String unregUserId;
	
	private String workStartTime;
	private String workEndTime;
	private String workTime;
	private String clientId;
	private String granularity;
	private String statusDescription;
	private String statusCode;
	private String rejectReason;
	private String cellPhone;
	private String email;
	private String address;
	
	private String clientNo;
	private String attendingClients;
	private Integer repairFormCount;
	private Integer repairFormId;
	private Integer technicianFormId;
	private String displayCounter;
	private String formStatusCode;
	private String clientLocation;
	private String clientAddress;
	private String notifyBySMS;
	private List<ResourceBusyTimes> pendingApptList;
	private Integer pendingApptCount;
	private String pendingApptId;
	private String isFromPendingApptList;
	private String svcId;
	private String pkgId;	
	private String status;
	private String finalStatus;
	private Integer confirmedApptCount;		
	private String apptAddressLine1;	
	private String apptAddressLine2;
	private String apptCity;
	private String apptState;
	private String apptCountry;
	private String apptZipCode;
	private String statusReasonCode;

}