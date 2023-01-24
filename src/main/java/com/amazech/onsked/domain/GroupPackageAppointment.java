package com.amazech.onsked.domain;
import lombok.Data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Data
public class GroupPackageAppointment implements Serializable{
	private static final long serialVersionUID = -1925113716198170697L;
	private Integer groupPkgToApptId;
	private String groupPkgId;
	private String pkgId;
	private String userId;
	private String apptId;
	private String groupPkgName;
	private String groupPkgToPkgId;
	private String bizId;
	private String bizName;
	private String locId;
	private String locName;
	private String expiryDt;
	private String expiryDtMilliSec;
	private String startTime;
	private String packageName;
	private String occurences;
	private String statusCode;
	private String discountNumber;
	private String groupPkgTypeId;
	private String groupPkgTypeName;
	

	private Integer groupPkgPurchaseId;
	

}
