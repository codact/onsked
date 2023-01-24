package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class PatientEncounter implements Serializable{
	private static final long serialVersionUID = 6094131067423261583L;
	private Integer patientEncounterId;
	private String clientId;
	private String patientId;
	private String apptId;
	private String resId;
	private String locId;
	private String diagnosis;
	private String visitReason;
	private String visitReasonName;
	private String visitTypeCode;
	private String visitTypeDescription;
	private String visitStatusCode;
	private String medicalCode;
	private String medicalDescription;
	private String bloodPressure;
	private String bloodPressureSystolic;
	private String bloodPressureDiastolic;
	private String height;
	private String heightFt;
	private String heightInch;
	private String bodyTemp;
	private String weight;
	private String weightlbs;
	private String weightoz;
	private String encounterDt;
	private String encounterDtYYYYMMdd;
	private String apptStatus;
	private String returnDt;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;
	private String patientFirstName;
	private String patientLastName;
	private String resourceFirstName;
	private String resourceLastName;
	private String resourceNickName;
	private String locationName;

	
}
