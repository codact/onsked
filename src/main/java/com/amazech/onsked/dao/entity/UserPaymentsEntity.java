package com.amazech.onsked.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="user_payments")
public class UserPaymentsEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
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
	private String mode;
	private Integer limitResources;
	private String packageExpiryDate;

}