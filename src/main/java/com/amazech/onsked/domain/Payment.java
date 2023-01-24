package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Payment implements Serializable {
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

    private String amount;

    //From UserPayments
    private Integer paymentId;
    private String levelId;
    private String confirmationNumber;
    private Integer paymentMode;
    private String gatewayTransactionId;
    private String additionalDetails;
    private String apptInfo;

    private String purpose;
    private Date paymentDt;
    private Date createdDt;
    private String packageExpiryDate;

    private int apptId;
    private String paymentDiscription;

    private String authorizeApiLogInId;
    private String authorizeTransactionKey;
    private String scr;
}
