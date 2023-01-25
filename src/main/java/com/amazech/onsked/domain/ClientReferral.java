package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ClientReferral implements Serializable {

	private Integer clientId;
	private Integer bizId;
	private String email;
	private String friendFirstName;
	private String friendLastName;
	private String friendemail;
	private String friendCellPhone;
	private String physicianFirstName;
	private String physicianLastName;
	private String physicianemail;
	private String physicianCellPhone;
	private String physicianHospital;
	private String insuranceReferralId;
	private String insuranceCellPhone;
	private String insuranceCompanyName;
	private Date createdDt;
	private Date modifiedDt;
	private Integer createdBy;
	private Integer modifiedBy;


}
