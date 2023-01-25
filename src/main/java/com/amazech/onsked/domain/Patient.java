package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Patient implements Serializable {
	private static final long serialVersionUID = 4861059402831272480L;
	private Integer patientId;
	private Integer clientId;
	private Integer bizId;
	private String socialSecurityNumber;
	private String isActive;
	private String addressLine1;
	private String addressLine2;
	private String firstName;
	private String lastName;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;
	private String email;
	private String recordNum;
	private String gender;
	private String cellPhone;
	private String dateOfBirth;

}