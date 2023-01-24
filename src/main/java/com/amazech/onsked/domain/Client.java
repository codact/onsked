package com.amazech.onsked.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Data
public class Client implements Serializable{
	private static final long serialVersionUID = 4233687461047904862L;
	private Integer clientId;
	private Integer bizId;
	private String bizName;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private String dateOfBirthAsYYYYMMDD;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String stateCode;
	private String zipCode;
	private String countryCode;
	private String cellPhone;
	private Boolean clientNotifyBySMSFlag;
	private String notifyBySMS;
	private String homePhone;
	private String workPhone;
	private String bloodGroup;
	private String emergencyContactNo;
	private String referralType;
	private String workPhoneExt;
	private String isActive;
	private Date createdDt;
	private Date modifiedDt;
	private Integer createdBy;
	private Integer modifiedBy;
	private String udf1;
	private String udf2;
	private String udf3;
	private String udf4;
	private String udf5;
	private String udf1Name;
	private String udf2Name;
	private String udf3Name;
	private String udf4Name;
	private String udf5Name;
	private String clientInsuranceName;
	private String clientReferredSource;
	
	private String friendFirstName;
	private String friendLastName;
	private String friendemail;
	private String friendCellPhone;
	
	private String count;
	private String countCompleted;
	private String countConfirmed;
	private String countCancelled;
	private String countCompletedAwaitingPin;
	private String countCompletedWithPin;
	private String countDidnotCome;
	private String countPending;
	private String countCancelledByBusiness;
	private String value;
	private String isOnskedUser;
	private String availedProducts;
	private String availedLocations;
	private String lastAppointmentDateAndtime;
	

}