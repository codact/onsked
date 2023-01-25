package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class PremiumUser implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String cardHolderName;
	private String creditCardType;
	private String creditCardNumber;
	private String securityCode;
	private String cardExpiryDate;
	private String cardExpiryDateAsMMyyyy;
	//private String cardIssuingBank;
	//private String cardIssuingCountry;
	
	//From User
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String countryCode;
	
	//From UserPayments
	private Integer paymentId;
	private String levelId;
	private String confirmationNumber;
	private Integer paymentMode;
	private String gatewayTransactionId;
	private String additionalDetails;
	private String amount;
	private Date paymentDt;
	private Date createdDt;
	private String packageExpiryDate;


}