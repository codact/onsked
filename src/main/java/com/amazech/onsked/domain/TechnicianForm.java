package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TechnicianForm implements Serializable{
	
	private static final long serialVersionUID = 4861059402831272480L;
	
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private String addressLine1;
	private String serviceName;
	private String cellPhone;
	
	private String techFormId;
	private String technicianId;
	private String repairTimeIn;
	private String repairTimeOut;
	private String phoneCarrierName;
	private String storage;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	
	private String productRepairId;
	private String apptId;
	private String comments;
	
	private String productModelName;
	private String productModelTypeName;
	private String productIssueName;
//	private List<ProductHardwareIssue> prodHardwareIssueList = ListUtils.lazyList(new ArrayList<ProductHardwareIssue>(), FactoryUtils.instantiateFactory(ProductHardwareIssue.class));
//	private List<ProductPartsUsed> productPartsUsedList = ListUtils.lazyList(new ArrayList<ProductPartsUsed>(), FactoryUtils.instantiateFactory(ProductPartsUsed.class));
	private String formStatusCode;
	private String formStatusName;

}
