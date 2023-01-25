package com.amazech.onsked.domain;
import lombok.Data;

import org.springframework.web.multipart.MultipartFile;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class Promotion implements Serializable {
	
	private static final long serialVersionUID = 1199774641913761080L;
	private String bizId;	
	private Integer promotionId;
	private String promotionName;
	private String promotionCode;
	private String description;
	private String locId;
	private String svcId;
	private String packageId;
	private String isActive;
	private String startDate;
	private String startDateAsYYYYMMDD;
	private String endDateAsYYYYMMDD;
	private String endDate;
	private Integer promotionType;
	private MultipartFile file;
	private String bizName;
	private String discountType;
	private String discountValue;
	private String allowedUsage;
	private String userUsage;
	private String currentUsage;
	private String service;
	private String createdBy;
	private String createdDt;
	private String modifiedBy;
	private String modifiedDt;
	private String remainderDate;
	private String isPublished;
	private String mailDate;
	private Integer apptCount;
	private String apptCountCompleted;
	private String apptCountConfirmed;
	private String apptCountCancelled;
	private String apptCountCompletedAwaitingPin;
	private String apptCountCompletedWithPin;
	private String apptCountDidnotCome;
	private String apptCountPending;
	private String apptCountCancelledByBusiness;
	private Integer apptValue;
	

	// Details of 'Location'
	private String locName;
	
	// Details of 'Service'
	private String serviceName;
	
	// Details of 'Package'
	private String packageName;

}