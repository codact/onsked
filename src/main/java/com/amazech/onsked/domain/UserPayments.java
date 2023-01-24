package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserPayments implements Serializable{
	private static final long serialVersionUID = 807813775180515873L;
	private Integer paymentId;
	private Integer userId;
	private Integer levelId;
	private String confirmationNumber;
	private Integer paymentMode;
	private String gatewayTransactionId;
	private String additionalDetails;
	private String amount;
	private Date paymentDt;
	private Date createdDt;
	
	//From Payment Modes
	private String mode;
	
	//From Upgrade Options
	private Integer limitResources;
	private String packageExpiryDate;

}