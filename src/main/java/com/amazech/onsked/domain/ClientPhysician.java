package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class ClientPhysician implements Serializable {

	private Integer clientPhysicianId;
	private Integer clientId;
	private Integer bizId;
	private String physicianFirstName;
	private String physicianLastName;
	private String physicianEmail;
	private String physicianCellPhone;
	private String physicianHospital;
	private Date createdDt;
	private Date modifiedDt;
	private Integer createdBy;
	private Integer modifiedBy;

}
