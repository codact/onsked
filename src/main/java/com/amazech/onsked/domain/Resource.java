package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.WeakHashMap;

import lombok.Data;

@Data
public class Resource implements Serializable {
	private static final long serialVersionUID = 4226114733138608484L;
	private Integer resId;
	private Integer resCertId;
	private Integer bizId;
	private String firstName;
	private String lastName;
	private String nickName;
	private String description;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateCode;
	private String zipCode;
	private String countryCode;
	private String email;
	private String cellPhone;
	private String homePhone;
	private String workPhone;
	private String workPhoneExt;
	private String isActive;
	private Date createdDt;
	private Integer createdBy;
	private Date modifiedDt;
	private Integer modifiedBy;
	private String onskedUserId;
	private String isOnskedUser;
	private Integer userId;
	private Integer isAllDays;
	private Integer resourceLevel;
	private Double ratePerHour;
	private String rphEffectiveDate;
	private Double payoutPercentage;
	private String ppEffectiveDate;
	
	//From Location
	private Integer locId;
	private String locName;

	
	//From Service
	private String svcId;
	private String svcList;

	private String serviceCode;

	// Details of 'resource Hours'
	private String dayOfWeek;
	private String isOpen;
	private String openTime;
	private String openTimeMin;
	private String openTimeAmPm;
	private String closeTime;
	private String closeTimeMin;
	private String closeTimeAmPm;
	private String certificateNumber;
	private String certificateName;
	private String certificateCompletionDate;
	private String certificateExpirationDate;
	private String certificateOrganization;
	
	//Resource Role Type
	private String resRoleTypeCode;
	private String resRoleTypeName;
//	private List<ResourceRoleType> resoureTypeDetails = ListUtils.lazyList(new ArrayList<ResourceRoleType>(), FactoryUtils.instantiateFactory(ResourceRoleType.class));;

}