package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;


@Data
public class Location implements Serializable {
	private static final long serialVersionUID = 2700894580625195953L;
	private Integer locId;
	private Integer bizId;
	private String locName;
	private String logo;
	private String description;
	private String categoryCode;
	private String contactFirstName;
	private String contactLastName;
	private String contactEmail;
	private String contactPhone;
	private String website;
	private String isSearchable;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateCode;
	private String zipCode;
	private String countryCode;
	private String currencyCode;
	private String timeZoneCode;
	private String timezone;
	private String curTime;
	private String phoneNumber1;
	private String phoneNumber2;
	private String faxNumber;
	private String isHeadquarters;
	private String isActive;
	private String tax;
	


	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;
	private String state;
	private String customMessage;
	private boolean autoApproveRequestFlag;
	private boolean allowMultipleApptsFlag;
	private String autoApproveRequest;
	private String allowMultipleAppts;
	private Integer apptGranularity;
	private String serviceName;


	// Details of 'Location Hours'
	private String dayOfWeek;
	private String isOpen;
	private String openTime;
	private String openTimeMin;
	private String openTimeAmPm;
	private String closeTime;
	private String closeTimeMin;
	private String closeTimeAmPm;

	// Details for 'Resource'
	private Integer resId;

	//For search functionality
	private String searchElement;
	
	// google map
	private String name;
	private String address;
	private Float lat;
	private Float lng;
	private String distance;
	private String bizName;
	private String loction;

}