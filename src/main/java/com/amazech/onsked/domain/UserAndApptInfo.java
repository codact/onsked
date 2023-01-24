package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAndApptInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8111912076930300434L;
	
	private String firstName;
	private String cellPhone;
	private String email;
	private String svcId;
	private String prodId;
	private String pickUpDate;
	private String pickUpTime;
	private String bizId;
	private String locId;
	private String resId;
	private String isInstore;
	

}
