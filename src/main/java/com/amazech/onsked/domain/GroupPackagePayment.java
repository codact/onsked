package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GroupPackagePayment implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer groupPkgPaymentId;
	private Integer groupPkgPurchaseId;
	private String confirmationNumber;
	private String amount;
	private Integer paymentMode;
	private String gatewayTransactionId;
	private Date paymentDt;
	private Date createdDt;


}
