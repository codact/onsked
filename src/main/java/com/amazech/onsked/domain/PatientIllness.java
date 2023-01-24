package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;


@Data
public class PatientIllness implements Serializable {
	private static final long serialVersionUID = 2313663245479072264L;
	private Integer patientId;
	private String illnessId;
	private String illnessName;
	private String medicalCode;
	private String description;
	private String illnessDescription; 
	private Integer patientIllnessId;
	private String isActive;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;

}