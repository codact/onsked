package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class PatientInsurance implements Serializable {
	private static final long serialVersionUID = 2313663245479072264L;
	private Integer patientInsuranceId; 
	private Integer patientId; 
	private String stateCode;
	private String state;
	private String countryCode;
	private String insuranceCompanyName;
	private String policyNumber;
	private String insuranceId;
	private String groupId;
	private String effectiveDate;
	private String effectiveDateYYYYMMdd;
	private String copay;
	private String insCompEmail;
	private String insCompPhone;
	private String expiryDate;
	private String expiryDateYYYYMMdd;
	private String isActive;
	private String addressLine1;
	private String addressLine2;
	private Date verifiedDt;
	private Integer verifiedBy;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;

}