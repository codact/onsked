package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class ClientInsurance implements Serializable {
	
	private Integer clientInsuranceId;
	private Integer clientId;
	private Integer bizId;
	private String insuranceReferralId;
	private String insuranceCellPhone;
	private String insuranceCompanyName;
	private Date createdDt;
	private Date modifiedDt;
	private Integer createdBy;
	private Integer modifiedBy;

}
